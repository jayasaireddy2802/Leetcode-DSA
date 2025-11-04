
class Pair
{
    int num;
    int ct;

    public Pair(int x, int y)
    {
        num = x;
        ct = y;
    }
}
class Solution {

    public int xSum(int i, int k, int x, int[] nums)
    {
        Map<Integer, Integer> map = new HashMap<>();

        for(int j = i; j < i + k; j++)
        {
            map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);   
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.ct == b.ct ? b.num - a.num : b.ct - a.ct);

        for(int key : map.keySet())
        {
            pq.add(new Pair(key, map.get(key)));
        }

        int sum = 0;
        
        while(!pq.isEmpty() && x > 0)
        {
            Pair p = pq.poll();
            sum = sum + p.num * p.ct;
            x--;
        }

        return sum;
    }

    public int[] findXSum(int[] nums, int k, int x) {
        int len = nums.length;
        int ans[] = new int[len - k + 1];
        int j = 0;

        for(int i = 0; i + k - 1 < len; i++)
        {
            int sum = xSum(i, k, x, nums);
            ans[j] = sum;
            j++;
        }

        return ans;
    }
}