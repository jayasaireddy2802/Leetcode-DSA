class Solution {
    public int numRabbits(int[] answers) {
        int ct = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : answers)
        {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for(int key : map.keySet())
        {
            int size = key + 1;
            int answer = map.get(key);
            int groups = (int)Math.ceil(answer * 1.0 / size * 1.0);
            ct = ct + groups * size;
        }
        return ct;
    }
}