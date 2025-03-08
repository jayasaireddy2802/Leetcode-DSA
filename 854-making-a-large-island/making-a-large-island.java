// class Solution {
//     int[] dir_x = {-1, 0, 1, 0};
//     int[] dir_y = {0, 1, 0, -1};
//     int ans = 0;
//     int ct = 0;

//     public void dfs(int i, int j, int n, int[][] arr)
//     {
//         arr[i][j] = 0;
//         ct++;
//         for(int d = 0; d < 4; d++)
//         {
//             int nx = i + dir_x[d];
//             int ny = j + dir_y[d];

//             if(nx >= 0 && nx < n && ny >= 0 && ny < n && arr[nx][ny] == 1)
//             {
//                 dfs(nx, ny, n, arr);
//             }
//         }
//     }

//     public void solve(int[][] arr, int n)
//     {
//         for(int i = 0; i < n; i++)
//         {
//             for(int j = 0; j < n; j++)
//             {
//                 if(arr[i][j] == 1)
//                 {
//                     ct = 0;
//                     dfs(i, j, n, arr);
//                     ans = Math.max(ans, ct);
//                 }
//             }
//         }
//     }

//     public int largestIsland(int[][] grid) {
//         int n = grid.length;
//         ans = 0;
//         for(int i = 0; i < n; i++)
//         {
//             for(int j = 0; j < n; j++)
//             {
//                 if(grid[i][j] == 0)
//                 {
//                     int[][] arr = new int[n][n];
//                     for(int r = 0; r < n; r++)
//                     {
//                         arr[r] = Arrays.copyOf(grid[r], n);
//                     }
//                     arr[i][j] = 1;
//                     solve(arr, n);
                   
//                 }
//             }
//         }

//         solve(grid, n);
//         return ans;
//     }
// }

// class Solution {

//     int[] dir_x = {-1, 0, 1, 0};
//     int[] dir_y = {0, 1, 0, -1};
//     int maxArea = 0;
//     int largest = 0;
//     int size =0;

//     public void dfs(int i, int j, int n, boolean[][] visited, int[][] grid)
//     {
//         visited[i][j] = true;
//         size++;
//         for(int d = 0; d < 4; d++)
//         {
//             int nx = i + dir_x[d];
//             int ny = j + dir_y[d];

//             if(nx >= 0 && nx < n && ny >= 0 && ny < n && !visited[nx][ny] && grid[nx][ny] == 1)
//             {
//                 dfs(nx, ny, n, visited, grid);
//             }
//         }
//     }


//     public int largestIsland(int[][] grid) {
//         int n = grid.length;
//         largest = 0;
//         size = 0;
//         boolean[][] visited = new boolean[n][n];

//         for(int i = 0; i < n; i++)
//         {
//             for(int j = 0; j < n; j++)
//             {
//                 if(grid[i][j] == 1)
//                 {
//                     dfs(i, j, n, visited, grid);
//                     largest = Math.max(largest, size);
//                     size = 0;
//                 }
//             }
//         }

//         for(int i = 0; i < n; i++)
//         {
//             for(int j = 0; j < n; j++)
//             {
//                 if(grid[i][j] == 0)
//                 {
//                     visited = new boolean[n][n];
//                     grid[i][j] = 1;
//                     dfs(i, j, n, visited, grid);
//                     largest = Math.max(largest, size);
//                     size = 0;
//                     grid[i][j] = 0;                    
//                 }
//             }
//         }

        
//         return largest;
//     }
// }



// class Solution {
    
//     //  for directions
//     int[] dir_x = {-1, 0, 1, 0};
//     int[] dir_y = {0, 1, 0, -1};

//     // to find the largest island
//     int largest = 0;

//     // size of the currect island
//     int size =0;

//     // unique island id
//     int island_no = 2; 

//     // to store the island size
//     Map<Integer, Integer> map = new HashMap<>();

//     public void dfs(int i, int j, int n, boolean[][] visited, int[][] prefix)
//     {
//         visited[i][j] = true;
//         prefix[i][j] = island_no;
//         size++;
//         for(int d = 0; d < 4; d++)
//         {
//             int nx = i + dir_x[d];
//             int ny = j + dir_y[d];

//             if(nx >= 0 && nx < n && ny >= 0 && ny < n && !visited[nx][ny] && prefix[nx][ny] == 1)
//             {
//                 dfs(nx, ny, n, visited, prefix);
//             }
//         }
//     }


//     public int largestIsland(int[][] grid) {

//         int n = grid.length;
//         largest = 0;
//         size = 0;
//         island_no = 2;
//         map.clear();


//         boolean[][] visited = new boolean[n][n];
//         // int[][] prefix = new int[n][n];
//         // for(int i = 0; i < n ; i++)
//         // {
//         //     prefix[i] = grid[i].clone();
//         // }
            
//         int[][] prefix = grid;

//         for(int i = 0; i < n; i++)
//         {
//             for(int j = 0; j < n; j++)
//             {
//                 if(prefix[i][j] == 1)
//                 {
//                     dfs(i, j, n, visited, prefix);
//                     map.put(island_no, size);
//                     largest = Math.max(largest, size);
//                     island_no++;
//                     size = 0;
//                 }
//             }
//         }
       
//         for(int i = 0; i < n; i++)
//         {
//             for(int j = 0; j< n; j++)
//             {
//                 if(grid[i][j] == 0)
//                 {
//                     int size = 1;
//                     // unique islands
//                     Set<Integer> set = new HashSet<>();
//                     for(int d = 0; d < 4; d++)
//                     {
//                         int nx = i + dir_x[d];
//                         int ny = j + dir_y[d];

//                         if(nx >= 0 && nx < n && ny >= 0 && ny < n)
//                         {
//                             int id = prefix[nx][ny];
//                             if(map.containsKey(id) && !set.contains(id))
//                             {
//                                 size += map.get(id);
//                                 set.add(id);
//                             }
//                         }
//                     }
                    
//                     largest = Math.max(largest, size);
//                 }
//             }
//         }   
     
//         return largest;
//     }
// }


// Using DisjointSet 

class DisjointSet
{
    int[] parent;
    int[] rank;
    int[] size;

    public DisjointSet(int V)
    {
        rank = new int[V];
        size = new int[V];
        parent = new int[V];
        for(int i = 0; i < V; i++)
        {
            parent[i] = i;
            size[i] = 1;
        }
    }

    public int findParent(int x)
    {
        if(parent[x] == x)
            return x;
        return parent[x] = findParent(parent[x]);
    }

    public void unionByRank(int u, int v)
    {
        int parent_u = findParent(u);
        int parent_v = findParent(v);

        if(parent_u == parent_v)
            return ;
        if(parent[parent_u] > parent[parent_v])
        {
            parent[parent_v] = parent_u;
        }
        if(parent[parent_u] < parent[parent_v])
        {
            parent[parent_u] = parent_v;
        }
        if(parent[parent_u] == parent[parent_v])
        {
            parent[parent_v] = parent_u;
            rank[parent_u]++;
        }
    }

    public void unionBySize(int u, int v)
    {
        int parent_u = findParent(u);
        int parent_v = findParent(v);

        if(parent_u == parent_v)
            return ;

        if(size[parent_u] >= size[parent_v])
        {
            parent[parent_v] = parent_u;
            size[parent_u] += size[parent_v];
        }
        else
        {
            parent[parent_u] = parent_v;
            size[parent_v] += size[parent_u];
        }
    }
}

class Solution {
    public int largestIsland(int[][] grid) {
        int n = grid.length;
        DisjointSet ds = new DisjointSet(n*n);
        int[] dir_x = {-1, 0, 1, 0};
        int[] dir_y = {0, 1, 0, -1};
        int maxSize = 0;
        boolean hasOne = false;

        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < n; j++)
            {
                if(grid[i][j] == 1)
                {
                    int id = i*n + j;
                    hasOne = true;
                    for(int d = 0; d < 4; d++)
                    {
                        int nx = i + dir_x[d];
                        int ny = j + dir_y[d];

                        if(nx >= 0 && nx < n && ny >= 0 && ny < n && grid[nx][ny] == 1)
                        {
                            int id1 = nx*n + ny;
                            if( ds.findParent(id1) != ds.findParent(id))
                            {
                                ds.unionBySize(id, id1);
                            }
                        }
                    }
                }
            }
        }

        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < n; j++)
            {
                if(grid[i][j] == 0)
                {
                    int size = 1;
                    Set<Integer> set = new HashSet<>();
                    for(int d = 0; d < 4; d++)
                    {
                        int nx = i + dir_x[d];
                        int ny = j + dir_y[d];

                        if(nx >= 0 && nx < n && ny >= 0 && ny < n && grid[nx][ny] == 1)
                        {
                            int parent = ds.findParent(nx*n + ny);
                            if(!set.contains(parent))
                            {
                                size += ds.size[parent];
                                set.add(parent);
                            }
                        }
                    }

                    maxSize = Math.max(maxSize, size);
                }

            }
        }

        // if(hasOne == false)
        //     return 1;

        
        for(int i = 0; i < n * n; i++)
        {
            maxSize = Math.max(maxSize, ds.size[ds.findParent(i)]);
        }

        return maxSize;
    }
}


// class DisjointSet {
//     List<Integer> rank = new ArrayList<>();
//     List<Integer> parent = new ArrayList<>();
//     List<Integer> size = new ArrayList<>();
//     public DisjointSet(int n) {
//         for (int i = 0; i <= n; i++) {
//             rank.add(0);
//             parent.add(i);
//             size.add(1);
//         }
//     }

//     public int findUPar(int node) {
//         if (node == parent.get(node)) {
//             return node;
//         }
//         int ulp = findUPar(parent.get(node));
//         parent.set(node, ulp);
//         return parent.get(node);
//     }

//     public void unionByRank(int u, int v) {
//         int ulp_u = findUPar(u);
//         int ulp_v = findUPar(v);
//         if (ulp_u == ulp_v) return;
//         if (rank.get(ulp_u) < rank.get(ulp_v)) {
//             parent.set(ulp_u, ulp_v);
//         } else if (rank.get(ulp_v) < rank.get(ulp_u)) {
//             parent.set(ulp_v, ulp_u);
//         } else {
//             parent.set(ulp_v, ulp_u);
//             int rankU = rank.get(ulp_u);
//             rank.set(ulp_u, rankU + 1);
//         }
//     }

//     public void unionBySize(int u, int v) {
//         int ulp_u = findUPar(u);
//         int ulp_v = findUPar(v);
//         if (ulp_u == ulp_v) return;
//         if (size.get(ulp_u) < size.get(ulp_v)) {
//             parent.set(ulp_u, ulp_v);
//             size.set(ulp_v, size.get(ulp_v) + size.get(ulp_u));
//         } else {
//             parent.set(ulp_v, ulp_u);
//             size.set(ulp_u, size.get(ulp_u) + size.get(ulp_v));
//         }
//     }
// }
// class Solution {
//     private boolean isValid(int newr, int newc, int n) {
//         return newr >= 0 && newr < n && newc >= 0 && newc < n;
//     }

//     public int largestIsland(int grid[][]) {
//         int n = grid.length;
//         DisjointSet ds = new DisjointSet(n * n);
//         // step - 1
//         for (int row = 0; row < n ; row++) {
//             for (int col = 0; col < n ; col++) {
//                 if (grid[row][col] == 0) continue;
//                 int dr[] = { -1, 0, 1, 0};
//                 int dc[] = {0, -1, 0, 1};
//                 for (int ind = 0; ind < 4; ind++) {
//                     int newr = row + dr[ind];
//                     int newc = col + dc[ind];
//                     if (isValid(newr, newc, n) && grid[newr][newc] == 1) {
//                         int nodeNo = row * n + col;
//                         int adjNodeNo = newr * n + newc;
//                         ds.unionBySize(nodeNo, adjNodeNo);
//                     }
//                 }
//             }
//         }
//         // step 2
//         int mx = 0;
//         for (int row = 0; row < n; row++) {
//             for (int col = 0; col < n; col++) {
//                 if (grid[row][col] == 1) continue;
//                 int dr[] = { -1, 0, 1, 0};
//                 int dc[] = {0, -1, 0, 1};
//                 HashSet<Integer> components = new HashSet<>();
//                 for (int ind = 0; ind < 4; ind++) {
//                     int newr = row + dr[ind];
//                     int newc = col + dc[ind];
//                     if (isValid(newr, newc, n)) {
//                         if (grid[newr][newc] == 1) {
//                             components.add(ds.findUPar(newr * n + newc));
//                         }
//                     }
//                 }
//                 int sizeTotal = 0;
//                 for (Integer parents : components) {
//                     sizeTotal += ds.size.get(parents);
//                 }
//                 mx = Math.max(mx, sizeTotal + 1);
//             }
//         }
//         for (int cellNo = 0; cellNo < n * n; cellNo++) {
//             mx = Math.max(mx, ds.size.get(ds.findUPar(cellNo)));
//         }
//         return mx;
//     }

// }

// class Main {
//     public static void main (String[] args) {
//         int[][] grid = {
//             {1, 1, 0, 1, 1, 0}, {1, 1, 0, 1, 1, 0},
//             {1, 1, 0, 1, 1, 0}, {0, 0, 1, 0, 0, 0},
//             {0, 0, 1, 1, 1, 0}, {0, 0, 1, 1, 1, 0}
//         };

//         Solution obj = new Solution();
//         int ans = obj.MaxConnection(grid);
//         System.out.println("The largest group of connected 1s is of size: " + ans);
//     }
// }