class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        int len = nums.length;
        int mini = 200;
        int maxi = 0;

        for(int i = 0; i < len; i++)
        {
            mini = Math.min(mini, nums[i]);
            maxi = Math.max(maxi, nums[i]);
        }

        int size = maxi - mini + 1;
        boolean[] isPresent = new boolean[size];

        for(int i = 0; i < len; i++)
        {
            isPresent[nums[i] - mini] = true;
        }

        List<Integer> list = new ArrayList<>();

        for(int i = 0; i < size; i++)
        {
            if(!isPresent[i])
                list.add(i + mini);
        }

        return list;

    }
}