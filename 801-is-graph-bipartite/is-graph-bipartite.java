// class Solution {
//     public boolean isBipartite(int[][] graph) {
//         int v = graph.length;
//         int[] color = new int[v];
//         Queue<Integer> q = new LinkedList<>();

//         Arrays.fill(color, -1);

//         for(int i = 0; i < v; i++)
//         {
//             if(color[i] == -1){
//                 q.add(i);
//                 color[i] = 0;
//                 while(!q.isEmpty())
//                 {
//                     int n = q.poll();
//                     for(int neighbour : graph[n])
//                     {
//                         if(color[neighbour] == -1)
//                         {
//                             q.add(neighbour);
//                             color[neighbour] = (color[n] + 1) % 2;
//                         }
//                         else if(color[neighbour] == color[n])
//                             return false;
//                     }
//                 }
//             }
//         }

//         return true;
//     }
// }


// class Solution {
//     public boolean isBipartite(int[][] graph) {
//         int v = graph.length;
//         int[] color = new int[v];
//         Queue<Integer> q = new LinkedList<>();

//         // Arrays.fill(color, -1);

//         for(int i = 0; i < v; i++)
//         {
//             if(color[i] == 0){
//                 q.add(i);
//                 color[i] = 1;
//                 while(!q.isEmpty())
//                 {
//                     int n = q.poll();
//                     for(int neighbour : graph[n])
//                     {
//                         if(color[neighbour] == 0)
//                         {
//                             q.add(neighbour);
//                             color[neighbour] = (color[n] == 1) ? 2 : 1;
//                         }
//                         else if(color[neighbour] == color[n])
//                             return false;
//                     }
//                 }
//             }
//         }

//         return true;
//     }
// }



class Solution {

    public boolean dfs(int i, int c, int[] color, int[][] graph)
    {
        color[i] = c;

        for(int neighbour : graph[i])
        {
            if(color[neighbour] == 0)
            {
                int c1 = (c == 1) ? 2 : 1;
                if(!dfs(neighbour, c1, color, graph))
                    return false;
            }
            else if(color[neighbour] == color[i])
                return false;
        }

        return true;
    }

    public boolean isBipartite(int[][] graph) {
        int v = graph.length;
        int[] color = new int[v];

        for(int i = 0; i < v; i++)
        {
            if(color[i] == 0)
            {
                if(!dfs(i, 1, color, graph))
                    return false;
            }
        }

        return true;
    }
}

