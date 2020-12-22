package com.ps.unionfind;

import java.util.Arrays;

public class MakeConnected {
    
    public static void main(String[] args) {
        
        int[][] con = {{0,1}, {0,2},{0,3},{1,2},{1,3}};
        System.out.println(makeConnected(6, con));

    }

    public static int makeConnected(int n, int[][] connections) {
        int [] p = new int [n];

        for ( int i =0; i< n; i++) {
            p[i] = i;
        }
        int len = connections.length;

        int cnt = 0;
        int first = 0; 
        int second = 0;

        for (int i = 0 ; i< len ; i++) {
            first = connections[i][0];
            second = connections[i][1];
            if (find(first, p) == find(second, p)) {
                cnt ++; // left connection
            } else {
                union(first, second, p);
            }
        }

        int isolation = isolation(p);

        System.out.println("cnt: "+cnt);
        System.out.println("iso: "+isolation);
        System.out.println(Arrays.toString(p));

        if (cnt >= isolation) 
            return isolation;
        else {
            return -1;
        }
    }

    private static int isolation(int[] p) {
        int rst = -1;
        for (int i = 0 ; i< p.length; i++) {
            if (p[i] == i) {
                rst++;
            }
        }
        return rst;
    }

    private static void union(int first, int second, int[] p) {
        int fParent = find(first, p);
        int sParent = find(second, p);

        if (fParent == sParent) return ;
        p[fParent]  = sParent;
    }

    private static int find(int i, int[] parent) {

        while (i != parent[i]) {
            i = parent[i];
        }
        return i;
    }
}
