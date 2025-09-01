// class Solution {
//     public double maxAverageRatio(int[][] classes, int extraStudents) {
        
//     }
// }

// import java.util.*;

// class Solution {
//     public double maxAverageRatio(int[][] groups, int extra) {
//         int totalClasses = groups.length;

//         // Store current success ratios
//         double[] ratios = new double[totalClasses];
//         for (int idx = 0; idx < totalClasses; idx++) {
//             ratios[idx] = (double) groups[idx][0] / groups[idx][1];
//         }

//         // Distribute extra students one by one
//         while (extra-- > 0) {
//             double[] nextRatios = new double[totalClasses];

//             // Compute potential ratios after adding one student
//             for (int idx = 0; idx < totalClasses; idx++) {
//                 nextRatios[idx] = (double) (groups[idx][0] + 1) / (groups[idx][1] + 1);
//             }

//             // Pick the class with the maximum improvement
//             int chosen = 0;
//             double gain = -1;
//             for (int idx = 0; idx < totalClasses; idx++) {
//                 double diff = nextRatios[idx] - ratios[idx];
//                 if (diff > gain) {
//                     gain = diff;
//                     chosen = idx;
//                 }
//             }

//             // Update the chosen class
//             ratios[chosen] = nextRatios[chosen];
//             groups[chosen][0]++;
//             groups[chosen][1]++;
//         }

//         // Compute average of all ratios
//         double sum = 0;
//         for (double val : ratios) {
//             sum += val;
//         }

//         return sum / totalClasses;
//     }
// }

import java.util.PriorityQueue;

class Solution {
    public double maxAverageRatio(int[][] groups, int extra) {
        int total = groups.length;

        // Max-heap based on improvement in ratio
        PriorityQueue<double[]> heap = new PriorityQueue<>((a, b) -> Double.compare(b[0], a[0]));

        // Load heap with initial gain values
        for (int i = 0; i < total; i++) {
            double improvement = gain(groups[i][0], groups[i][1]);
            heap.offer(new double[]{improvement, i});
        }

        // Assign extra students greedily
        while (extra-- > 0) {
            double[] top = heap.poll();
            int idx = (int) top[1];

            groups[idx][0]++;
            groups[idx][1]++;

            double updatedGain = gain(groups[idx][0], groups[idx][1]);
            heap.offer(new double[]{updatedGain, idx});
        }

        // Compute overall average ratio
        double avg = 0.0;
        for (int[] g : groups) {
            avg += (double) g[0] / g[1];
        }

        return avg / total;
    }

    // Helper: calculates the benefit of adding one more passing student
    private double gain(int pass, int total) {
        double curr = (double) pass / total;
        double next = (double) (pass + 1) / (total + 1);
        return next - curr;
    }
}
