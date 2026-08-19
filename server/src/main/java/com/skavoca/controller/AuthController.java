package com.skavoca.controller;

import com.skavoca.dto.AuthResponse;
import com.skavoca.dto.LoginRequest;
import com.skavoca.dto.SignupRequest;
import com.skavoca.service.AuthService;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Duration;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    private void setRefreshTokenCookie(HttpServletResponse response, String refreshToken) {
        ResponseCookie cookie = ResponseCookie.from("refreshToken", refreshToken)
                .httpOnly(true)
                .secure(true)
                .sameSite("Strict")
                .path("/api/v1/auth/refresh")
                .maxAge(Duration.ofDays(7))
                .build();
        response.addHeader("Set-Cookie", cookie.toString());
    }

    @PostMapping(value = {"/signup", "/register"})
    public ResponseEntity<AuthResponse> signup(@Valid @RequestBody SignupRequest request, HttpServletResponse httpResponse) {
        AuthResponse auth = authService.signup(request);
        setRefreshTokenCookie(httpResponse, auth.refreshToken());
        return ResponseEntity.ok(auth);
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@Valid @RequestBody LoginRequest request, HttpServletResponse httpResponse) {
        AuthResponse auth = authService.login(request);
        setRefreshTokenCookie(httpResponse, auth.refreshToken());
        return ResponseEntity.ok(auth);
    }

    @GetMapping("/health")
    public ResponseEntity<String> health() {
        return ResponseEntity.ok("OK");
    }

    @PostMapping("/refresh")
    public ResponseEntity<AuthResponse> refresh(@CookieValue(name="refreshToken", required=false) String cookieToken,
                                                @Valid @RequestBody(required=false) com.skavoca.dto.RefreshRequest request) {
        String tokenToUse = cookieToken != null ? cookieToken : (request != null ? request.getRefreshToken() : null);
        if (tokenToUse == null) {
            throw new RuntimeException("Refresh token is missing");
        }
        com.skavoca.dto.RefreshRequest actualRequest = new com.skavoca.dto.RefreshRequest();
        actualRequest.setRefreshToken(tokenToUse);
        return ResponseEntity.ok(authService.refreshToken(actualRequest));
    }

    @PostMapping("/logout")
    public ResponseEntity<Map<String,String>> logout(HttpServletResponse httpResponse) {
        ResponseCookie cookie = ResponseCookie.from("refreshToken", "")
                .httpOnly(true)
                .secure(true)
                .sameSite("Strict")
                .path("/api/v1/auth/refresh")
                .maxAge(0)
                .build();
        httpResponse.addHeader("Set-Cookie", cookie.toString());
        return ResponseEntity.ok(Map.of("message", "로그아웃 완료"));
    }
}
