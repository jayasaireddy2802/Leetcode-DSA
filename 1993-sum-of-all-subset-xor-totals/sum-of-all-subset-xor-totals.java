class Solution {
    int sum;

    public void solve(int idx, int[] nums, List<Integer> list)
    {
        if(idx > nums.length)
            return ;

        if(idx == nums.length)
        {
            int val = 0;
            for(int num : list)
                val = val^num;
            sum = sum + val;
            return ;
        }

        list.add(nums[idx]);
        solve(idx+1, nums, list);
        list.remove(list.size() - 1);
        solve(idx+1, nums, list);

    }

    public int subsetXORSum(int[] nums) {
        sum = 0;
        List<Integer> list = new ArrayList<>();
        solve(0, nums, list);
        return sum;
    }
}