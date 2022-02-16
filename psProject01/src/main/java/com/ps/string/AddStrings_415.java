package com.ps.string;

public class AddStrings_415 {

    public static void main(String[] args) {
        AddStrings_415 aa = new AddStrings_415();
        aa.addStrings("11", "123");
    }

    // time complexity - o(n+m)
    public String addStrings(String num1, String num2) {

        char[] n1 = num1.toCharArray();
        char[] n2 = num2.toCharArray();

        int nn1 = n1.length - 1;
        int nn2 = n2.length - 1;

        StringBuilder sb = new StringBuilder();
        int t1 = 0, t2 = 0;
        int carry = 0;
        while (nn1 >= 0 || nn2 >= 0 || carry > 0) {

            if (nn1 >= 0) {
                t1 = n1[nn1] - '0';
            } else {
                t1 = 0;
            }

            if (nn2 >= 0) {
                t2 = n2[nn2] - '0';
            } else {
                t2 = 0;
            }

            int tmp = t1 + t2 + carry;

            carry = tmp / 10;
            sb.append(tmp % 10);
            nn1--;
            nn2--;
        }

        return sb.reverse().toString();
    }

    public String addStrings_2(String num1, String num2) {
        int i = num1.length() - 1;
        int j = num2.length() - 1;

        int carry = 0;
        StringBuilder sb = new StringBuilder();
        while (i >= 0 || j >= 0 || carry > 0) {

            int tmp1 = 0;
            if (i >= 0) {
                tmp1 = num1.charAt(i) - '0';
            }

            int tmp2 = 0;
            if (j >= 0) {
                tmp2 = num2.charAt(j) - '0';
            }

            sb.append((tmp1 + tmp2 + carry) % 10);
            carry = (tmp1 + tmp2 + carry) / 10;

            i--;
            j--;
        }
        return sb.reverse().toString();
    }
}
