class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int len = nums.length;
        int[] res = new int[len];
        int ct = 0, pivotCount = 0;

        for(int k = 0; k < len; k++)
        {
            if(nums[k] < pivot)
                ct++;
            if(nums[k] == pivot)
                pivotCount++;
        }

        int j = ct;
        while(pivotCount > 0)
        {
            res[j++] = pivot;
            pivotCount--;
        }

        int i = 0;

        for(int k = 0; k < len; k++)
        {
            if(nums[k] < pivot)
                res[i++] = nums[k];
            else if(nums[k] > pivot)
                res[j++] = nums[k];
        }

        return res;
    }
}