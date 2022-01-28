package com.ps.string;

import java.util.ArrayList;
import java.util.List;

public class RabinKarp {

    public List<Integer> find(String parent, String pattern) {

        int parentHash = 0, patternHash = 0, power = 1;

        int parentLen = parent.length();
        int patternLen = pattern.length();

        List<Integer> idxList = new ArrayList<>();

        for (int i = 0; i < parentLen - patternLen; i++) {

            if (i == 0) {
                for (int j = 0; j < patternLen; j++) {
                    parentHash = parentHash + parent.charAt(patternLen - 1 - j) * power;
                    patternHash = patternHash + pattern.charAt(patternLen - 1 - j) * power;

                    if (j < patternLen - 1) {
                        power *= 2;
                    }
                }
            } else {
                parentHash = (parentHash - parent.charAt(i - 1) * power) * 2 + parent.charAt(i + patternLen - 1);
            }

            if (parentHash == patternHash) {
                boolean found = true;

                for (int j = 0; j < patternLen; j++) {
                    if (parent.charAt(i + j) != pattern.charAt(j)) {
                        found = false;
                        break;
                    }
                }

                if (found) {
                    idxList.add(i + 1);
                }
            }
        }

        return idxList;
    }
}
