// class Solution {
//     public boolean isCovered(int x, int y, boolean[][] isBuilding)
//     {
//         int n = isBuilding.length;
//         boolean up = false, down = false, right = false, left = false;

//         int i = x - 1;
//         int j = y;
//         while(i >= 0)
//         {
//             if(isBuilding[i][j])
//             {
//                 up = true;
//                 break;
//             }
//             i--;
//         }

//         i = x;
//         j = y + 1;
//         while(j < n)
//         {
//             if(isBuilding[i][j])
//             {
//                 right = true;
//                 break;
//             }
//             j++;
//         }

//         j = y;
//         i = x + 1;
//         while(i < n)
//         {
//             if(isBuilding[i][j])
//             {
//                 down = true;
//                 break;
//             }
//             i++;
//         }


//         j = y - 1;
//         i = x;
//         while(j >= 0)
//         {
//             if(isBuilding[i][j])
//             {
//                 left = true;
//                 break;
//             }
//             j--;
//         }

//         return(up && down && left && right);

//     }
//     public int countCoveredBuildings(int n, int[][] buildings) {
//         boolean[][] isBuilding = new boolean[n][n];
//         int ans = 0;

//         for(int[] building : buildings)
//         {
//             int x = building[0] - 1;
//             int y = building[1] - 1;

//             if (x >= 0 && x < n && y >= 0 && y < n) {
//                 isBuilding[x][y] = true;
//             }
//         }

//         for(int i = 0; i < n; i++)
//         {
//             for(int j = 0; j < n; j++)
//             {
//                 if(isBuilding[i][j])
//                 {
//                     if(isCovered(i, j, isBuilding))
//                         ans++;
//                 }
//             }
//         }

//         return ans;
//     }
// }



class Solution {
    public int countCoveredBuildings(int n, int[][] buildings) {

        // For each row (y), store the minimum and maximum x
        Map<Integer, int[]> rowToXRange = new HashMap<>();

        // For each column (x), store the minimum and maximum y
        Map<Integer, int[]> colToYRange = new HashMap<>();

        // Build ranges
        for (int[] cell : buildings) {
            int x = cell[0];
            int y = cell[1];

            rowToXRange.putIfAbsent(y, new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE});
            colToYRange.putIfAbsent(x, new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE});

            int[] xRange = rowToXRange.get(y);
            xRange[0] = Math.min(xRange[0], x);
            xRange[1] = Math.max(xRange[1], x);

            int[] yRange = colToYRange.get(x);
            yRange[0] = Math.min(yRange[0], y);
            yRange[1] = Math.max(yRange[1], y);
        }

        int coveredCount = 0;

        // Count buildings strictly inside both row and column boundaries
        for (int[] cell : buildings) {
            int x = cell[0];
            int y = cell[1];

            int[] xRange = rowToXRange.get(y);
            int[] yRange = colToYRange.get(x);

            boolean insideRowBoundary = (xRange[0] < x && x < xRange[1]);
            boolean insideColBoundary = (yRange[0] < y && y < yRange[1]);

            if (insideRowBoundary && insideColBoundary) {
                coveredCount++;
            }
        }

        return coveredCount;
    }
}
