class Solution {

    public int gcd(int a, int b)
    {
        while(b != 0)
        {
            int temp = a;
            a = b;
            b = temp % b;
        }

        return a;
    }

    public long gcdSum(int[] nums) {
        int len = nums.length;
        int[] prefixGcd = new int[len];
        int max = Integer.MIN_VALUE;

        for(int i = 0; i < len; i++)
        {
            max = Math.max(max, nums[i]);
            prefixGcd[i] = gcd(max, nums[i]);
        }

        Arrays.sort(prefixGcd);

        long ans = 0;
        int left = 0;
        int right = len - 1;

        while(left < right)
        {
            ans += gcd(prefixGcd[left], prefixGcd[right]);
            left++;
            right--;
        }

        return ans;


    }
}