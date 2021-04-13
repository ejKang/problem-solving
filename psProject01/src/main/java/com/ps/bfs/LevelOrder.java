package com.ps.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.ps.base.Node;

public class LevelOrder {

    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> rst = new ArrayList<>();

        if (root == null) {
            return rst;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                list.add(node.val);

                if (node.children != null) {
                    for (Node n : node.children) {
                        queue.add(n);
                    }
                }
            }
            rst.add(list);
        }
        return rst;
    }
}
