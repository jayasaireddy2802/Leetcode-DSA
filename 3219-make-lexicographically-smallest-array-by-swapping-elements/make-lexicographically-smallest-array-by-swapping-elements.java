class Solution {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        int len = nums.length;
        // copy the original array
        int[] arr = Arrays.copyOf(nums, len);

        // sort the array (arr)
        Arrays.sort(arr);

        // make the groups and groupnumber
        
        // for groupnumber
        Map<Integer, Integer> grp_no_map = new HashMap<>();
        // for group
        Map<Integer, List<Integer>> grp_map = new HashMap<>();
        int grp_no = 0;

        grp_no_map.put(arr[0], grp_no);
        List<Integer> list = new ArrayList<>();
        list.add(arr[0]);
        grp_map.put(grp_no, list);

        for(int i = 1; i < len; i++)
        {
            if(arr[i] - arr[i-1] <= limit)
            {
                list = grp_map.get(grp_no);
                list.add(arr[i]);
                grp_map.put(grp_no, list);
            }
            else
            {
                grp_no++;
                list = new ArrayList<>();
                list.add(arr[i]);
                grp_map.put(grp_no, list);
            }
            grp_no_map.put(arr[i], grp_no);
        }
        
        // Iterate over the original array
        int ans[] = new int[len];
        for(int i = 0; i < len; i++)
        {
            int num = grp_no_map.get(nums[i]);
            list = grp_map.get(num);
            if(list.size() != 0){
            ans[i] = list.remove(0);
            grp_map.put(num, list);
            }
        }

        // return ans
        return ans;
    }
}