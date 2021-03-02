package com.ps.array;

import java.util.List;

public class CountMatches {
    
    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        
        int idx = 0;
        if (ruleKey.equals("type")) {
            idx = 0;
        } else if (ruleKey.equals("color")) {
            idx = 1;
        } else {
            idx = 2;
        }

        int rst = 0;
        for (List<String> list : items) {
            if (list.get(idx).equals(ruleValue)) {
                rst++;
            }
        }


        return rst;
    }
}
