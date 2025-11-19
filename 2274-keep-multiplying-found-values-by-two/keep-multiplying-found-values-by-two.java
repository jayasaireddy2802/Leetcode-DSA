class Solution {
    public int findFinalValue(int[] nums, int original) {
        
        while(true)
        {
            boolean found = false;
            for(int num : nums)
            {
                found = false;
                if(num == original)
                {
                    original *= 2;
                    found = true;
                    break; 
                }
            }
            if(!found)
                break;
        }
        
        return original;
    }
}