// class Solution {
//     public int minOperations(int[] nums) {
//         int len = nums.length;
//         int ct = 0;

//         TreeSet<Integer> set = new TreeSet<>();
//         for(int num : nums)
//             set.add(num);

//         for(int val : set)
//         {
//             if(val == 0)
//                 continue; 

//             boolean add = false;
//             for(int num : nums)
//             {
//                 if(val == num && (!add))
//                 {
//                     ct++;
//                     add = true;
//                 }
//                 else if(num < val)
//                 {
//                     add = false;
//                 }                
//             }
//         }

//         return ct;
//     }
// }


class Solution {
    public int minOperations(int[] nums) {
        Stack<Integer> st = new Stack<>();
        int ct = 0;

        for(int num : nums)
        {
            while(!st.isEmpty() && st.peek() > num)
                st.pop();

            if(num == 0)
                continue;

            if(st.isEmpty() || (st.peek() < num))
            {
                st.add(num);
                ct++;
            }
        }

        return ct;

    }
}