package com.ps.string;

public class RotateString_796 {

    // time complexity - o(1)
    public boolean rotateString(String s, String goal) {

        String newStr = s + s;
        if (s.length() == goal.length() && newStr.contains(goal)) {
            return true;
        }
        return false;
    }
}
