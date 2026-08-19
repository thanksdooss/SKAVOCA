package com.skala.skavoca.service;

import org.springframework.stereotype.Service;

@Service
public class LevenshteinService {

    public record FuzzyResult(int distance, double similarity, boolean isTypo) {}

    public FuzzyResult checkSimilarity(String userInput, String targetTerm) {
        if (userInput == null || targetTerm == null) {
            return new FuzzyResult(Integer.MAX_VALUE, 0.0, false);
        }

        String s1 = userInput.trim().toLowerCase();
        String s2 = targetTerm.trim().toLowerCase();

        int[][] dp = new int[s1.length() + 1][s2.length() + 1];

        for (int i = 0; i <= s1.length(); i++) dp[i][0] = i;
        for (int j = 0; j <= s2.length(); j++) dp[0][j] = j;

        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 1 + Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1]));
                }
            }
        }

        int distance = dp[s1.length()][s2.length()];
        int maxLen = Math.max(s1.length(), s2.length());
        double similarity = maxLen == 0 ? 1.0 : (1.0 - (double) distance / maxLen);

        // 80% similarity threshold for typo grace
        boolean isTypo = distance <= 2 && similarity >= 0.75 && similarity < 1.0;

        return new FuzzyResult(distance, similarity, isTypo);
    }
}
