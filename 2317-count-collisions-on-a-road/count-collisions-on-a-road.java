class Solution {
    public int countCollisions(String directions) {
        int len = directions.length() ;
        int ct = 0, i = 0, j = len - 1;

        while(i < len && 'L' == directions.charAt(i))
        {
            i++;
        }
        while(j >= 0 && 'R' == directions.charAt(j))
        {
            j--;
        }

        while(i <= j)
        {
            if('S' != directions.charAt(i))
                ct++;
            i++;
        }

        return ct;

    }
}