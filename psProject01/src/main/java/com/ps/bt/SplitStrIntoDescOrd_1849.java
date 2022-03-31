package com.ps.bt;

import java.util.ArrayList;
import java.util.List;

public class SplitStrIntoDescOrd_1849 {

    public static void main(String[] args) {
        SplitStrIntoDescOrd_1849 s = new SplitStrIntoDescOrd_1849();
        System.out.println(s.splitString("64424509442147483647"));
    }

    public boolean splitString(String s) {
        List<Long> list = new ArrayList<>();
        boolean rst = backtracking(s, 0, list);
        return rst;
    }

    private boolean backtracking(String s, int idx, List<Long> list) {
        if (idx == s.length() && list.size() > 1) {
            return true;
        }

        boolean isValid = false;

        long num = 0;
        for (int i = idx; i < s.length(); i++) {
            num = num * 10 + (s.charAt(i) - '0');
            // String tmp = s.substring(idx, i);
            // long value = Long.valueOf(tmp);
            if (list.size() > 0) {
                long before = list.get(list.size() - 1);

                if (before - num == 1) {
                    list.add(num);
                    isValid = isValid || backtracking(s, i + 1, list);
                    list.remove(list.size() - 1);
                } else if (num > before) {
                    break;
                }
            } else {
                list.add(num);
                isValid = isValid || backtracking(s, i + 1, list);
                list.remove(list.size() - 1);
            }
        }
        return isValid;
    }
}
