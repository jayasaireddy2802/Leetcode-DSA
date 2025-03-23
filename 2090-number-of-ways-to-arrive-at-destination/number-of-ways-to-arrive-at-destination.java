// class Solution {
//     public int countPaths(int n, int[][] roads) {
//         int edges = roads.length;
//         List<List<int[]>> adj = new ArrayList<>();
//         PriorityQueue<long[]> pq = new PriorityQueue<>((x, y) -> 
//             x[0] == y[0] ? Long.compare(x[1], y[1]) : Long.compare(x[0], y[0]));
//         long[] dist = new long[n];
//         int[] ways = new int[n];
//         int mod = (int)1e9 + 7;
//         Arrays.fill(dist, Long.MAX_VALUE);
//         dist[0] = 0;
//         ways[0] = 1;

//         for(int i = 0; i < n; i++)
//         {
//             adj.add(new ArrayList<>());
//         }

//         for(int i = 0; i < edges; i++)
//         {
//             int u = roads[i][0];
//             int v = roads[i][1];
//             int cost = roads[i][2];

//             adj.get(u).add(new int[]{v, cost});
//             adj.get(v).add(new int[]{u, cost});
//         }

//         pq.add(new long[]{0, 0});

//         while(!pq.isEmpty())
//         {
//             long[] arr = pq.poll();
//             long dis = arr[0];
//             int node = (int)arr[1];

//             if(dis > dist[node])
//                  continue ;
//             for(int[] adjNodes : adj.get(node))
//             {
//                 int edgeWeight = adjNodes[1];
//                 int neighbour = adjNodes[0];

//                 if(dis + edgeWeight == dist[neighbour])
//                 {
//                      ways[neighbour] = (ways[neighbour] + ways[node])%mod;
//                 }
//                 else if(dis + edgeWeight < dist[neighbour])
//                 {
//                     dist[neighbour] = dis + edgeWeight;
//                     pq.add(new long[]{dist[neighbour], neighbour});
//                     ways[neighbour] = ways[node];
//                 }
//             }
//         }

//         return ways[n-1];
//     }
// }


class Solution {
    public int countPaths(int n, int[][] roads) {
        int mod = (int)1e9 + 7;
        int[] ways = new int[n];
        long[] distance = new long[n];
        Arrays.fill(distance, (long)1e16);
        PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparingLong(a -> a[0]));
        List<List<int[]>> adj = new ArrayList<>();

        for(int i = 0; i < n; i++)
        {
            adj.add(new ArrayList<>());
        }

        for(int[] road : roads)
        {
            int u = road[0];
            int v = road[1];
            int time = road[2];

            adj.get(u).add(new int[]{v, time});
            adj.get(v).add(new int[]{u, time});
        }

        ways[0] = 1;
        distance[0] = 0;

        pq.add(new long[]{0, 0});

        while(!pq.isEmpty())
        {
            long[] arr = pq.poll();
            long time = arr[0];
            int node = (int)arr[1];

            if(time > distance[node])
                continue;

            for(int[] adjNodes : adj.get(node))
            {
                int neighbour = adjNodes[0];
                long newTime = time + adjNodes[1];
                
                if(newTime == distance[neighbour])
                {
                    ways[neighbour] = (ways[neighbour] + ways[node])%mod;
                }
                else if(newTime < distance[neighbour])
                {
                    distance[neighbour] = newTime;
                    ways[neighbour] = (ways[node])%mod;
                    pq.add(new long[]{newTime, neighbour});
                }
            }

        }
        return ways[n-1];
    }
}















