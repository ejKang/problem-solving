package com.ps.bt;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinations {
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

        List<String> rst = new ArrayList<>();
        if (digits.length() > 0) {
            bt(rst, "", digits);
        }
        return rst;
    }

    private void bt(List<String> rst, String str, String digits) {
        if (0 == digits.length()) {
            rst.add(new String(str));
        } else {
            String s = digits.substring(0, 1);
            String key = phone.get(s);

            for (char c : key.toCharArray()) {
                String letter = c + "";
                bt (rst, str+letter, digits.substring(1));
            }
        }
    }

    public static void main(String[] args) {
        LetterCombinations cc = new LetterCombinations();
        List<String> rr = cc.letterCombinations("23");
        System.out.println(rr);
    }
}
