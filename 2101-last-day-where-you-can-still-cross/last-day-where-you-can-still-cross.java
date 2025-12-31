// class Solution {
//     int[] x_dir = {0, -1, 0, 1};
//     int[] y_dir = {1, 0, -1, 0};

//     public boolean dfs(int i, int j, boolean[][] visited, boolean[][] canTravel)
//     {
//         int row = visited.length;
//         int col = visited[0].length;

//         if(i < 0 || i >= row || j < 0 || j >= col || (!canTravel[i][j]) || visited[i][j])
//             return false;

//         visited[i][j] = true;

//         if(i == row - 1 && canTravel[i][j])
//             return true;

//         for(int dir = 0; dir < 4; dir++)
//         {
//             int new_x = i + x_dir[dir];
//             int new_y = j + y_dir[dir];

//             if(dfs(new_x, new_y, visited, canTravel))
//                 return true;
//         }

//         return false;

//     }
//     public int latestDayToCross(int row, int col, int[][] cells) {
//         boolean[][] canTravel = new boolean[row][col];
//         int day = 0;

//         for(boolean[] arr : canTravel)
//             Arrays.fill(arr, true);

//         for(int[] cell : cells)
//         {
//             canTravel[cell[0] - 1][cell[1] - 1] = false;
//             boolean canReach = false;
//             for(int i = 0; i < col; i++)
//             {
//                 boolean[][] visited = new boolean[row][col];
//                 if(canTravel[0][i])
//                 {
//                     if(dfs(0, i, visited, canTravel))
//                     {
//                         canReach = true;
//                         break;
//                     }
//                 }
//             }
//             if(!canReach)
//                 return day;
//             day++;
//         }

//         return cells.length;
//     }
// }



// class Solution {
//     int[] x_dir = { 0, -1, 0, 1 };
//     int[] y_dir = { 1, 0, -1, 0 };

//     public boolean dfs(int i, int j, boolean[][] visited, boolean[][] canTravel) {
//         int row = visited.length;
//         int col = visited[0].length;

//         if (i < 0 || i >= row || j < 0 || j >= col || (!canTravel[i][j]) || visited[i][j])
//             return false;

//         visited[i][j] = true;

//         if (i == row - 1 && canTravel[i][j])
//             return true;

//         for (int dir = 0; dir < 4; dir++) {
//             int new_x = i + x_dir[dir];
//             int new_y = j + y_dir[dir];

//             if (dfs(new_x, new_y, visited, canTravel))
//                 return true;
//         }

//         return false;

//     }

//     public boolean isPossible(int mid, int row, int col, int[][] cells) {
//         boolean[][] canTravel = new boolean[row][col];
//         int len = cells.length;
//         for (boolean[] arr : canTravel)
//             Arrays.fill(arr, true);

//         for (int i = 0; i <= mid; i++) {
//             canTravel[cells[i][0] - 1][cells[i][1] - 1] = false;
//         }
//         boolean canReach = false;
//         for (int i = 0; i < col; i++) {
//             boolean[][] visited = new boolean[row][col];
//             if (canTravel[0][i]) {
//                 if (dfs(0, i, visited, canTravel)) {
//                     return true;
//                 }
//             }
//         }
//         return false;
//     }

//     public int latestDayToCross(int row, int col, int[][] cells) {
//         int i = 0;
//         int j = cells.length - 1;

//         while (i <= j) {
//             int mid = (i + j) / 2;

//             if (isPossible(mid, row, col, cells)) {
//                 i = mid + 1;
//             } else
//                 j = mid - 1;
//         }

//         return i;
//     }
// }





class Solution {
    int[] x_dir = { 0, -1, 0, 1 };
    int[] y_dir = { 1, 0, -1, 0 };

    public boolean dfs(int i, int j, boolean[][] visited, boolean[][] canTravel) {
        int row = visited.length;
        int col = visited[0].length;

        if (i < 0 || i >= row || j < 0 || j >= col || (!canTravel[i][j]) || visited[i][j])
            return false;

        visited[i][j] = true;

        if (i == row - 1 && canTravel[i][j])
            return true;

        for (int dir = 0; dir < 4; dir++) {
            int new_x = i + x_dir[dir];
            int new_y = j + y_dir[dir];

            if (dfs(new_x, new_y, visited, canTravel))
                return true;
        }

        return false;

    }

    public boolean isPossible(int mid, int row, int col, int[][] cells) {
        boolean[][] canTravel = new boolean[row][col];
        int len = cells.length;
        for (boolean[] arr : canTravel)
            Arrays.fill(arr, true);

        for (int i = 0; i <= mid; i++) {
            canTravel[cells[i][0] - 1][cells[i][1] - 1] = false;
        }
        boolean canReach = false;
        boolean[][] visited = new boolean[row][col];
        for (int i = 0; i < col; i++) {
            if (canTravel[0][i]) {
                if (dfs(0, i, visited, canTravel)) {
                    return true;
                }
            }
        }
        return false;
    }

    public int latestDayToCross(int row, int col, int[][] cells) {
        int i = 0;
        int j = cells.length - 1;

        while (i <= j) {
            int mid = (i + j) / 2;

            if (isPossible(mid, row, col, cells)) {
                i = mid + 1;
            } else
                j = mid - 1;
        }

        return i;
    }
}