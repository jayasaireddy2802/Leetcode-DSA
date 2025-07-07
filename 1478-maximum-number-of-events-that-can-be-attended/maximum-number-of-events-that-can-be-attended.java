class Solution {
    public int maxEvents(int[][] events) {
    
        int ct = 0;
        int i = 0;
        int day = 1;
        int len = events.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        Arrays.sort(events, (a, b) -> a[0] - b[0]);

        while(!pq.isEmpty() || i < len)
        {
            while(i < len && events[i][0] == day)
            {
                pq.add(events[i][1]);
                i++;
            }

            if(!pq.isEmpty())
            {
                pq.poll();
                ct++;
            }

            day++;

            while(!pq.isEmpty() && pq.peek() < day)
            {
                pq.poll();
            }        
        }

        return ct;        
    }
}                             