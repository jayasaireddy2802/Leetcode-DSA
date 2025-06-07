class Solution {
    public String clearStars(String s) {
        int len = s.length();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[0] == b[0]) ? b[1] - a[1] : a[0] - b[0]);
        char[] str = s.toCharArray();
        String ans = "";

        for(int i = 0; i < len; i++)
        {
            if(s.charAt(i) == '*')
            {
                int[] arr = pq.poll();
                str[arr[1]] = '*';
            }
            else
                pq.add(new int[]{s.charAt(i)-'a', i});
        }

        
        for(int i = 0;i < len; i++)
        {
            if(str[i] == '*')
                continue;
            ans = ans + str[i];
        }

        return ans;
    }
}