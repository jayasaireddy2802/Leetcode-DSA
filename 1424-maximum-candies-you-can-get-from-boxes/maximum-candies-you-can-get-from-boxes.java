// class Solution {

//     public int dfs(int box, int[] status, int[] candies, int[][] keys, int[][] containedBoxes, boolean[] visited, Set<Integer> foundBoxes) 
//     {
//         int candiesFound = 0;

//         if(visited[box] == true)
//             return 0;
        
//         if(status[box] == 0)
//         {
//             foundBoxes.add(box);
//             return 0;
//         }

//         visited[box] = true;
//         candiesFound += candies[box];

//         for(int neighbourBox : containedBoxes[box])
//         {
//             candiesFound += dfs(neighbourBox, status, candies, keys, containedBoxes, visited, foundBoxes);
//         }

//         for(int key : keys[box])
//         {
//             status[key] = 1;
//             if(foundBoxes.contains(key))
//             {
//                 candiesFound += dfs(key, status, candies, keys, containedBoxes, visited, foundBoxes);
//             }
//         }

//         return candiesFound;
//     }
//     public int maxCandies(int[] status, int[] candies, int[][] keys, int[][] containedBoxes, int[] initialBoxes) {
//         int len = status.length;
//         boolean[] visited = new boolean[len];
//         int totalCandies = 0;
//         Set<Integer> foundBoxes = new HashSet<>();

//         for(int box : initialBoxes)
//         {
//             totalCandies += dfs(box, status, candies, keys, containedBoxes, visited, foundBoxes);
//         }

//         return totalCandies;
//     }
// }


class Solution
{
    public int maxCandies(int[] status, int[] candies, int[][] keys, int[][] containedBoxes, int[] initialBoxes) 
    {
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> foundBoxes = new HashSet<>();
        boolean[] visited = new boolean[status.length];
        int total = 0;

        for(int box : initialBoxes)
        {
            queue.add(box);
        }


        while(!queue.isEmpty())
        {
            int box = queue.poll();

            if(visited[box])
                continue;

            if(status[box] == 0)
            {
                foundBoxes.add(box);
                continue;
            }

            visited[box] = true;
            total += candies[box];

            for(int neighbour : containedBoxes[box])
            {
                queue.add(neighbour);
            }

            for(int key : keys[box])
            {
                status[key] = 1;
                if(foundBoxes.contains(key))
                {
                    queue.add(key);
                    // total += candies[key];
                }
            }
        }

        return total;
    }
}