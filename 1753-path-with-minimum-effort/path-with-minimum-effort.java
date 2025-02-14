

class Solution {
     int res = Integer.MAX_VALUE;
     int[] dir_x = {-1, 0, 1, 0};
     int[] dir_y = {0, 1, 0, -1};
    
    public  int minimumEffortPath(int[][] heights) {
        // code here
        int rows = heights.length;
        int columns = heights[0].length;
        boolean[][] visited = new boolean[rows][columns];
        visited[0][0] = true;
        res = Integer.MAX_VALUE;
        PriorityQueue<int[]> queue = new PriorityQueue<>((x, y) -> x[0] - y[0]);
        
        queue.add(new int[]{0, 0, 0});
        visited[0][0] = true;
        
        while(!queue.isEmpty())
        {
            int[] arr = queue.poll();
            int x = arr[1];
            int y = arr[2];
            int effort = arr[0];
            visited[x][y] = true;
            if(x == rows - 1 && y == columns -1)
            {
                return effort;
            }
                
            for(int dir = 0; dir < 4; dir++)
            {
                int new_x = x + dir_x[dir];
                int new_y = y + dir_y[dir];
                
                if(new_x >= 0 && new_x < rows && new_y >= 0 && new_y < columns && !visited[new_x][new_y])
                {
                    int  new_effort = Math.max(effort, Math.abs(heights[x][y] - heights[new_x][new_y]));
                    queue.add(new int[]{new_effort, new_x, new_y});
                }
            }
        }
        
        return res;
    }
}
