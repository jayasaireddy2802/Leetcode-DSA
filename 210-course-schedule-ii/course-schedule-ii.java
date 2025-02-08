class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int q = prerequisites.length;
        int j = 0;
        List<List<Integer>> adj = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        int[] indegre = new int[numCourses];
        int[] ans = new int[numCourses];

        for(int i = 0; i < numCourses; i++)
            adj.add(new ArrayList<>());

        for(int[] arr : prerequisites)
        {
            adj.get(arr[1]).add(arr[0]);
            indegre[arr[0]]++;
        }
        
        for(int i = 0; i < numCourses; i++)
        {
            if(indegre[i] == 0)
            {
                queue.add(i);
                list.add(i);
                ans[j] = i;
                j++;
            }
        }

        while(!queue.isEmpty())
        {
            int node = queue.poll();

            for(int neighbour : adj.get(node))
            {
                indegre[neighbour]--;
                if(indegre[neighbour] == 0)
                {
                    queue.add(neighbour);
                    list.add(neighbour);
                    ans[j] = neighbour;
                    j++;
                }
            }

        }

        return (list.size() == numCourses) ? ans : new int[0];

    }
}