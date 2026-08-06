class Solution {

    public void dfs(int node, boolean[] visited, List<List<Integer>> adj) {
        visited[node] = true;

        for (int nei : adj.get(node)) {
            if (!visited[nei]) {
                dfs(nei, visited, adj);
            }
        }
    }

    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        List<List<Integer>> adj = new ArrayList<>();
        boolean[] visited = new boolean[n];

        
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] inv : invocations) {
            adj.get(inv[0]).add(inv[1]);
        }

        
        dfs(k, visited, adj);

        
        for (int[] inv : invocations) {
            int u = inv[0], v = inv[1];

            if (!visited[u] && visited[v]) {
                
                List<Integer> all = new ArrayList<>();
                for (int i = 0; i < n; i++) {
                    all.add(i);
                }
                return all;
            }
        }

       
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                ans.add(i);
            }
        }

        return ans;
    }
}