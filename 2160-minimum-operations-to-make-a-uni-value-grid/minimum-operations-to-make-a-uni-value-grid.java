class Solution {
    public int minOperations(int[][] grid, int x) {
        int m = grid.length;
        int n = grid[0].length;
        int[] arr = new int[m*n];
        int i = 0;

        for(int[] arr1 : grid)
        {
            for(int num : arr1)
                arr[i++] = num; 
        }

        Arrays.sort(arr);

        int mid = (m*n)/2;
        int res =0;
        int target = arr[mid];

        for(int num : arr)
        {
            if(num % x != target % x) return -1;
            res += Math.abs(num - target) / x;
        }

        return res;
    }
}