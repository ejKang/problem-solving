package com.ps.dp;

public class NumDecodings {

    public static void main(String[] args) {
        String s = "abcde";
        System.out.println(s.substring(1, 2));
        int t = Integer.valueOf("ab");
        System.out.println(t);
    }

    public int numDecodings(String s) {

        if (s == null || s.length() == 0) {
            return 0;
        }

        int length = s.length();

        int[] dp = new int[length + 1];
        dp[0] = 1;
        dp[1] = s.charAt(0) != '0' ? 1 : 0;

        for (int i = 2; i < length + 1; i++) {
            int cur = Integer.valueOf(s.substring(i-1, i));
            int prev = Integer.valueOf(s.substring(i-2, i));

            if ( cur >= 1 && cur <= 9) {
                dp[i] += dp[i-1];
            }
            if (prev >= 10 && prev <=26) {
                dp[i] += dp[i-2];
            }

        }
        return dp[length];
    }

}
