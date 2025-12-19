class Solution {
    public List<Integer> findAllPeople(int totalPeople, int[][] meetings, int initialPerson) {

        // Graph: person -> list of (meetingTime, otherPerson)
        Map<Integer, List<int[]>> adjacencyList = new HashMap<>();

        for (int[] meeting : meetings) {
            int u = meeting[0];
            int v = meeting[1];
            int meetingTime = meeting[2];

            adjacencyList
                .computeIfAbsent(u, k -> new ArrayList<>())
                .add(new int[]{meetingTime, v});

            adjacencyList
                .computeIfAbsent(v, k -> new ArrayList<>())
                .add(new int[]{meetingTime, u});
        }

        // Min-heap: (timePersonGotSecret, person)
        PriorityQueue<int[]> minHeap =
            new PriorityQueue<>((a, b) -> a[0] - b[0]);

        minHeap.offer(new int[]{0, 0});
        minHeap.offer(new int[]{0, initialPerson});

        // Tracks whether a person has already been finalized
        boolean[] knowsSecret = new boolean[totalPeople];

        while (!minHeap.isEmpty()) {
            int[] current = minHeap.poll();
            int currentTime = current[0];
            int currentPerson = current[1];

            if (knowsSecret[currentPerson]) {
                continue;
            }

            knowsSecret[currentPerson] = true;

            for (int[] neighborInfo :
                 adjacencyList.getOrDefault(currentPerson, Collections.emptyList())) {

                int neighborTime = neighborInfo[0];
                int neighborPerson = neighborInfo[1];

                if (!knowsSecret[neighborPerson] &&
                    neighborTime >= currentTime) {

                    minHeap.offer(new int[]{neighborTime, neighborPerson});
                }
            }
        }

        // Collect all people who know the secret
        List<Integer> result = new ArrayList<>();
        for (int person = 0; person < totalPeople; person++) {
            if (knowsSecret[person]) {
                result.add(person);
            }
        }

        return result;
    }
}
