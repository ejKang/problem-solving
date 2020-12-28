package com.ps.unionfind;

import java.util.ArrayList;
import java.util.List;

public class AccountMerges {
    
    public static void main(String[] args) {
        List<List<String>> accounts = new ArrayList<>();
        List<String> list1 = new ArrayList<>();
        list1.add("John");
        list1.add("etserr@mail.com");
        list1.add("eeeeee@mail.com");
        accounts.add(list1);
        List<String> list2 = new ArrayList<>();
        list2.add("Min");
        list2.add("ffeee@mail.com");
        list2.add("ggggg@mailcom");
        accounts.add(list2);


        List<List<String>> rst = accountsMerge(accounts);
        System.out.println(rst);
    }

    public static List<List<String>> accountsMerge(List<List<String>> accounts) {
        return null;   
    }
}
