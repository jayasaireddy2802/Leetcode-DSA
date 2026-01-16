import java.util.*;

class Solution {
    private static final int MOD = 1_000_000_007;

    public int maximizeSquareArea(int rows, int cols, int[] horizontalFences, int[] verticalFences) {

        List<Integer> horizontalPositions = new ArrayList<>();
        List<Integer> verticalPositions = new ArrayList<>();

        for (int fence : horizontalFences) horizontalPositions.add(fence);
        for (int fence : verticalFences) verticalPositions.add(fence);

        // Add boundary fences
        horizontalPositions.add(1);
        horizontalPositions.add(rows);
        verticalPositions.add(1);
        verticalPositions.add(cols);

        Collections.sort(horizontalPositions);
        Collections.sort(verticalPositions);

        Set<Integer> possibleWidths = new HashSet<>();

        // Calculate all possible vertical distances
        for (int i = 0; i < verticalPositions.size(); i++) {
            for (int j = i + 1; j < verticalPositions.size(); j++) {
                possibleWidths.add(
                    verticalPositions.get(j) - verticalPositions.get(i)
                );
            }
        }

        int maxSquareSide = 0;

        // Check matching horizontal distances
        for (int i = 0; i < horizontalPositions.size(); i++) {
            for (int j = i + 1; j < horizontalPositions.size(); j++) {
                int height = horizontalPositions.get(j) - horizontalPositions.get(i);
                if (possibleWidths.contains(height)) {
                    maxSquareSide = Math.max(maxSquareSide, height);
                }
            }
        }

        if (maxSquareSide == 0) return -1;

        long maxArea = (long) maxSquareSide * maxSquareSide;
        return (int) (maxArea % MOD);
    }
}
