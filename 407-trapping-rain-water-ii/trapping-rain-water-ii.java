class Solution {
    public int trapRainWater(int[][] heightMap) {
        PriorityQueue<List<Integer>> pq = new PriorityQueue<>(
            Comparator.comparingInt(list -> list.get(0))
        );
        int rows = heightMap.length;
        int cols = heightMap[0].length;
        boolean[][] visited = new boolean[rows][cols];
        int total_water = 0;
        int[] dir_x = {0,-1,0,1};
        int[] dir_y = {-1,0,1,0};

        //addding the boundary elements to the pq
        for(int j = 0 ; j < cols ; j++)
        {
            visited[0][j] = true;
            pq.add(Arrays.asList(heightMap[0][j], 0, j));
        }
        for(int j = 0 ; j < cols ; j++)
        {
            visited[rows-1][j] = true;
            pq.add(Arrays.asList(heightMap[rows-1][j], rows-1, j));
        }
        for(int i = 1 ; i < rows - 1 ; i++)
        {
            visited[i][0] = true;
            pq.add(Arrays.asList(heightMap[i][0], i, 0));
        }
        for(int i = 1 ; i < rows - 1 ; i++)
        {
            visited[i][cols-1] = true;
            pq.add(Arrays.asList(heightMap[i][cols-1], i, cols-1));
        }


        while(!pq.isEmpty())
        {
            List<Integer> list = pq.poll();
            int curr_height = list.get(0);
            int curr_x = list.get(1);
            int curr_y = list.get(2);

            for(int i = 0 ; i < 4 ; i++)
            {
                int nx = curr_x + dir_x[i];
                int ny = curr_y + dir_y[i];
                if(nx >= 0 && nx < rows && ny >= 0 && ny < cols && !visited[nx][ny])
                {
                    visited[nx][ny] = true;
                    total_water += Math.max(curr_height - heightMap[nx][ny], 0);
                    pq.add(Arrays.asList(Math.max(curr_height, heightMap[nx][ny]), nx, ny));
                }
            }
        }
        return total_water;
    }
}