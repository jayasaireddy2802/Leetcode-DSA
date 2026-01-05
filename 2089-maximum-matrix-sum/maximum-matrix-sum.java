class Solution {
    public long maxMatrixSum(int[][] matrix) {
        long sum = 0;
        long mini = Integer.MAX_VALUE;
        int ct = 0;

        for(int[] mat : matrix)
        {
            for(int num : mat)
            {
                if(num < 0)
                {
                    ct++;
                }
                int val =  Math.abs(num);
                sum += val;
                mini = Math.min(mini, val);
            }
        }

        return (ct % 2 == 0) ? sum : sum - mini*2;
        
    }
}