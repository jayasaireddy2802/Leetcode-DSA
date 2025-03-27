class Solution {
    public int minimumIndex(List<Integer> nums) {
        Map<Integer, Integer> map1 = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();
        int len = nums.size();
        for(int num : nums)
            map2.put(num, map2.getOrDefault(num, 0) + 1);
        for(int i = 0; i < len; i++)
        {
            map1.put(nums.get(i), map1.getOrDefault(nums.get(i), 0) + 1);
            int val = map2.get(nums.get(i));
            if(val == 1)
                map2.remove(nums.get(i));
            else
                map2.put(nums.get(i), val-1);
            if(map1.getOrDefault(nums.get(i), 0) > (i+1)/2 && map2.getOrDefault(nums.get(i), 0) > (len - i - 1)/2)
                return i;
        }
        return -1;
    }
}