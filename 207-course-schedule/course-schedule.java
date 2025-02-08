class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] visited = new int[numCourses];
        Queue<Integer> queue = new LinkedList<>();
        int[] indegre = new int[numCourses];
        int queries = prerequisites.length;
        List<List<Integer>> adj = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();

        // empty list for each course
        for(int i = 0; i <numCourses; i++)
        {
            adj.add(new ArrayList<>());
        }

        // creating the adjanceny list
        for(int[] arr : prerequisites)
        {
            adj.get(arr[1]).add(arr[0]);
        }

        // indegree calculation
        for(int i = 0; i < queries; i++)
        {
            indegre[prerequisites[i][0]]++;
        }

        for(int i = 0; i < numCourses; i++)
        {
            if(indegre[i] == 0)
            {
                queue.add(i);
                ans.add(i);
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
                    ans.add(neighbour);
                }
            }
        }

        return (ans.size() == numCourses);
    }
}