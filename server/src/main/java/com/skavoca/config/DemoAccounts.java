package com.skavoca.config;

import java.util.Set;

/**
 * 공개 데모 계정 목록.
 * 데모 계정의 비밀번호는 로그인 화면에 공개되어 있으므로,
 * 누구나 로그인할 수 있다는 전제로 쓰기 권한을 제한한다.
 */
public final class DemoAccounts {

    public static final String READONLY_AUTHORITY = "DEMO_READONLY";

    public static final Set<String> EMAILS = Set.of(
            "skala_student@skala.ai",
            "instructor_lead@skala.ai",
            "junior_dev@skala.ai"
    );

    private DemoAccounts() {
    }

    public static boolean isDemo(String email) {
        return email != null && EMAILS.contains(email);
    }
}
