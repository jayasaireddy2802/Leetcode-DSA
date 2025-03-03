class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        List<Integer> list3 = new ArrayList<>();
        int n = nums.length;
        int[] ans = new int[n];

        for(int num : nums)
        {
            if(num == pivot)
                list2.add(num);
            else if(num < pivot)
                list1.add(num);
            else
                list3.add(num);
        }

        int i = 0;
        for(int x : list1)
        {
            ans[i] = x;
            i++;
        }
        for(int x : list2)
        {
            ans[i] = x;
            i++;
        }
        for(int x : list3)
        {
            ans[i] = x;
            i++;
        }

        return ans;
    }
}