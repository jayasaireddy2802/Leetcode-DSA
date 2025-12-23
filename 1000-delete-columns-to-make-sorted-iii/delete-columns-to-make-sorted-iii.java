class Solution {
    public int minDeletionSize(String[] strs) {
        int rowCount = strs.length;
        int colCount = strs[0].length();

        // lis[i] = length of longest increasing subsequence ending at column i
        int[] lis = new int[colCount];

        int maxLIS = 1;

        for (int currCol = 0; currCol < colCount; currCol++) {
            lis[currCol] = 1;

            for (int prevCol = 0; prevCol < currCol; prevCol++) {

                boolean canExtend = true;
                for (int row = 0; row < rowCount; row++) {
                    if (strs[row].charAt(prevCol) > strs[row].charAt(currCol)) {
                        canExtend = false;
                        break;
                    }
                }

                if (canExtend) {
                    lis[currCol] = Math.max(lis[currCol], lis[prevCol] + 1);
                }
            }

            maxLIS = Math.max(maxLIS, lis[currCol]);
        }

        return colCount - maxLIS;
    }
}
