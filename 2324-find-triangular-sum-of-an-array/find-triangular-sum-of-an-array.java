class Solution {
    public int triangularSum(int[] nums) {
        
        List<Integer> list = Arrays.stream(nums).boxed().toList();

        while(true)
        {
            int size = list.size();
            if(size == 1)
                return list.get(0);

            List<Integer> newList = new ArrayList<>();

            for(int i = 0; i < size - 1; i++)
            {
                newList.add((list.get(i) + list.get(i + 1)) % 10);
            }

            list = newList;
        }
    }
}