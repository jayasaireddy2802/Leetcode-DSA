class Solution {
    public int maxProduct(int n) {
        List<Integer> list = new ArrayList<>();
        int ans = 0;

        while(n > 0)
        {
            list.add(n % 10);
            n /= 10;
        }

        int size = list.size();

        for(int i = 0; i < size; i++)
        {
            for(int j = i + 1; j < size; j++)
            {
                ans = Math.max(ans, list.get(i) * list.get(j));
            }
        }

        return ans;
    }
}