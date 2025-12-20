class Solution {

    public boolean needToDelete(String[] strs, int len, int idx)
    {
        for(int i = 1; i < len; i++)
        {
            if(strs[i].charAt(idx) < strs[i - 1].charAt(idx))
                return true;
        }

        return false;
    }

    public int minDeletionSize(String[] strs) {
        int len = strs.length;
        int ct = 0;
        int strlen = strs[0].length();

        for(int idx = 0; idx < strlen; idx++)
        {
            if(needToDelete(strs, len, idx))
                ct++;
        }

        return ct;
    }
}