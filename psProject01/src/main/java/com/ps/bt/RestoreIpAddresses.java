package com.ps.bt;

import java.util.ArrayList;
import java.util.List;

public class RestoreIpAddresses {
    public List<String> restoreIpAddresses1(String s) {
        List<String> rst = new ArrayList<>();
        bt(rst, s, "", 0, 0);
        return rst;
    }

    private void bt(List<String> rst, String s, String temp, int idx, int depth) {
        if (s.length() == idx && depth == 4) {

            rst.add(temp.substring(0, temp.length() - 1));
            return;
        }

        if (depth > 4) {
            return;
        }

        for (int i = 1; i < 4; i++) {
            if (idx + i > s.length()) {
                return;
            }
            String p = s.substring(idx, idx + i);
            int pp = Integer.parseInt(p);
            if (p.startsWith("0") && p.length() > 1) {
                return;
            }
            if (pp > 255) {
                continue;
            }
            bt(rst, s, temp + s.substring(idx, idx + i) + ".", idx + i, depth + 1);
        }
    }

    public List<String> restoreIpAddresses(String s) {
        List<String> rst = new ArrayList<>();

        if (s.length() > 12) {
            return rst;
        }

        // backtraking(rst, "", s, 0);
        backtracking(rst, "", s, 0);
        return rst;
    }

    public void backtracking(List<String> rst, String tempStr, String s, int idx) {
        if (idx == 4) {
            if (s.length() == 0) {
                rst.add(tempStr.substring(0, tempStr.length() - 1));
                return;
            }
        }
        for (int i = 1; i < 4; i++) {
            if (s.length() < i) {
                continue;
            }

            int val = Integer.parseInt(s.substring(0, i));
            if (val > 255 || i != String.valueOf(val).length()) {
                continue;
            }

            backtracking(rst, tempStr + val + ".", s.substring(i), idx + 1);
        }
    }

    public void backtraking(List<String> rst, String tempStr, String s, int startIdx) {
        if (tempStr.length() > s.length() + 3) {
            return;
        } else if (tempStr.length() == s.length() + 3) {
            if (tempStr.split("\\.").length > 4) {
                return;
            }

            rst.add(tempStr);
        } else {
            for (int i = 1; i < 4; i++) {
                if (startIdx + i > s.length()) {
                    break;
                }
                String a = s.substring(startIdx, startIdx + i);

                if (a.charAt(0) == '0' && a.length() > 1) {
                    continue;
                } else if (Integer.parseInt(a) > 255) {
                    continue;
                }

                if (tempStr.length() == 0) {
                    backtraking(rst, a, s, startIdx + i);
                } else {
                    backtraking(rst, tempStr + "." + a, s, startIdx + i);
                }

            }
        }
    }

    public static void main(String[] args) {
        RestoreIpAddresses ii = new RestoreIpAddresses();
        List<String> ss = ii.restoreIpAddresses1("25525511135");
        System.out.println(ss.toString());
    }
}
