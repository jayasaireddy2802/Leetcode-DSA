class Solution {
    public int[] arrayRankTransform(int[] arr) {
        Set<Integer> set = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        int[] res = new int[arr.length];

        for(int num : arr)
            set.add(num);

        for(int num : set)
            list.add(num);

        Collections.sort(list);

        int size = list.size();
        for(int i = 0; i < size; i++)
            map.put(list.get(i), i + 1);

        for(int i = 0; i < arr.length; i++)
        {
            res[i] = map.get(arr[i]);
        }

        return res;
    }
}