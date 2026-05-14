class Solution {
    public boolean isGood(int[] nums) {
        int n = nums.length;
        Set<Integer> set = new HashSet<>();
        int ct = 0;

        for(int num : nums)
        {
            set.add(num);
            if(num == n - 1)
                ct++;
        }

        if(ct != 2)
            return false;

        for(int i = 1; i < n - 1; i++)
        {
            if(!set.contains(i)) 
                return false;
        }

        return true;
    }
}