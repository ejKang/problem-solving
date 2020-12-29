package com.ps.unionfind;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

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

        List<String> list3 = new ArrayList<>();
        list3.add("Min");
        list3.add("11ffeee@mail.com");
        list3.add("ggggg@mailcom");
        accounts.add(list3);


        List<List<String>> rst = accountsMerge(accounts);
        System.out.println(rst);
    }

    public static List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, Set<String>> graph = new HashMap<>();

        Map<String, String> name = new HashMap<>();

        for (List<String> account : accounts) {
            // account : name - email 1 - email 2 - email 3 ..
            String userName = account.get(0);

            for (int i = 1 ; i < account.size(); i++) {
                if (!graph.containsKey(account.get(i))) {
                    graph.put(account.get(i), new HashSet<>());
                }
                name.put(account.get(i), userName);

                if (i == 1) continue;

                graph.get(account.get(i-1)).add(account.get(i));
                graph.get(account.get(i)).add(account.get(i-1));
            }
        }

        Set<String> visited = new HashSet<>();
        List<List<String>> rst = new LinkedList<>();

        for (String email : name.keySet()) {
            List<String> list = new LinkedList<>();
            if (visited.add(email)) {
                // new email 
                dfs(graph, email, visited, list);
                Collections.sort(list);
                list.add(0, name.get(email));
                rst.add(list);
            }
        }
        return rst;   
    }

    private static void dfs(Map<String, Set<String>> graph, String email, Set<String> visited, List<String> list) {
        list.add(email);

        for (String next : graph.get(email) ) {

            if (visited.add(next)) {
                // new email 
                dfs(graph, next, visited, list);
            }
        }
    }
}
