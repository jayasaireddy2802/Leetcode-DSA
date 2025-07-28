class Solution {

    public void generateSubsequence(int idx, int[] nums, int val, List<Integer> list)
    {
        if(idx >= nums.length)
        {
            list.add(val);
            return ;
        }

        generateSubsequence(idx + 1, nums, val | nums[idx], list);
        generateSubsequence(idx + 1, nums, val , list);
    }

    public int countMaxOrSubsets(int[] nums) {
        List<Integer> list = new ArrayList<>();

        generateSubsequence(0, nums, 0, list);

        int maxi = 0;
        int ans = 0;

        for(int num : list)
            maxi = Math.max(maxi, num);
        for(int num : list)
        {
            if(num == maxi)
                ans++;
        }

        return ans;
    }
}