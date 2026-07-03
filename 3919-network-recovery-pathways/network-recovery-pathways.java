class Solution {

    public boolean solve(int mid, Map<Integer, List<int[]>> map, long k, int n) {

    PriorityQueue<long[]> pq = new PriorityQueue<>(
        (a, b) -> Long.compare(a[0], b[0])
    );

    long[] distance = new long[n];
    Arrays.fill(distance, Long.MAX_VALUE);

    pq.add(new long[]{0, 0});
    distance[0] = 0;

    while (!pq.isEmpty()) {

        long[] arr = pq.poll();
        long dis = arr[0];
        int node = (int) arr[1];

        if (dis > distance[node]) continue; 
        if (dis > k) break; 

        if (node == n - 1) return true;

        for (int[] adj : map.get(node)) {

            int adjNode = adj[0];
            int edgeCost = adj[1];

            if (edgeCost < mid) continue;

            if (dis + edgeCost < distance[adjNode]) {
                distance[adjNode] = dis + edgeCost;
                pq.add(new long[]{distance[adjNode], adjNode});
            }
        }
    }

    return false;
}

    public int findMaxPathScore(int[][] edges, boolean[] online, long k) {

        int n = online.length;

        Map<Integer, List<int[]>> map = new HashMap<>();

        for (int i = 0; i < n; i++)
            map.put(i, new ArrayList<>());

        int minCost = Integer.MAX_VALUE;
        int maxCost = Integer.MIN_VALUE;

        for (int[] edge : edges) {

            int u = edge[0];
            int v = edge[1];
            int cost = edge[2];

            if (online[u] && online[v]) {
                map.get(u).add(new int[]{v, cost});
            }

            minCost = Math.min(minCost, cost);
            maxCost = Math.max(maxCost, cost);
        }

        int low = minCost, high = maxCost;
        int ans = -1;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (solve(mid, map, k, n)) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return ans;
    }
}