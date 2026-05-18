// class Solution {

//     int min;

//     public int solve(int[] arr, int idx, Map<Integer, List<Integer>> map, boolean[] visited)
//     {
//         int len = arr.length;

//         if(idx < 0 || idx >= len)
//             return 100000;
        
//         if(visited[idx])
//             return 100000;

//         if(idx == len - 1)
//             return 0;

//         visited[idx] = true;
        
//         int steps1 = 1 + solve(arr, idx + 1, map, visited);
//         int steps2 = 1 + solve(arr, idx - 1, map, visited);

//         int steps3 = len;

//         for(int j : map.get(arr[idx]))
//         {
//             if(idx != j)
//             steps3 = Math.min(steps3, 1 + solve(arr, j, map, visited));
//         }

//         visited[idx] = false;

//         return Math.min(steps1, Math.min(steps2, steps3));

//     }

//     public int minJumps(int[] arr) {
//         Map<Integer, List<Integer>> map = new HashMap<>();
//         int len = arr.length;
//         min = len;

//         boolean[] visited = new boolean[len];

//         for(int i = 0; i < len; i++)
//         {
//             map.computeIfAbsent(arr[i], k -> new ArrayList<>()).add(i);
//         }

//         return solve(arr, 0, map, visited);
//     }
// }

class Solution {
    public int minJumps(int[] arr) {
        int n = arr.length;

        if (n <= 1) return 0;

        // Step 1: Build map
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.computeIfAbsent(arr[i], k -> new ArrayList<>()).add(i);
        }

        // Step 2: BFS
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n];

        q.offer(0);
        visited[0] = true;

        int steps = 0;

        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                int idx = q.poll();

                // Reached end
                if (idx == n - 1) return steps;

                // Move forward
                if (idx + 1 < n && !visited[idx + 1]) {
                    visited[idx + 1] = true;
                    q.offer(idx + 1);
                }

                // Move backward
                if (idx - 1 >= 0 && !visited[idx - 1]) {
                    visited[idx - 1] = true;
                    q.offer(idx - 1);
                }

                // Same value jumps
                if (map.containsKey(arr[idx])) {
                    for (int next : map.get(arr[idx])) {
                        if (!visited[next]) {
                            visited[next] = true;
                            q.offer(next);
                        }
                    }
                    // IMPORTANT optimization
                    map.remove(arr[idx]);
                }
            }

            steps++;
        }

        return -1;
    }
}