class FindSumPairs {

    int[] arr1;
    int[] arr2;
    Map<Integer, Integer> map;

    public FindSumPairs(int[] nums1, int[] nums2) {
        arr1 = Arrays.copyOf(nums1, nums1.length);
        arr2 = Arrays.copyOf(nums2, nums2.length);
        map = new HashMap<>();
        for(int num : nums2)
            map.put(num, map.getOrDefault(num, 0) + 1);
    }
    
    public void add(int index, int val) {
        int value = arr2[index];
        int freqVal = map.get(value);
        if(freqVal == 1)
            map.remove(value);
        else
            map.put(value, freqVal - 1);
        
        arr2[index] += val;
        map.put(arr2[index], map.getOrDefault(arr2[index], 0) + 1);        
    }
    
    public int count(int tot) {
        int ct = 0;
        for(int num : arr1)
        {
            int val = tot - num;
            ct += map.getOrDefault(val, 0);
        }
        return ct;
    }
}

/**
 * Your FindSumPairs object will be instantiated and called as such:
 * FindSumPairs obj = new FindSumPairs(nums1, nums2);
 * obj.add(index,val);
 * int param_2 = obj.count(tot);
 */