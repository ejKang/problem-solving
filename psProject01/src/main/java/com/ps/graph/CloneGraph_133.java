package com.ps.graph;

import java.util.HashMap;
import java.util.Map;

import com.ps.base.graph.Node;

public class CloneGraph_133 {

    public static void main(String[] args) {
        Node root = new Node(1);
        Node two = new Node(2);
        root.neighbors.add(two);

        Node three = new Node(3);
        root.neighbors.add(three);

    }

    Map<Node, Node> map = new HashMap<>();

    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        if (map.containsKey(node)) {
            return map.get(node);
        }
        Node copy = new Node(node.val);
        map.put(node, copy);

        for (Node n : node.neighbors) {
            copy.neighbors.add(cloneGraph(n));
        }

        return copy;
    }

    public Node cloneGraph_2(Node node) {

        Map<Node, Node> map = new HashMap<>();
        Node cloned = cloneRecursive(node, map);
        return cloned;
    }

    private Node cloneRecursive(Node node, Map<Node, Node> map) {
        if (node == null) {
            return null;
        }
        Node copy = null;
        if (map.containsKey(node)) {
            copy = map.get(node);
            // return map.get(node);
        } else {
            copy = new Node(node.val);
            map.put(node, copy);
            for (Node child : node.neighbors) {
                copy.neighbors.add(cloneRecursive(child, map));
            }
        }

        return copy;
    }
}
