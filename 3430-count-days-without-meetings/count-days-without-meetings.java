// difference array technique

// class Solution {
//     public int countDays(int days, int[][] meetings) {
//         int[] differanceArray = new int[days];

//         for(int[] meeting : meetings)
//         {
//             int l = meeting[0] - 1;
//             int r = meeting[1] - 1;

//             differanceArray[l] = differanceArray[l] + 1;
//             if(r+1 < days)
//             differanceArray[r+1] = differanceArray[r+1] - 1;
//         } 

//         int cummulative_freq = 0;
//         int i = 0;
//         int ct = 0;

//         while(i < days)
//         {
//             cummulative_freq = cummulative_freq + differanceArray[i];
//             if(cummulative_freq == 0)
//                 ct++;
//             i++;
//         }

//         return ct;
//     }
// }



class Solution {
    public int countDays(int days, int[][] meetings) {
        Arrays.sort(meetings, (a, b) -> Integer.compare(a[0], b[0]));
        
        int start = 0;
        int end = 0;
        int daysOff = 0;
        int len = meetings.length;
        for(int i = 0; i < len; i++)
        {
            start = meetings[i][0];
            if(start > end)
                daysOff += start - end - 1;
            
            end = Math.max(end, meetings[i][1]);
        }

        if(end < days)
        {
            daysOff += days - end;
        }

        return daysOff;
    }
}