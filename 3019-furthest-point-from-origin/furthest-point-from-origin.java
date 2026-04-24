class Solution {
    public int furthestDistanceFromOrigin(String moves) {

        int leftCount = 0;
        int rightCount = 0;
        int ct = 0;
        int len = moves.length();

        for(int i = 0; i < len; i++)
        {
            char ch = moves.charAt(i);
            if(ch == 'R') rightCount++;
            else if(ch == 'L') leftCount++;
            else ct++;          
        }

        return Math.abs(leftCount - rightCount) + ct;
    }
}