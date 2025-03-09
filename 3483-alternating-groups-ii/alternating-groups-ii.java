// class Solution {
//     public int numberOfAlternatingGroups(int[] colors, int k) {
//         int n = colors.length;
//         int ans = 0;

//         for(int i = 0; i < n; i++)
//         {
//             boolean flag = true;
//             for(int j = 0; j < k-1; j++)
//             {
//                 if(colors[(i+j) % n] == colors[(i+j+1) % n])
//                 {
//                     flag = false;
//                     break;
//                 }
//             }
//             if(flag)
//                 ans++;
//         }
//         return ans;
//     }
// }


class Solution {
    public int numberOfAlternatingGroups(int[] colors, int k) {
        int n = colors.length;
        int ans = 0;

        int i = 0;
        int j  = i + 1;
        int N = n + (k-1);
        
            while(j < N)
            {
                if(colors[j%n] == colors[(j-1+n)%n])
                {
                    i = j;
                    j++;
                    continue;
                }

                if(j - i + 1 == k)
                {
                    ans++;
                    i++;
                }
                j++;
            }
                
        

        return ans;
    }
}