// class Solution {
//     public long minOperations(int[][] queries) {
//         long ct = 0;

//         for(int[] query : queries)
//         {
//             int start = query[0];
//             int end = query[1];
//             PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);

//             for(int i = start; i <= end; i++)
//             {
//                 pq.add(i);
//             }

//             while((!pq.isEmpty()) && (pq.peek() != 0))
//             {
//                 if(pq.size() < 2) break;

//                 int val1 = pq.poll() / 4;
//                 int val2 = pq.poll() / 4;

//                 if(val1 > 0) pq.add(val1);
//                 if(val2 > 0) pq.add(val2);
                
//                 ct++;
//             }

//             if(!pq.isEmpty())
//             {
//                 int val = pq.poll();
//                 while(val > 0)
//                 {
//                     val /= 4;
//                     ct++;
//                 }
//             }
//         }

//         return ct;
//     }
// }

// class Solution {
//     // Count how many times a number can be divided by 4 until it becomes 0
//     private int steps(int x) {
//         int ct = 0;
//         while (x > 0) {
//             x /= 4;
//             ct++;
//         }
//         return ct;
//     }

//     public long minOperations(int[][] queries) {
//         long totalOps = 0;

//         for (int[] query : queries) {
//             int start = query[0];
//             int end = query[1];

//             long stepSum = 0;
//             for (int i = start; i <= end; i++) {
//                 stepSum += steps(i);
//             }

//             // Each operation processes 2 numbers, so ceil(stepSum / 2)
//             totalOps += (stepSum + 1) / 2;
//         }

//         return totalOps;
//     }
// }


class Solution {
    public long minOperations(int[][] queries) {
        long ans = 0;
        for(int[] query : queries)
        {
            int l = query[0];
            int r = query[1];

            int s = 1;
            long steps = 0;
            int L = 1;
            
            while(s < 16)
            {
                int R = 4*L - 1;
                if(l > R)
                {
                    s++;
                    L *= 4;
                    continue;
                }
                if(L > r)
                    break;
                
                int start = Math.max(l, L);
                int end = Math.min(r, R);

                long elements = (long)(end - start + 1);
                steps += elements * s;
                s++;
                L *= 4;
                
            }

            ans += (steps + 1) / 2;
        }

        return ans;
    }
}