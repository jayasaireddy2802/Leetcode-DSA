// class Solution {

//     public long getXSum(Map<Integer, Integer> map, int x)
//     {
//         long sum = 0;
//         PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] == b[1] ? b[0] - a[0] : b[1] - a[1]);

//         for(int key : map.keySet())
//         {
//             pq.add(new int[]{key, map.get(key)});
//         }

//         while(!pq.isEmpty() && x > 0)
//         {
//             int[] arr = pq.poll();
//             sum += (long)arr[0] * arr[1];
//             x--;
//         }

//         return sum;
//     }

//     public long[] findXSum(int[] nums, int k, int x) {
        
//         int len = nums.length;
//         long[] ans = new long[len - k + 1];
//         Map<Integer, Integer> map = new HashMap<>();
        
//         int i = 0;
//         while(i < k)
//         {
//             map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
//             i++;
//         }

//         long sum = getXSum(map, x);
//         ans[0] = sum;
//         int j = 0;

//         while(i < len)
//         {
//             map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
//             i++;

//             if(map.get(nums[j]) == 1)
//                 map.remove(nums[j]);
//             else
//                 map.put(nums[j], map.getOrDefault(nums[j], 0) - 1);
//             j++;

//             sum = getXSum(map, x);
//             ans[j] = sum;
//         }

//         return ans;
//     }
// }


class Solution {
    long topXSum = 0; // sum of top x frequency*value
    TreeSet<int[]> topSet;  // Stores top-x (freq, val)
    TreeSet<int[]> restSet; // Stores remaining (freq, val)
    Map<Integer, Integer> frequencyMap; // value -> frequency

    public long[] findXSum(int[] nums, int k, int x) {
        int n = nums.length;
        topXSum = 0;
        frequencyMap = new HashMap<>();

        // Comparator: sort by freq ascending, and if tie, value ascending
        Comparator<int[]> pairComparator = (a, b) -> {
            if (a[0] != b[0]) return Integer.compare(a[0], b[0]);
            return Integer.compare(a[1], b[1]);
        };

        topSet = new TreeSet<>(pairComparator);
        restSet = new TreeSet<>(pairComparator);

        List<Long> resultList = new ArrayList<>();

        int left = 0, right = 0;
        while (right < n) {
            int current = nums[right];

            // Remove old pair if exists
            if (frequencyMap.getOrDefault(current, 0) > 0) {
                removeFromSets(new int[]{frequencyMap.get(current), current}, x);
            }

            // Increase frequency
            frequencyMap.put(current, frequencyMap.getOrDefault(current, 0) + 1);

            // Insert updated pair
            insertIntoSets(new int[]{frequencyMap.get(current), current}, x);

            // Window size reached
            if (right - left + 1 == k) {
                resultList.add(topXSum);

                // Remove outgoing number
                int outgoing = nums[left];
                removeFromSets(new int[]{frequencyMap.get(outgoing), outgoing}, x);
                frequencyMap.put(outgoing, frequencyMap.get(outgoing) - 1);

                if (frequencyMap.get(outgoing) == 0) {
                    frequencyMap.remove(outgoing);
                } else {
                    insertIntoSets(new int[]{frequencyMap.get(outgoing), outgoing}, x);
                }

                left++;
            }

            right++;
        }

        long[] result = new long[resultList.size()];
        for (int i = 0; i < resultList.size(); i++) result[i] = resultList.get(i);
        return result;
    }

    void insertIntoSets(int[] pair, int x) {
        // Try inserting into topSet if it has space or this pair is better
        if (topSet.size() < x || comparePairs(pair, topSet.first()) > 0) {
            topXSum += 1L * pair[0] * pair[1];
            topSet.add(pair);

            // If topSet exceeds size x, move smallest to restSet
            if (topSet.size() > x) {
                int[] lowestTopPair = topSet.first();
                topXSum -= 1L * lowestTopPair[0] * lowestTopPair[1];
                topSet.remove(lowestTopPair);
                restSet.add(lowestTopPair);
            }
        } else {
            restSet.add(pair);
        }
    }

    void removeFromSets(int[] pair, int x) {
        if (topSet.contains(pair)) {
            topXSum -= 1L * pair[0] * pair[1];
            topSet.remove(pair);

            // Promote best candidate from restSet
            if (!restSet.isEmpty()) {
                int[] highestRestPair = restSet.last();
                restSet.remove(highestRestPair);
                topSet.add(highestRestPair);
                topXSum += 1L * highestRestPair[0] * highestRestPair[1];
            }
        } else {
            restSet.remove(pair);
        }
    }

    int comparePairs(int[] a, int[] b) {
        if (a[0] != b[0]) return Integer.compare(a[0], b[0]);
        return Integer.compare(a[1], b[1]);
    }
}
// 