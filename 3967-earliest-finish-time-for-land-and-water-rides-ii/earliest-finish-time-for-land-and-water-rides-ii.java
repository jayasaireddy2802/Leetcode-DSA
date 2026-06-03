// class Solution {
//     public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
//         int len1 = landStartTime.length;
//         int len2 = waterStartTime.length;
//         int minTotalTime = Integer.MAX_VALUE;

//         for(int i = 0; i < len1; i++)
//         {
//             int completeTime = landStartTime[i] + landDuration[i];
            
//             for(int j = 0; j < len2; j++)
//             {               
//                 {
//                     minTotalTime = Math.min(minTotalTime, Math.max(completeTime, waterStartTime[j]) + waterDuration[j]);
//                 }
//             }
//         }

//         for(int i = 0; i < len2; i++)
//         {
//             int completeTime = waterStartTime[i] + waterDuration[i];
            
//             for(int j = 0; j < len1; j++)
//             {
//                 {
//                     minTotalTime = Math.min(minTotalTime, Math.max(completeTime, landStartTime[j]) + landDuration[j]);
//                 }
//             }
//         }

//         return minTotalTime;
//     }
// }



class Solution {

    public int solve(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration)
    {
        int len1 = landStartTime.length;
        int len2 = waterStartTime.length;
        int finishLandRide = Integer.MAX_VALUE;
        int finishWaterRide = Integer.MAX_VALUE;
        for(int i = 0; i < len1; i++)
        {
            finishLandRide = Math.min(finishLandRide, landStartTime[i] + landDuration[i]);
        }

        for(int j = 0; j < len2; j++)
        {
            finishWaterRide = Math.min(finishWaterRide, Math.max(finishLandRide, waterStartTime[j]) + waterDuration[j]);
        }

        return finishWaterRide; 
    }


    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        

        int res1 = solve(landStartTime, landDuration, waterStartTime, waterDuration);
        int res2 = solve(waterStartTime, waterDuration, landStartTime, landDuration);
        return Math.min(res1, res2);
        
    }
}