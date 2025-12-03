// class Solution {
//     public int countTrapezoids(int[][] points) {
//         Map<Integer, Integer> map = new HashMap<>();
//         int mod = 1000000007;

//         for(int[] point : points)
//         {
//             int x = point[0];
//             int y = point[1];

//             map.put(y, map.getOrDefault(y, 0) + 1);
//         }

//         long ans = 0;
//         int totalLines = 0;

//         for(int key : map.keySet())
//         {
//             long value = map.get(key);
//             long lines = (value*(value - 1) / 2) % mod;
//             ans = ans + (lines * totalLines) % mod;
//             totalLines += lines;
//         }

//         return (int)ans;
//     }
// }

class Solution {

    public int countTrapezoids(int[][] pts) {
        int n = pts.length;
        double VERTICAL_SLOPE = 1e9 + 7;

        // slope → list of intercepts
        Map<Double, List<Double>> slopeToIntercepts = new HashMap<>();

        // midpointKey → list of slopes
        Map<Integer, List<Double>> midpointToSlopes = new HashMap<>();

        int total = 0;

        for (int a = 0; a < n; a++) {
            int xA = pts[a][0];
            int yA = pts[a][1];

            for (int b = a + 1; b < n; b++) {
                int xB = pts[b][0];
                int yB = pts[b][1];

                int dx = xA - xB;
                int dy = yA - yB;

                double m;           // slope
                double c;           // intercept

                // Case 1: vertical line
                if (xA == xB) {
                    m = VERTICAL_SLOPE;
                    c = xA;
                } 
                // Case 2: normal line
                else {
                    m = (double)(yB - yA) / (double)(xB - xA);
                    c = (double)(yA * dx - xA * dy) / dx;
                }

                // avoid negative zero
                if (m == -0.0) m = 0.0;
                if (c == -0.0) c = 0.0;

                // create a compressed key for midpoint
                int midpointKey = (xA + xB) * 10000 + (yA + yB);

                slopeToIntercepts
                    .computeIfAbsent(m, k -> new ArrayList<>())
                    .add(c);

                midpointToSlopes
                    .computeIfAbsent(midpointKey, k -> new ArrayList<>())
                    .add(m);
            }
        }

        // Count trapezoids using pairs of parallel lines with unique intercepts
        for (List<Double> ints : slopeToIntercepts.values()) {
            if (ints.size() < 2) continue;

            TreeMap<Double, Integer> freq = new TreeMap<>();
            for (double b : ints)
                freq.put(b, freq.getOrDefault(b, 0) + 1);

            int running = 0;
            for (int count : freq.values()) {
                total += running * count;
                running += count;
            }
        }

        // Remove parallelogram over-counts
        for (List<Double> slopes : midpointToSlopes.values()) {
            if (slopes.size() < 2) continue;

            TreeMap<Double, Integer> freq = new TreeMap<>();
            for (double s : slopes)
                freq.put(s, freq.getOrDefault(s, 0) + 1);

            int running = 0;
            for (int count : freq.values()) {
                total -= running * count;
                running += count;
            }
        }

        return total;
    }
}
