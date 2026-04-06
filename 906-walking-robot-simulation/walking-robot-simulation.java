import java.util.*;

class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        int x = 0;
        int y = 0;
        char[] dirs = {'N','E','S','W'};
        int idx = 0;
        char dir = 'N';

        
        Set<String> isObstacle = new HashSet<>();
        for (int[] obstacle : obstacles) {
            isObstacle.add(obstacle[0] + "," + obstacle[1]);
        }

        int maxDistance = 0;

        for (int command : commands) {
            if (command == -1) {
                idx = (idx + 1) % 4;
                dir = dirs[idx];
            } else if (command == -2) {
                idx = (idx - 1 + 4) % 4;
                dir = dirs[idx];
            } else {

                
                for (int i = 0; i < command; i++) {
                    int nextX = x;
                    int nextY = y;

                    if (dir == 'N') nextY++;
                    else if (dir == 'E') nextX++;
                    else if (dir == 'S') nextY--;
                    else nextX--;

                    
                    if (isObstacle.contains(nextX + "," + nextY)) {
                        break;
                    }

                    x = nextX;
                    y = nextY;

                    maxDistance = Math.max(maxDistance, x * x + y * y);
                }
            }
        }

        return maxDistance;
    }
}