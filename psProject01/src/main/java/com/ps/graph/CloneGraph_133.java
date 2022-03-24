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
}
