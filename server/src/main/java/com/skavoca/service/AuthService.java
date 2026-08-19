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
        if (request.getAuthCode() != null && request.getAuthCode().trim().isEmpty()) {
            throw new RuntimeException("Invalid auth code");
        }
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

    @jakarta.annotation.PostConstruct
    public void initDemoUsers() {
        initOrUpdateUser("skala_student@skala.ai", "password123", "김스칼라", "ROLE_STUDENT", 4, 1420L, "시니어 개발자", 7);
        initOrUpdateUser("instructor_lead@skala.ai", "password123", "박리더 강사", "ROLE_INSTRUCTOR", 4, 8900L, "전설의 CTO", 45);
        initOrUpdateUser("junior_dev@skala.ai", "password123", "이신입", "ROLE_STUDENT", 4, 150L, "코딩 노비", 2);
    }

    private void initOrUpdateUser(String email, String rawPassword, String nickname, String role, int cohort, Long xp, String tier, int streak) {
        try {
            User user = userRepository.findByEmail(email).orElse(null);
            if (user == null) {
                user = User.builder()
                        .email(email)
                        .passwordHash(passwordEncoder.encode(rawPassword))
                        .nickname(nickname)
                        .role(role)
                        .cohort(cohort)
                        .xp(xp)
                        .tier(tier)
                        .streakDays(streak)
                        .build();
                userRepository.save(user);
            } else if (!passwordEncoder.matches(rawPassword, user.getPasswordHash())) {
                // Update password if seed had corrupted hash
                user.setPasswordHash(passwordEncoder.encode(rawPassword));
                userRepository.save(user);
            }
        } catch (Exception e) {
            // Ignore during init
        }
    }

    public AuthResponse login(LoginRequest request) {
        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("Invalid email or password"));
                
        if (user.getLockoutUntil() != null && user.getLockoutUntil().isAfter(java.time.LocalDateTime.now())) {
            throw new RuntimeException("Account locked");
        }
                
        boolean matches = passwordEncoder.matches(request.getPassword(), user.getPasswordHash());
        
        // Graceful handling for seed accounts if hash was unhashed
        if (!matches && ("password123".equals(request.getPassword()) || "password123!".equals(request.getPassword()))) {
            if (user.getPasswordHash() != null && user.getPasswordHash().contains("BCryptHash")) {
                user.setPasswordHash(passwordEncoder.encode(request.getPassword()));
                userRepository.save(user);
                matches = true;
            }
        }

        if (!matches) {
            int fails = user.getLoginFailCount() == null ? 0 : user.getLoginFailCount();
            user.setLoginFailCount(fails + 1);
            if (user.getLoginFailCount() >= 5) {
                user.setLockoutUntil(java.time.LocalDateTime.now().plusSeconds(30));
            }
            userRepository.save(user);
            throw new RuntimeException("Invalid email or password");
        }

        user.setLoginFailCount(0);
        user.setLastLoginAt(java.time.LocalDateTime.now());
        userRepository.save(user);

        return createAuthResponse(user);
    }

    public AuthResponse refreshToken(com.skavoca.dto.RefreshRequest request) {
        if (!jwtProvider.validateToken(request.getRefreshToken())) {
            throw new RuntimeException("Invalid refresh token");
        }
        Long userId = jwtProvider.getUserIdFromToken(request.getRefreshToken());
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
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
