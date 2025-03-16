// class Solution {

//     public boolean isPossible(int[] ranks, int cars, long time)
//     {
//         long totalCars = 0;
//         for(int rank : ranks)
//         {
//             totalCars = totalCars + (long)Math.sqrt(time/rank);
//         }

//         return (totalCars >= cars);
        
//     }

//     public long repairCars(int[] ranks, int cars) {
        
//         int n = ranks.length;        

//         for(long i = 1; i <= (long)cars*cars*ranks[0]; i++)
//         {
//             if(isPossible(ranks, cars, i))
//                 return i;
//         }    

//         return cars;
//     }
// }


class Solution {

    public boolean isPossible(int[] ranks, int cars, long time)
    {
        long totalCars = 0;
        for(int rank : ranks)
        {
            totalCars = totalCars + (long)Math.sqrt(time/rank);
        }

        return (totalCars >= cars);
        
    }

    public long repairCars(int[] ranks, int cars) {
        
        int n = ranks.length;        

        long i = 1;
        long j = (long)ranks[0]*cars*cars;   
        long ans = 0;
        while(i <= j)
        {
            long mid = i + (j - i) / 2;
            if(isPossible(ranks,cars, mid))
            {
                j = mid - 1;
                ans = mid;
            }
            else
                i = mid + 1;
        }
        return i;
    }
}