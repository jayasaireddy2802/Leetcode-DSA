class Solution {
    public int mostBooked(int n, int[][] meetings) {
        // Sort the meetings based on their start times
        Arrays.sort(meetings, (m1, m2) -> Integer.compare(m1[0], m2[0]));

        // Array to track how many times each room is used
        int[] usageCount = new int[n];
        // Array to store when each room becomes available
        long[] roomAvailability = new long[n];

        for (int[] meeting : meetings) {
            int startTime = meeting[0];
            int endTime = meeting[1];
            boolean isAssigned = false;

            int selectedRoom = -1;
            long earliestFreeTime = Long.MAX_VALUE;

            // Look for an available room at the meeting's start time
            for (int i = 0; i < n; i++) {
                if (roomAvailability[i] <= startTime) {
                    roomAvailability[i] = endTime;
                    usageCount[i]++;
                    isAssigned = true;
                    break;
                }

                // Track the room that becomes available the earliest
                if (roomAvailability[i] < earliestFreeTime) {
                    earliestFreeTime = roomAvailability[i];
                    selectedRoom = i;
                }
            }

            // If no room was free, delay the meeting to the earliest available room
            if (!isAssigned) {
                long newEndTime = roomAvailability[selectedRoom] + (endTime - startTime);
                roomAvailability[selectedRoom] = newEndTime;
                usageCount[selectedRoom]++;
            }
        }

        // Find the room with the maximum usage
        int mostUsedRoom = 0;
        for (int i = 1; i < n; i++) {
            if (usageCount[i] > usageCount[mostUsedRoom]) {
                mostUsedRoom = i;
            }
        }

        return mostUsedRoom;
    }
}
