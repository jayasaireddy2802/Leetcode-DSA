class Solution {

    public boolean isValid(int num)
    {
        Set<Integer> set = Set.of(2, 5, 6, 9);
        Set<Integer> set1 = Set.of(0, 1, 8);
        boolean different = false;

        while(num > 0)
        {
            int rem = num % 10;

            if(set.contains(rem)) different = true;

            else if(!set1.contains(rem)) return false;

            num /= 10;
        }

        return different;
    }
    public int rotatedDigits(int n) {
        int ans = 0;
        
        
        for(int i = 1; i <= n; i++)
        {
            if(isValid(i))
                ans++;
        }

        return ans;
    }
}