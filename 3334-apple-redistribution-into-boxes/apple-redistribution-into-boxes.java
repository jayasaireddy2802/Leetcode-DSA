// class Solution {
//     public int minimumBoxes(int[] apple, int[] capacity) {
//         Arrays.sort(capacity);
//         for(int i = 0, j = capacity.length - 1; i < j; i++, j--)
//         {
//             int temp = capacity[i];
//             capacity[i] = capacity[j];
//             capacity[j] = temp; 
//         }
//         int len = capacity.length;
//         int sum = 0;

//         for(int val : apple)
//             sum += val;

//         int i = 0;
//         while(i < len)
//         {
//             if(sum <= 0)
//                 break;
//             sum -= capacity[i];
//             i++;
//         }

//         return i;
//     }
// }


class Solution {
    public int minimumBoxes(int[] apple, int[] capacity) {
        Arrays.sort(capacity);
        int len = capacity.length;
        int sum = 0;

        for(int val : apple)
            sum += val;

        int i = len - 1;
        while(i >= 0)
        {
            sum -= capacity[i];
            if(sum <= 0)
                break;
            i--;
        }

        return len - i;
    }
}