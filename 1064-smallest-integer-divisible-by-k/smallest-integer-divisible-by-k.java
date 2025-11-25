class Solution {
    public int smallestRepunitDivByK(int k) {
        Set<Integer> set = new HashSet<>();
        int length = 0;
        int num = 0;

        while(true)
        {
            num = num % k;
            num = num * 10 + 1;
            length++;
            if(num % k == 0)
                return length;
            if(set.contains(num))
                return -1;
            set.add(num);
        }
    }
}