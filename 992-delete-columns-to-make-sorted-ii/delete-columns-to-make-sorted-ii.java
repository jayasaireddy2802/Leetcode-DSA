
class Solution {
    public int minDeletionSize(String[] strs) {
        int len = strs.length;
        int strlen = strs[0].length();
        int deletions = 0;


        boolean[] sorted = new boolean[len];

        outer:
        for(int col = 0; col < strlen; col++)
        {
            for(int row = 0; row < len - 1; row++)
            {
                if(!sorted[row] && strs[row].charAt(col) > strs[row + 1].charAt(col))
                {
                    deletions++;
                    continue outer;
                }
            }
            for(int row = 0; row < len - 1; row++)
            {
                if(!sorted[row] && strs[row].charAt(col) < strs[row + 1].charAt(col))
                    sorted[row] = true;
            }
        }

        return deletions;
    }
}