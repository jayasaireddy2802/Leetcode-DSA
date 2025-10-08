// class Solution {
//     public int[] successfulPairs(int[] spells, int[] potions, long success) {
        
//         int n = spells.length;
//         int m = potions.length;
//         int i = 0;
//         int[] pairs = new int[n];

//         for(int num1 : spells)
//         {
//             int ct = 0;
//             for(int num2 : potions)
//             {
//                 if((long)num1 * num2 >= success)
//                     ct++;
//             }
//             pairs[i++] = ct; 
//         }

//         return pairs;
//     }
// }


class Solution {

    public int binarySearch(int num1, long success, int[] potions)
    {
        int i = 0;
        int j = potions.length - 1;
        int ans = -1;

        while(i <= j)
        {
            int mid = (i + j) / 2;

            if((long)num1 * potions[mid] >= success)
            {
                ans = mid;
                j = mid - 1;
            }
            else
            {
                i = mid + 1;
            }
        }

        return ans;

    }

    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        
        int n = spells.length;
        int m = potions.length;
        int i = 0;
        int[] pairs = new int[n];

        Arrays.sort(potions);

        for(int num1 : spells)
        {
            int idx = binarySearch(num1, success, potions);
            if(idx == -1)
                pairs[i++] = 0;
            else
                pairs[i++] = m - idx;
        }

        return pairs;
    }
}