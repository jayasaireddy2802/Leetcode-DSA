// class Solution {
//     public int maxArea(int[] height) {
//         int len = height.length;
//         int ans = 0;

//         for(int i = 0; i < len - 1; i++)
//         {
//             for(int j = 0; j < len; j++)
//             {
//                 ans = Math.max(ans, Math.min(height[i], height[j]) * (j - i));
//             }
//         }

//         return ans;
//     }
// }


class Solution {
    public int maxArea(int[] height) {
        int len = height.length;
        int ans = 0;

        int i = 0, j = len - 1;
        while(i < j)
        {
            if(height[i] <= height[j])
            {
                ans = Math.max(ans, height[i]*(j - i));
                i++;
            }
            else
            {
                ans = Math.max(ans, height[j] * (j - i));
                j--;
            }
        }
        
        return ans;
    }
}