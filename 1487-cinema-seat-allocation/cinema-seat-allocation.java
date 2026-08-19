// class Solution {
//     public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
//         boolean[][] reserved = new boolean[n][10];
//         int ans = 0;

//         for(int[] reservedSeat : reservedSeats)
//         {
//             int row = reservedSeat[0];
//             int col = reservedSeat[1];

//             reserved[row - 1][col - 1] = true;
//         }

//         for(int i = 0; i < n; i++)
//         {
//             boolean left   = !reserved[i][1] && !reserved[i][2] && !reserved[i][3] && !reserved[i][4];
//             boolean middle = !reserved[i][3] && !reserved[i][4] && !reserved[i][5] && !reserved[i][6];
//             boolean right  = !reserved[i][5] && !reserved[i][6] && !reserved[i][7] && !reserved[i][8];

//             if(left && right) ans += 2;
//             else if(left || middle || right) ans += 1;
//         }

//         return ans;
//     }
// }

class Solution {

    public int count(boolean[] reserved)
    {
        boolean left   = !reserved[1] && !reserved[2] && !reserved[3] && !reserved[4];
        boolean middle = !reserved[3] && !reserved[4] && !reserved[5] && !reserved[6];
        boolean right  = !reserved[5] && !reserved[6] && !reserved[7] && !reserved[8];

        if(left && right) return 2;
        else if(left || middle || right) return 1;
        return 0;
    }

    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        int len = reservedSeats.length;
        int ans = 0;
        int rowsWithReservations = 0;

        Arrays.sort(reservedSeats, (a, b) -> a[0] - b[0]);
        
        int i = 0;
        int val = reservedSeats[0][0];
        boolean[] reserved = new boolean[11];

        while(i < len)
        {
            if(val == reservedSeats[i][0])
            {
                reserved[reservedSeats[i][1] - 1] = true;
                i++;
            }
            else
            {
                ans += count(reserved);
                rowsWithReservations++;
                reserved = new boolean[11];
                val = reservedSeats[i][0];              
            }
        }

        ans += count(reserved);
        rowsWithReservations++;

        return ans + (n - rowsWithReservations) * 2;
    }
}