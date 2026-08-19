package com.skavoca.service;

import org.springframework.stereotype.Service;

@Service
public class LevenshteinService {

    public String normalizeCanonical(String input) {
        if (input == null) return "";
        return input.replaceAll("[\\-\\.\\s]", "").toLowerCase();
    }

    public double calculateSimilarity(String s1, String s2) {
        if (s1 == null || s2 == null) return 0.0;
        if (s1.isEmpty() && s2.isEmpty()) return 1.0;
        if (s1.isEmpty() || s2.isEmpty()) return 0.0;
        
        int distance = calculateDistance(s1, s2);
        int maxLength = Math.max(s1.length(), s2.length());
        
        return 1.0 - ((double) distance / maxLength);
    }

    public int calculateDistance(String s1, String s2) {
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];

        for (int i = 0; i <= s1.length(); i++) {
            for (int j = 0; j <= s2.length(); j++) {
                if (i == 0) {
                    dp[i][j] = j;
                } else if (j == 0) {
                    dp[i][j] = i;
                } else {
                    int cost = (s1.charAt(i - 1) == s2.charAt(j - 1)) ? 0 : 1;
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j] + 1, dp[i][j - 1] + 1), dp[i - 1][j - 1] + cost);
                }
            }
        }
        return dp[s1.length()][s2.length()];
    }
}
