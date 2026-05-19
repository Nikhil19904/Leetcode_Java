import java.util.*;

class Solution {

    public boolean validPath(int n, int[][] edges,
                             int source, int destination) {

        // adjacency list
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        // build graph
        for (int[] edge : edges) {

            int u = edge[0];
            int v = edge[1];

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        // BFS
        Queue<Integer> q = new LinkedList<>();

        boolean[] vis = new boolean[n];

        q.offer(source);
        vis[source] = true;

        while (!q.isEmpty()) {

            int node = q.poll();

            // destination found
            if (node == destination) {
                return true;
            }

            for (int nbr : adj.get(node)) {

                if (!vis[nbr]) {

                    vis[nbr] = true;
                    q.offer(nbr);
                }
            }
        }

        return false;
    }
}