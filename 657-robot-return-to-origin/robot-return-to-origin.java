// class Solution {
//     public boolean judgeCircle(String moves) {
//         int x = 0;
//         int y = 0;
//         int len = moves.length();

//         for(int i = 0; i < len; i++)
//         {
//             char ch = moves.charAt(i);
//             if(ch == 'U') y--;
//             if(ch == 'R') x++;
//             if(ch == 'D') y++;
//             if(ch == 'L') x--;
//         }

//         return (x == 0 && y == 0);
//     }
// }


class Solution {
    public boolean judgeCircle(String moves) {
        int x = 0;
        int y = 0;
        int len = moves.length();

        for(int i = 0; i < len; i++)
        {
            char ch = moves.charAt(i);
            if(ch == 'U') y--;
            else if(ch == 'R') x++;
            else if(ch == 'D') y++;
            else x--;
        }

        return (x == 0 && y == 0);
    }
}