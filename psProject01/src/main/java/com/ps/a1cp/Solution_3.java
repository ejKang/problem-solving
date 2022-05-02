package com.ps.a1cp;

public class Solution_3 {

    public static void main(String[] args) {
        // int[] arr = { 3, 1, 2, 4 };
        // int[] arr = { 2, 3, 4, 5, 1 };
        // int[] arr = { 1, 2, 3, 4, 5, 6 };
        int[] arr = { 2, 3, 4, 5, 6 };
        // int[] arr = { 2, 1, 4, 3 }; // 1
        Solution_3 s = new Solution_3();
        System.out.println(s.sol(arr));
    }

    public int sol(int[] rooms) {

        int cnt = 0;
        boolean[] visited = new boolean[rooms.length];
        boolean hasLoop = false;
        for (int i = 0; i < rooms.length; i++) {
            int canVisit = rooms[i] - 1;

            if (!visited[canVisit]) {
                visited[i] = true;
                cnt++;
                visited[canVisit] = true;
                hasLoop = hasLoop | recursiveVisit(i, canVisit, rooms, visited);

            }

        }
        if (hasLoop) {
            cnt--;
        }
        // check has loop visit
        return cnt;
    }

    private boolean recursiveVisit(int startIdx, int canVisit, int[] rooms, boolean[] visited) {

        while (canVisit != rooms[canVisit] || canVisit != startIdx) {
            if (canVisit == startIdx) {
                return true;
            }
            canVisit = rooms[canVisit] - 1;
            if (!visited[canVisit]) {
                visited[canVisit] = true;
                canVisit = rooms[canVisit] - 1;
            } else {
                // return false;
            }
        }
        return true;
    }
}
