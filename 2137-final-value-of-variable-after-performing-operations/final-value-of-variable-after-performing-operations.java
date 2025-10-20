class Solution {
    public int finalValueAfterOperations(String[] operations) {
        int ans = 0;
        for(String operation : operations)
        {
            char ch = operation.charAt(1);
            if(ch == '+')
                ans++;
            else
                ans--;
        }
        return ans;
    }
}