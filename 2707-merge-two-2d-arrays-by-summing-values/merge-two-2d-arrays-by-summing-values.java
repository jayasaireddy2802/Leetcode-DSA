class Solution {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int[] nums : nums1)
        {
            if(map.containsKey(nums[0]))
            {
                map.put(nums[0], map.get(nums[0]) + nums[1]);
            }
            else
                map.put(nums[0], nums[1]);
        }

        for(int[] nums : nums2)
        {
            if(map.containsKey(nums[0]))
            {
                map.put(nums[0], map.get(nums[0]) + nums[1]);
            }
            else
                map.put(nums[0], nums[1]);
        }
        
        int size = map.size();
        int[][] res = new int[size][2];

        int i = 0;
        for(int x : map.keySet())
        {
            res[i][0] = x;
            res[i][1] = map.get(x);
            i++;
        }

        Arrays.sort(res, (a, b) -> a[0] - b[0]);
        return res;
    }
}