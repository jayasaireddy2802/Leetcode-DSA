class Solution {
    public boolean check(int i, int j, int[] nums)
    {
        Set<Integer> set = new HashSet<>();
        for(int k = i; k < j; k++)
        {
            set.add(nums[k]);
        }
        return set.size() == (j-i);
    }
    public int minimumOperations(int[] nums) {

        int j = nums.length;
        int i = 0;
        int ans = 0;

       
        
        while(true)
        {
            
            if(check(i, j, nums))
            {
                break;
            }
            else if(j - i < 3)
            {
                ans++;
                break;
            }

            else
            {
                ans++;
                i = i + 3;
                
            }
        }
        return ans;
        
    }
}