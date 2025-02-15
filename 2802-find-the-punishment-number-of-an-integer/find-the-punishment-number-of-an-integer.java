class Solution {

    public boolean partition(String num, int idx, int target)
    {
        int len = num.length();

        if(idx == len)
        {
            return target == 0;
        }

        int sum = 0;

        for(int i = idx; i < len; i++)
        {
            sum = sum*10 + (num.charAt(i) - '0');
            if(sum > target)
                break;
            if(partition(num, i + 1, target - sum))
                return true;

        }
        return false;
    }

    public int punishmentNumber(int n) {
        int ans = 0;
        for(int i = 1; i <= n; i++)
        {
            int num = i*i;
            if(partition(Integer.toString(num), 0, i))
                ans = ans + num;
        }
        return ans;
    }
}