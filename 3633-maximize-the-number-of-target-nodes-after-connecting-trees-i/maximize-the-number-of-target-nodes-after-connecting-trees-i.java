class Solution {

    public int[] findDistance(int[][] edges, int k) {
        int N = edges.length + 1;
        int[] result = new int[N];
        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < N; i++)
            adj.add(new ArrayList<>());

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        // bfs call for each node
        for (int i = 0; i < N; i++) {
            Queue<Integer> queue = new LinkedList<>();
            boolean[] visited = new boolean[N];
            visited[i] = true;
            queue.add(i);
            int k1 = k;
            int ct = 0;

            while (!queue.isEmpty()) {
                int size = queue.size();
                if (k1 < 0)
                    break;

                for (int j = 0; j < size; j++) {
                    int node = queue.poll();

                    ct++;

                    for (int neighbour : adj.get(node)) {
                        if (!visited[neighbour]) {
                            queue.add(neighbour);
                            visited[neighbour] = true;
                        }
                    }

                }

                k1--;
            }

            result[i] = ct;
        }

        return result;
    }

    public int[] maxTargetNodes(int[][] edges1, int[][] edges2, int k) {

        int N1 = edges1.length + 1;
        int N2 = edges2.length + 1;

        int[] result1 = findDistance(edges1, k);
        int[] result2 = findDistance(edges2, k - 1);

        int maxi = Integer.MIN_VALUE;

        for (int j = 0; j < N2; j++)
            maxi = Math.max(maxi, result2[j]);

        for (int i = 0; i < N1; i++) {
            result1[i] = result1[i] + maxi;

        }

        return result1;
    }
}