class Solution {
    public int[] separateDigits(int[] nums) {
        List<Integer> list = new ArrayList<>();

        for(int num : nums)
        {
            List<Integer> l = new ArrayList<>();

            while(num > 0)
            {
                l.add(num % 10);
                num /= 10;
            }

            int len = l.size();
            for(int i = len - 1; i >= 0; i--)
            {
                list.add(l.get(i));
            }
        }

        int size = list.size();
        int[] arr = new int[size];
        int i = 0;
        for(int num : list)
            arr[i++] = num;

        return arr;
    }
}