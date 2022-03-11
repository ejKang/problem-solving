package com.ps.bt;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinOfPhone_17 {
    public static void main(String[] args) {
        LetterCombinOfPhone_17 cc = new LetterCombinOfPhone_17();
        List<String> rr = cc.letterCombinations("23");
        System.out.println(rr);
    }

    Map<String, String> phone = new HashMap<String, String>() {
        {
            put("2", "abc");
            put("3", "def");
            put("4", "ghi");
            put("5", "jkl");
            put("6", "mno");
            put("7", "pqrs");
            put("8", "tuv");
            put("9", "wxyz");
        }
    };

    public List<String> letterCombinations(String digits) {

        int length = digits.length();
        List<String> rst = new ArrayList<>();
        if (length == 0) {
            return rst;
        }
        backTracking(0, length, digits, rst, "");
        return rst;
    }

    private void backTracking(int i, int length, String digits, List<String> rst, String curStr) {

        if (i == length) {
            rst.add(curStr);
            return;
        }

        String key = digits.substring(i, i + 1);
        String values = phone.get(key);

        for (int j = 0; j < values.length(); j++) {
            backTracking(i + 1, length, digits, rst, curStr + values.substring(j, j + 1));
        }

    }
}