package com.ps.unionfind;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CalcEquation {
    
    public static void main(String[] args) {
        // equations = [["a","b"],["b","c"]], values = [2.0,3.0],
        //  queries = [["a","c"],["b","a"],["a","e"],["a","a"],["x","x"]]
        List<List<String>> equations = new ArrayList<>();
        List<String> temp = new ArrayList<>();
        temp.add("a");
        temp.add("b");
        equations.add(temp);
        temp = new ArrayList<>();
        temp.add("b");
        temp.add("c");
        equations.add(temp);

        double[] values = {2.0, 3.0};

        List<List<String>> queries = new ArrayList<>();
        temp = new ArrayList<>();
        temp.add("b");
        temp.add("a");
        queries.add(temp);

        temp = new ArrayList<>();
        temp.add("a");
        temp.add("c");
        queries.add(temp);

        temp = new ArrayList<>();
        temp.add("a");
        temp.add("e");
        queries.add(temp);

        
        double[] t = calcEquation(equations, values, queries);    
        System.out.println(Arrays.toString(t));
    } 

    public static double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        return null;   
    }
}
