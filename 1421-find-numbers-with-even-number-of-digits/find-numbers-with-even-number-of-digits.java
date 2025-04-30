class Solution {
    private boolean check(int num)
    {
        int cnt = 0;
        while(num > 0)
        {
            cnt++;
            num /= 10;
        }
        return (cnt & 1) == 0;
    }
    public int findNumbers(int[] nums) {
        int ct = 0;
        for(int num : nums)
        {
            if(check(num))
                ct++;
        }
        return ct;
    }
}