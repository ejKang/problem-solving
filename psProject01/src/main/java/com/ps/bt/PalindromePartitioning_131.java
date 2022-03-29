package com.ps.bt;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning_131 {
    public static void main(String[] args) {
        PalindromePartitioning_131 p = new PalindromePartitioning_131();
        p.partition("aab");
    }

    public List<List<String>> partition(String s) {

        List<List<String>> rst = new ArrayList<>();
        List<String> list = new ArrayList<>();
        int idx = 0;
        backtracking(rst, list, s, idx);
        return rst;
    }

    private void backtracking(List<List<String>> rst, List<String> list, String s, int i) {
        if (i == s.length()) {
            rst.add(new ArrayList<>(list));
            return;
        }

        for (int j = i + 1; j <= s.length(); j++) {
            String sub = s.substring(i, j);
            if (isPalindrome(sub)) {
                list.add(sub);
                backtracking(rst, list, s, j);
                list.remove(list.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String sub) {
        int i = 0;
        int j = sub.length() - 1;
        while (j >= i) {
            if (sub.charAt(i) == sub.charAt(j)) {
                i++;
                j--;
            } else {
                return false;
            }
        }
        return true;
    }
}
