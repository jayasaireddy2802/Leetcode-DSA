class Solution {
    public int reverse(int num)
    {
        int val = 0;
        while(num > 0)
        {
            val = val * 10 + num % 10;
            num /= 10;
        }
        return val;
    }
    public int minMirrorPairDistance(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int len = nums.length;
        int mini = Integer.MAX_VALUE;

        for(int i = 0; i < len; i++)
        {
            int num = nums[i];
            int reverseNum = reverse(num);
            if(map.containsKey(num))
                mini = Math.min(mini, i - map.get(num));
            map.put(reverseNum, i);
        }

        return mini == Integer.MAX_VALUE ? -1 : mini;
    }
}