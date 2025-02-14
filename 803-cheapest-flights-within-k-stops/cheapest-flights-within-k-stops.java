class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((x, y) -> x[0] - y[0]);
        List<List<int[]>> adj = new ArrayList<>();
        int[] dist = new int[n];

        Arrays.fill(dist, (int)1e7);
        dist[src] = 0;
        for(int i = 0; i < n; i++)
            adj.add(new ArrayList<>());
        
        int edges = flights.length;
        for(int i = 0; i < edges; i++)
        {
            adj.get(flights[i][0]).add(new int[]{flights[i][1], flights[i][2]});
        }

        pq.add(new int[]{0, src, 0});

        while(!pq.isEmpty())
        {
            int[] arr = pq.poll();
            int stop = arr[0];
            int node = arr[1];
            int dis = arr[2];

            
            // if(node == dst)
            //     return cost;
            if(stop <= k){
                for(int[] adjNodes : adj.get(node))
                {
                    int neighbour = adjNodes[0];
                    int weight = adjNodes[1];

                    if(dis + weight < dist[neighbour]) 
                    {
                        dist[neighbour] = dis + weight;
                        pq.add(new int[]{stop+1, neighbour, dist[neighbour]});
                    }
                }
            }
        }    
        return (dist[dst] == (int)1e7) ? -1 : dist[dst];
    }
}