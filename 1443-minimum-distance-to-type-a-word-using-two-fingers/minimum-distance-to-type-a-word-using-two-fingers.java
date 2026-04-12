// class Solution {

//     public int[] getCoordinates(char ch)
//     {
//         int pos = ch - 'A';
//         return new int[]{pos / 6, pos % 6};
//     }

//     public int getDistance(int x1, int y1, int x2, int y2)
//     {
//         return Math.abs(x1 - x2) + Math.abs(y1 - y2);
//     }

//     public int solve(String word, int i, int x1, int y1, int x2, int y2){
//         if(i >= word.length())
//             return 0;

//         int[] arr = getCoordinates(word.charAt(i));
//         int x = arr[0];
//         int y = arr[1];

//         if(x1 == -1 && y1 == -1 && x2 == -1 && y2 == -1)
//             return solve(word, i + 1, x, y, x2, y2);
        
//         if(x2 == -1 && y2 == -1)
//         {
//             int moveF1 = getDistance(x1, y1, x, y) + solve(word, i + 1, x, y, x2, y2);
//             int moveF2 = solve(word, i + 1, x1, y1, x, y);
//             return Math.min(moveF1, moveF2);
//         }

//         int moveF1 = getDistance(x1, y1, x, y) + solve(word, i + 1, x, y, x2, y2);
//         int moveF2 = getDistance(x2, y2, x, y) + solve(word, i + 1, x1, y1, x, y);
//         return Math.min(moveF1, moveF2);


//     }
//     public int minimumDistance(String word) {
//         int ans = solve(word, 0, -1, -1, -1, -1);
//         return ans;
//     }
// }


class Solution {

    Integer[][][][][] dp;

    public int[] getCoordinates(char ch)
    {
        int pos = ch - 'A';
        return new int[]{pos / 6, pos % 6};
    }

    public int getDistance(int x1, int y1, int x2, int y2)
    {
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }

    public int solve(String word, int i, int x1, int y1, int x2, int y2){
        if(i >= word.length())
            return 0;

        if(dp[i][x1+1][y1+1][x2+1][y2+1] != null)
            return dp[i][x1+1][y1+1][x2+1][y2+1];

        int[] arr = getCoordinates(word.charAt(i));
        int x = arr[0];
        int y = arr[1];

        int ans;

        if(x1 == -1 && y1 == -1 && x2 == -1 && y2 == -1) {
            ans = solve(word, i + 1, x, y, x2, y2);
        }
        else if(x2 == -1 && y2 == -1)
        {
            int moveF1 = getDistance(x1, y1, x, y) + solve(word, i + 1, x, y, x2, y2);
            int moveF2 = solve(word, i + 1, x1, y1, x, y);
            ans = Math.min(moveF1, moveF2);
        }
        else
        {
            int moveF1 = getDistance(x1, y1, x, y) + solve(word, i + 1, x, y, x2, y2);
            int moveF2 = getDistance(x2, y2, x, y) + solve(word, i + 1, x1, y1, x, y);
            ans = Math.min(moveF1, moveF2);
        }

        return dp[i][x1+1][y1+1][x2+1][y2+1] = ans;
    }

    public int minimumDistance(String word) {
        int n = word.length();
        dp = new Integer[n][6][7][6][7]; 

        return solve(word, 0, -1, -1, -1, -1);
    }
}