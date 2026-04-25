class Solution {

    public int maxDistance(int side, int[][] points, int k) {
        List<Long> perimeterPoints = new ArrayList<>();

        // Convert 2D boundary points into 1D positions on perimeter
        for (int[] point : points) {
            int x = point[0], y = point[1];

            if (x == 0) {
                perimeterPoints.add((long) y);
            } else if (y == side) {
                perimeterPoints.add((long) side + x);
            } else if (x == side) {
                perimeterPoints.add(3L * side - y);
            } else {
                perimeterPoints.add(4L * side - x);
            }
        }

        Collections.sort(perimeterPoints);

        long left = 1, right = side;
        int result = 0;

        // Binary search on answer
        while (left <= right) {
            long midDist = left + (right - left) / 2;

            if (canPlace(perimeterPoints, side, k, midDist)) {
                result = (int) midDist;
                left = midDist + 1;
            } else {
                right = midDist - 1;
            }
        }

        return result;
    }

    // Check if we can select k points with at least 'dist' separation
    private boolean canPlace(List<Long> points, int side, int k, long dist) {
        long totalPerimeter = 4L * side;

        for (long startPoint : points) {
            long limit = startPoint + totalPerimeter - dist;
            long current = startPoint;
            boolean valid = true;

            for (int count = 1; count < k; count++) {
                int nextIdx = findNext(points, current + dist);

                if (nextIdx == points.size() || points.get(nextIdx) > limit) {
                    valid = false;
                    break;
                }

                current = points.get(nextIdx);
            }

            if (valid) return true;
        }

        return false;
    }

    // Custom lower bound implementation
    private int findNext(List<Long> list, long value) {
        int low = 0, high = list.size();

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (list.get(mid) < value) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return low;
    }
}