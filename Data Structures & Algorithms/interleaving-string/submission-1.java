public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {

        int m = s1.length(); // length of first string
        int n = s2.length(); // length of second string

        // If total lengths don't match, interleaving is impossible
        if (m + n != s3.length()) {
            return false;
        }

        /*
         * dp[i][j] = true means:
         * Using s1 from index i onward
         * and s2 from index j onward,
         * we can form the remaining part of s3 starting at index (i + j).
         */
        boolean[][] dp = new boolean[m + 1][n + 1];

        // Base case:
        // Empty part of s1 + Empty part of s2 = Empty part of s3
        dp[m][n] = true;

        // Fill DP table from bottom-right to top-left
        for (int i = m; i >= 0; i--) {
            for (int j = n; j >= 0; j--) {

                // Option 1:
                // Take current character from s1
                if (i < m &&
                    s1.charAt(i) == s3.charAt(i + j) &&
                    dp[i + 1][j]) {

                    dp[i][j] = true;
                }

                // Option 2:
                // Take current character from s2
                if (j < n &&
                    s2.charAt(j) == s3.charAt(i + j) &&
                    dp[i][j + 1]) {

                    dp[i][j] = true;
                }
            }
        }

        // Answer: Can entire s1 and s2 form entire s3?
        return dp[0][0];
    }
}