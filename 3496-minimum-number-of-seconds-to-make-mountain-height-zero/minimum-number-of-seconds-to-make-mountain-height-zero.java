// class Solution {

//     public boolean isPossible(long i, int mountainHeight, int[] workerTimes)
//     {
//         long totalHeight = 0;

//         for(int workerTime : workerTimes)
//         {
//             long height = (long) (Math.sqrt((2*i)/workerTime + 0.25) - 0.5);
//             totalHeight += height;
//         }

//         return (totalHeight >= mountainHeight);
//     }
//     public long minNumberOfSeconds(int mountainHeight, int[] workerTimes) {
//         for(long i = 0; i < 1000_000_000; i++)
//         {
//             if(isPossible(i, mountainHeight, workerTimes))
//                 return i;
//         }

//         return -1;
//     }
// }


class Solution {

    public boolean isPossible(long i, int mountainHeight, int[] workerTimes)
    {
        long totalHeight = 0;

        for(int workerTime : workerTimes)
        {
            long height = (long) (Math.sqrt((2*i)/workerTime + 0.25) - 0.5);
            totalHeight += height;
        }

        return (totalHeight >= mountainHeight);
    }
    public long minNumberOfSeconds(int mountainHeight, int[] workerTimes) {
        
        int maxWorkerTime = 0;
        for(int time : workerTimes)
        {
            maxWorkerTime = Math.max(maxWorkerTime, time);
        }

        long low = 1;
        long high = maxWorkerTime * (((long)mountainHeight * (mountainHeight + 1)) / 2);
        long ans = 0;

        while(low <= high)
        {
            long mid = high - (high - low)/2;

            if(isPossible(mid, mountainHeight, workerTimes))
            {
                ans = mid;
                high = mid - 1;
            }
            else
                low = mid + 1;
        }

        return ans;
    }
}