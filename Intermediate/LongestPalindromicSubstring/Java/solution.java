class Solution {
    public String longestPalindrome(String s) {
        Boolean[][] dp = new Boolean[s.length()][s.length()];
        String res = "";

        // initialising the dp array
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                if (i == j) {
                    dp[i][j] = true;
                    if (res.length() < j - i + 1) {
                        res = s.substring(i, j + 1);
                    }
                } else if (s.charAt(i) == s.charAt(j) && j - i == 1) {
                    dp[i][j] = true;
                    if (res.length() < j - i + 1) {
                        res = s.substring(i, j + 1);
                    }
                } else {
                    dp[i][j] = false;
                }
            }
        }


        // determine the longest palindromic substring
        for (int gap = 3; gap <= s.length(); gap++) {
            for (int start = 0; start <= s.length() - gap; start++) {
                int end = start + gap - 1;
                if (s.charAt(start) == s.charAt(end) && dp[start + 1][end - 1]) {
                    dp[start][end] = true;
                    if (res.length() < end - start + 1) {
                        res = s.substring(start, end + 1);
                    }
                }
            }
        }

        return res;
    }
}