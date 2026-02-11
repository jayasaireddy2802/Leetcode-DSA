class LazyTag {
    int delta;

    LazyTag() {
        this.delta = 0;
    }

    LazyTag add(LazyTag other) {
        this.delta += other.delta;
        return this;
    }

    boolean exists() {
        return this.delta != 0;
    }

    void reset() {
        this.delta = 0;
    }
}

class SegmentTreeNode {
    int min;
    int max;
    LazyTag lazy;

    SegmentTreeNode() {
        this.min = 0;
        this.max = 0;
        this.lazy = new LazyTag();
    }
}

class SegmentTree {

    private int size;
    private SegmentTreeNode[] tree;

    SegmentTree(int[] data) {
        this.size = data.length;
        this.tree = new SegmentTreeNode[this.size * 4 + 1];
        for (int i = 0; i < tree.length; i++) {
            tree[i] = new SegmentTreeNode();
        }
        buildTree(data, 1, this.size, 1);
    }

    void rangeAdd(int left, int right, int value) {
        LazyTag tag = new LazyTag();
        tag.delta = value;
        updateRange(left, right, tag, 1, this.size, 1);
    }

    int findLastPosition(int start, int targetValue) {
        if (start > this.size) return -1;
        return query(start, this.size, targetValue, 1, this.size, 1);
    }

    private void applyLazy(int node, LazyTag tag) {
        tree[node].min += tag.delta;
        tree[node].max += tag.delta;
        tree[node].lazy.add(tag);
    }

    private void pushDown(int node) {
        if (tree[node].lazy.exists()) {
            LazyTag tag = new LazyTag();
            tag.delta = tree[node].lazy.delta;
            applyLazy(node << 1, tag);
            applyLazy((node << 1) | 1, tag);
            tree[node].lazy.reset();
        }
    }

    private void pushUp(int node) {
        tree[node].min = Math.min(
            tree[node << 1].min,
            tree[(node << 1) | 1].min
        );
        tree[node].max = Math.max(
            tree[node << 1].max,
            tree[(node << 1) | 1].max
        );
    }

    private void buildTree(int[] data, int left, int right, int node) {
        if (left == right) {
            tree[node].min = tree[node].max = data[left - 1];
            return;
        }

        int midPoint = left + ((right - left) >> 1);
        buildTree(data, left, midPoint, node << 1);
        buildTree(data, midPoint + 1, right, (node << 1) | 1);
        pushUp(node);
    }

    private void updateRange(
        int targetLeft,
        int targetRight,
        LazyTag tag,
        int left,
        int right,
        int node
    ) {
        if (targetLeft <= left && right <= targetRight) {
            applyLazy(node, tag);
            return;
        }

        pushDown(node);
        int midPoint = left + ((right - left) >> 1);

        if (targetLeft <= midPoint)
            updateRange(targetLeft, targetRight, tag, left, midPoint, node << 1);

        if (targetRight > midPoint)
            updateRange(
                targetLeft,
                targetRight,
                tag,
                midPoint + 1,
                right,
                (node << 1) | 1
            );

        pushUp(node);
    }

    private int query(
        int queryLeft,
        int queryRight,
        int value,
        int left,
        int right,
        int node
    ) {
        if (tree[node].min > value || tree[node].max < value) {
            return -1;
        }

        if (left == right) {
            return left;
        }

        pushDown(node);
        int midPoint = left + ((right - left) >> 1);

        if (queryRight >= midPoint + 1) {
            int result = query(
                queryLeft,
                queryRight,
                value,
                midPoint + 1,
                right,
                (node << 1) | 1
            );
            if (result != -1) return result;
        }

        if (queryLeft <= midPoint) {
            return query(
                queryLeft,
                queryRight,
                value,
                left,
                midPoint,
                node << 1
            );
        }

        return -1;
    }
}

class Solution {

    public int longestBalanced(int[] nums) {
        Map<Integer, Queue<Integer>> indexMap = new HashMap<>();

        int maxLength = 0;
        int[] balancePrefix = new int[nums.length];

        balancePrefix[0] = parityValue(nums[0]);
        indexMap.computeIfAbsent(nums[0], k -> new LinkedList<>()).add(1);

        for (int i = 1; i < nums.length; i++) {
            balancePrefix[i] = balancePrefix[i - 1];
            Queue<Integer> positions =
                indexMap.computeIfAbsent(nums[i], k -> new LinkedList<>());

            if (positions.isEmpty()) {
                balancePrefix[i] += parityValue(nums[i]);
            }
            positions.add(i + 1);
        }

        SegmentTree segmentTree = new SegmentTree(balancePrefix);

        for (int i = 0; i < nums.length; i++) {
            int lastPos = segmentTree.findLastPosition(i + maxLength, 0);
            if (lastPos != -1) {
                maxLength = Math.max(maxLength, lastPos - i);
            }

            int nextIndex = nums.length + 1;
            Queue<Integer> positions = indexMap.get(nums[i]);
            positions.poll();
            if (!positions.isEmpty()) {
                nextIndex = positions.peek();
            }

            segmentTree.rangeAdd(
                i + 1,
                nextIndex - 1,
                -parityValue(nums[i])
            );
        }

        return maxLength;
    }

    private int parityValue(int x) {
        return (x % 2 == 0) ? 1 : -1;
    }
}
