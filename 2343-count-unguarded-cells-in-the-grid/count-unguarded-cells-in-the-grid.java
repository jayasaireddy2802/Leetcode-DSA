class Solution {

    int[] dir_x = {-1, 0, 1, 0};
    int[] dir_y = {0, 1, 0, -1};

    public void dfs(int i, int j, int x, int y, boolean[][] visited, boolean[][] guard, boolean[][] wall)
    {
        int m = wall.length;
        int n = wall[0].length;

        if(i < 0 || i >= m || j < 0 || j >= n || wall[i][j] || guard[i][j])
            return ;

        visited[i][j] = true;

        dfs(i + x, j + y, x, y, visited, guard, wall);

    }
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        boolean[][] visited = new boolean[m][n];
        boolean[][] guard = new boolean[m][n];
        boolean[][] wall = new boolean[m][n];
        int ans = 0;

        for(int[] arr: guards)
        {
            guard[arr[0]][arr[1]] = true;
        }

        for(int[] arr: walls)
        {
            wall[arr[0]][arr[1]] = true;
        }

        for(int i = 0; i < m; i++)
        {
            for(int j = 0; j < n; j++)
            {
                if(guard[i][j])
                {
                    for(int dir = 0; dir < 4; dir++)
                    {
                        int x = dir_x[dir];
                        int y = dir_y[dir];

                        dfs(i + x, j + y, x, y, visited, guard, wall);
                    }
                }
            }
        }

        for(int i = 0; i < m; i++)
        {
            for(int j = 0; j < n; j++)
            {
                if(!wall[i][j] && !guard[i][j] && !visited[i][j] )
                {
                   ans++;
                }
            }
        }

        return ans;
    }
}