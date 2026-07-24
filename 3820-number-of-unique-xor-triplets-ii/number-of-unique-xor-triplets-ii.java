// class Solution {
//     public int uniqueXorTriplets(int[] nums) {
//         int len = nums.length;
//         Set<Integer> set = new HashSet<>();
//         Set<Integer> ans = new HashSet<>();

//         for (int i = 0; i < len; i++) {
//             for (int j = 0; j < len; j++) {
//                 set.add(nums[i] ^ nums[j]);
//             }
//         }

//         int size = set.size();
//         for (int i = 0; i < len; i++) {
//             for (int num : set) {
//                 ans.add(num ^ nums[i]);
//             }
//         }
//         return ans.size();
//     }
// }

// class Solution {
//     public int uniqueXorTriplets(int[] nums) {
//         Set<Integer> curr = new HashSet<>();
//         curr.add(0); // base

//         // Apply XOR 3 times (triplets)
//         for (int step = 0; step < 3; step++) {
//             Set<Integer> next = new HashSet<>();
//             for (int val : curr) {
//                 for (int num : nums) {
//                     next.add(val ^ num);
//                 }
//             }
//             curr = next;
//         }

//         return curr.size();
//     }
// }


class Solution {
    public int uniqueXorTriplets(int[] nums) {
        int n = nums.length;

        // Find upper bound for XOR values
        int limit = 1;
        int maxVal = 0;
        for (int v : nums) {
            if (v > maxVal) maxVal = v;
        }
        while (limit <= maxVal) {
            limit <<= 1;
        }

        // Track reachable XORs
        boolean[] pairXor = new boolean[limit];
        boolean[] tripletXor = new boolean[limit];

        // Step 1: Compute XOR of all pairs
        for (int a : nums) {
            for (int b : nums) {
                pairXor[a ^ b] = true;
            }
        }

        // Step 2: Extend to triplets
        for (int x = 0; x < limit; x++) {
            if (!pairXor[x]) continue;

            for (int val : nums) {
                tripletXor[x ^ val] = true;
            }
        }

        // Step 3: Count distinct results
        int result = 0;
        for (boolean exists : tripletXor) {
            if (exists) result++;
        }

        return result;
    }
}