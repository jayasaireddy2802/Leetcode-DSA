// class Solution {

//     public int getIndex(int num, List<Integer> list, int len)
//     {
//         for(int i = 0; i < len; i++)
//         {
//             if(list.get(i) == num) return i;
//         }
//         return -1;
//     }
//     public List<Integer> solveQueries(int[] nums, int[] queries) {
//         List<Integer> ans = new ArrayList<>();
//         int len = nums.length;
//         Map<Integer, List<Integer>> map = new HashMap<>();

//         for(int i = 0; i < len; i++)
//             map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);

//         for(int query : queries)
//         {
//             int val = nums[query];
//             List<Integer> list = map.get(val);
//             int size = list.size();
//             if(size == 1)
//             {
//                 ans.add(-1);
//                 continue;
//             }
//             int idx = getIndex(query, list, size);
//             int next = list.get((idx+1)%size);
//             int prev = list.get((idx-1+size)%size);
//             int d1 = Math.min(Math.abs(query - next), len - Math.abs(query - next));
//             int d2 = Math.min(Math.abs(query - prev), len - Math.abs(query - prev));

//             ans.add(Math.min(d1, d2));
//         }

//         return ans;

//     }
// }


class Solution {

    public int getIndex(int num, List<Integer> list, int len)
    {
        int i = 0;
        int j = len - 1;

        while(i <= j)
        {
            int mid = i + (j - i) / 2;
            if(num == list.get(mid)) return mid;
            else if(num > list.get(mid)) i = mid + 1;
            else j = mid - 1;
        }
        return -1;
    }
    public List<Integer> solveQueries(int[] nums, int[] queries) {
        List<Integer> ans = new ArrayList<>();
        int len = nums.length;
        Map<Integer, List<Integer>> map = new HashMap<>();

        for(int i = 0; i < len; i++)
            map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);

        for(int query : queries)
        {
            int val = nums[query];
            List<Integer> list = map.get(val);
            int size = list.size();
            if(size == 1)
            {
                ans.add(-1);
                continue;
            }
            int idx = getIndex(query, list, size);
            int next = list.get((idx+1)%size);
            int prev = list.get((idx-1+size)%size);
            int d1 = Math.min(Math.abs(query - next), len - Math.abs(query - next));
            int d2 = Math.min(Math.abs(query - prev), len - Math.abs(query - prev));

            ans.add(Math.min(d1, d2));
        }

        return ans;

    }
}