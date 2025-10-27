class Solution {

    public int getDevices(String str)
    {
        int ct = 0;
        for(char ch : str.toCharArray())
        {
            if(ch == '1')
                ct++;
        }
        return ct;
    }

    public int numberOfBeams(String[] bank) {
        int prev = 0;
        int curr;
        int ans = 0;

        for(String str : bank)
        {
            curr = getDevices(str);
            ans = ans + (prev * curr);
            if(curr != 0)
                prev = curr;
        }
        return ans;
    }
}