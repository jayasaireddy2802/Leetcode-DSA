class Solution {
    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        int len = meetings.length;
        TreeMap<Integer, List<int[]>> map = new TreeMap<>();
        boolean[] know = new boolean[n];
        List<Integer> ans = new ArrayList<>();

        know[0] = true;
        know[firstPerson] = true;

        for(int[] meeting : meetings)
        {
            int time = meeting[2];
            int p1 = meeting[0];
            int p2 = meeting[1];

            List<int[]> list = map.get(time);
            if(list == null)
                list = new ArrayList<>();
            list.add(new int[]{p1, p2});
            map.put(time, list);
        }


        for(int key : map.keySet())
        {
            List<int[]> meets = map.get(key);
            Map<Integer, List<Integer>> adj = new HashMap<>();
            Queue<Integer> queue = new LinkedList<>();
            Set<Integer> set = new HashSet<>();

            for(int[] meet : meets)
            {
                int p1 = meet[0];
                int p2 = meet[1];

                List<Integer> list = adj.get(p1);
                if(list == null)
                    list = new ArrayList<>();
                list.add(p2);
                adj.put(p1, list);

                list = adj.get(p2);
                if(list == null)
                    list = new ArrayList<>();
                list.add(p1);
                adj.put(p2, list);

                if(know[p1] && (!set.contains(p1)))
                {
                    queue.add(p1);
                    set.add(p1);
                }

                if(know[p2] && (!set.contains(p2)))
                {
                    queue.add(p2);
                    set.add(p2);
                }
            }


            while(!queue.isEmpty())
            {
                int p = queue.poll();

                for(int neighbour : adj.get(p))
                {
                    if(know[neighbour] == false)
                    {
                        know[neighbour] = true;
                        queue.add(neighbour);
                    }
                }
            }


        }

        for(int i = 0; i < n; i++)
        {
            if(know[i])
                ans.add(i);
        }

        return ans;
    }
}