class Solution {
    public int repeatedNTimes(int[] nums) {
        int len = nums.length;
        int n = len / 2;

        Map<Integer, Integer> map = new HashMap<>();

        for(int num : nums)
            map.put(num, map.getOrDefault(num, 0) + 1);
        
        for(int key : map.keySet())
        {
            if(map.get(key) == n)
                return key;
        }

        return -1;        
    }
}