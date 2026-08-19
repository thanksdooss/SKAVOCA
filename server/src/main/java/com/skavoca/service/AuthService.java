package com.skavoca.service;

import com.skavoca.config.JwtProvider;
import com.skavoca.dto.AuthResponse;
import com.skavoca.dto.LoginRequest;
import com.skavoca.dto.SignupRequest;
import com.skavoca.entity.User;
import com.skavoca.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtProvider jwtProvider;

    public AuthService(UserRepository userRepository, PasswordEncoder passwordEncoder, JwtProvider jwtProvider) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtProvider = jwtProvider;
    }

    public AuthResponse signup(SignupRequest request) {
        if (userRepository.existsByEmail(request.getEmail())) {
            throw new RuntimeException("Email already in use");
        }

        User user = User.builder()
                .email(request.getEmail())
                .passwordHash(passwordEncoder.encode(request.getPassword()))
                .nickname(request.getNickname())
                .cohort(request.getCohort() != null ? request.getCohort() : 4)
                .role("ROLE_STUDENT")
                .xp(0L)
                .tier("코딩 노비")
                .streakDays(0)
                .build();
        
        userRepository.save(user);
        
        return createAuthResponse(user);
    }

    public AuthResponse login(LoginRequest request) {
        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("Invalid email or password"));
                
        if (!passwordEncoder.matches(request.getPassword(), user.getPasswordHash())) {
            throw new RuntimeException("Invalid email or password");
        }

        return createAuthResponse(user);
    }

    private AuthResponse createAuthResponse(User user) {
        String accessToken = jwtProvider.generateAccessToken(user.getUserId(), user.getEmail(), user.getRole());
        String refreshToken = jwtProvider.generateRefreshToken(user.getUserId());
        
        return new AuthResponse(
                accessToken,
                refreshToken,
                user.getUserId(),
                user.getNickname(),
                user.getRole(),
                user.getTier()
        );
    }
}
