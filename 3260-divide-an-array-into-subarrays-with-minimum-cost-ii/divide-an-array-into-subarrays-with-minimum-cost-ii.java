class Container {

    private int limit;
    private int smallSize;
    private int largeSize;

    // smallSet stores the smallest `limit` elements
    // largeSet stores the remaining elements
    private TreeMap<Integer, Integer> smallSet;
    private TreeMap<Integer, Integer> largeSet;

    // sum of the smallest `limit` elements
    private long smallSum;

    public Container(int limit) {
        this.limit = limit;
        this.smallSet = new TreeMap<>();
        this.largeSet = new TreeMap<>();
        this.smallSum = 0;
        this.smallSize = 0;
        this.largeSize = 0;
    }

    private void removeOne(TreeMap<Integer, Integer> map, int value) {
        int count = map.get(value);
        if (count == 1) {
            map.remove(value);
        } else {
            map.put(value, count - 1);
        }
    }

    private void addOne(TreeMap<Integer, Integer> map, int value) {
        map.put(value, map.getOrDefault(value, 0) + 1);
    }

    private void rebalance() {
        while (smallSize < limit && !largeSet.isEmpty()) {
            int value = largeSet.firstKey();
            addOne(smallSet, value);
            smallSize++;
            smallSum += value;

            removeOne(largeSet, value);
            largeSize--;
        }

        while (smallSize > limit) {
            int value = smallSet.lastKey();
            addOne(largeSet, value);
            largeSize++;

            removeOne(smallSet, value);
            smallSize--;
            smallSum -= value;
        }
    }

    // Insert value
    public void add(int value) {
        if (!largeSet.isEmpty() && value >= largeSet.firstKey()) {
            addOne(largeSet, value);
            largeSize++;
        } else {
            addOne(smallSet, value);
            smallSize++;
            smallSum += value;
        }
        rebalance();
    }

    // Remove value
    public void remove(int value) {
        if (smallSet.containsKey(value)) {
            removeOne(smallSet, value);
            smallSize--;
            smallSum -= value;
        } else if (largeSet.containsKey(value)) {
            removeOne(largeSet, value);
            largeSize--;
        }
        rebalance();
    }

    public long getSmallestSum() {
        return smallSum;
    }
}

class Solution {

    public long minimumCost(int[] nums, int k, int dist) {
        int n = nums.length;

        Container container = new Container(k - 2);

        for (int i = 1; i < k - 1; i++) {
            container.add(nums[i]);
        }

        long minCost = container.getSmallestSum() + nums[k - 1];

        for (int i = k; i < n; i++) {
            int removeIndex = i - dist - 1;
            if (removeIndex > 0) {
                container.remove(nums[removeIndex]);
            }

            container.add(nums[i - 1]);
            minCost = Math.min(minCost, container.getSmallestSum() + nums[i]);
        }

        return minCost + nums[0];
    }
}
