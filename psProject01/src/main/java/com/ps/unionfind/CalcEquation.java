package com.ps.unionfind;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
        Map<String, Map<String, Double>> graph = new HashMap<>();
        String u, v ;

        for (int i = 0 ; i < equations.size(); i++ ) {
            u = equations.get(i).get(0);
            v = equations.get(i).get(1);

            graph.putIfAbsent(u, new HashMap<>());
            graph.get(u).put(v, values[i]);

            graph.putIfAbsent(v, new HashMap<>());
            graph.get(v).put(u, 1 / values[i]);
        }

        double[] rst = new double[queries.size()];
        
        for (int i = 0; i<queries.size(); i++) {
            rst[i] = getPathWeight(queries.get(i).get(0), queries.get(i).get(1), new HashSet<>(), graph);
            
        }

        return rst;   
    }

    private static double getPathWeight(String start, String end, Set<String> visited,
            Map<String, Map<String, Double>> graph) {

        if (!graph.containsKey(start)) {
            return -1.0;
        }

        if (graph.get(start).containsKey(end)) {
            return graph.get(start).get(end);
        }

        visited.add(start);

        for (Map.Entry<String, Double> neighbour : graph.get(start).entrySet()) {
            if (! visited.contains(neighbour.getKey())) {
                double weight = getPathWeight(neighbour.getKey(), end, visited, graph);
                if (weight != -1.0) {
                    return weight * neighbour.getValue();
                }
            }
        }

        return -1.0;
    }

}
