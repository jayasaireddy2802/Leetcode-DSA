class Solution {
    public int mostBooked(int n, int[][] meetings) {

        
        Arrays.sort(meetings, (a, b) -> a[0] - b[0]);

        int[] roomUsed = new int[n];     
        long[] freeAt = new long[n];      

        for (int[] meet : meetings) {
            int start = meet[0];
            int end = meet[1];
            int duration = end - start;

            int chosenRoom = -1;
            long minFreeTime = Long.MAX_VALUE;

            for (int i = 0; i < n; i++) {
                if (freeAt[i] <= start) {
                    chosenRoom = i;
                    break;
                }

               
                if (freeAt[i] < minFreeTime) {
                    minFreeTime = freeAt[i];
                    chosenRoom = i;
                }
            }

            if (freeAt[chosenRoom] <= start) {
                freeAt[chosenRoom] = end;
            } else {
                freeAt[chosenRoom] += duration;
            }

            roomUsed[chosenRoom]++;
        }

        
        int answer = 0;
        for (int i = 1; i < n; i++) {
            if (roomUsed[i] > roomUsed[answer]) {
                answer = i;
            }
        }

        return answer;
    }
}
