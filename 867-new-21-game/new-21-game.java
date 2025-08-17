// class Solution {
//     public double new21Game(int n, int k, int maxPts) {
//         double[] P = new double[n + 1];
//         // P[i] = probability of getting score = i

//         P[0] = 1.0; // Initially score = 0, probability = 1

//         for (int i = 1; i <= n; i++) {
//             for (int j = 1; j <= maxPts; j++) {
//                 if (i - j >= 0 && i - j < k) {
//                     // Add probability from previous states
//                     P[i] += P[i - j] / maxPts;
//                 }
//             }
//         }

//         // Sum probabilities where score >= k
//         double ans = 0.0;
//         for (int i = k; i <= n; i++) {
//             ans += P[i];
//         }
//         return ans;
//     }
// }


class Solution {
    public double new21Game(int n, int k, int maxPts) {
        double[] P = new double[n + 1];
        // P[i] = probability of getting score = i

        P[0] = 1.0; // Initially score = 0, probability = 1

        double currProbabSum = (k > 0) ? 1.0 : 0.0;

        for (int i = 1; i <= n; i++) {
            P[i] = currProbabSum / maxPts;

            if (i < k) {
                currProbabSum += P[i];
            }

            if (i - maxPts >= 0 && i - maxPts < k) {
                currProbabSum -= P[i - maxPts];
            }
        }

        double ans = 0.0;
        for (int i = k; i <= n; i++) {
            ans += P[i];
        }

        return ans;
    }
}
