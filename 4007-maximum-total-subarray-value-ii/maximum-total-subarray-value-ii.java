class SegmentHelper {
    private int[] tree;
    private boolean isMinTree;

    public SegmentHelper(int[] arr, boolean isMinTree) {
        int n = arr.length;
        this.isMinTree = isMinTree;
        this.tree = new int[4 * n];
        buildTree(0, 0, n - 1, arr);
    }

    private void buildTree(int idx, int start, int end, int[] arr) {
        if (start == end) {
            tree[idx] = arr[start];
            return;
        }

        int mid = start + (end - start) / 2;

        buildTree(2 * idx + 1, start, mid, arr);
        buildTree(2 * idx + 2, mid + 1, end, arr);

        if (isMinTree) {
            tree[idx] = Math.min(tree[2 * idx + 1], tree[2 * idx + 2]);
        } else {
            tree[idx] = Math.max(tree[2 * idx + 1], tree[2 * idx + 2]);
        }
    }

    private int rangeQuery(int ql, int qr, int idx, int start, int end) {
        // No overlap
        if (end < ql || start > qr) {
            return isMinTree ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        }

        // Complete overlap
        if (ql <= start && end <= qr) {
            return tree[idx];
        }

        int mid = start + (end - start) / 2;

        int left = rangeQuery(ql, qr, 2 * idx + 1, start, mid);
        int right = rangeQuery(ql, qr, 2 * idx + 2, mid + 1, end);

        return isMinTree ? Math.min(left, right) : Math.max(left, right);
    }

    public int query(int l, int r, int n) {
        return rangeQuery(l, r, 0, 0, n - 1);
    }
}

class Solution {
    private long calculateValue(int l, int r, SegmentHelper minTree, SegmentHelper maxTree, int n) {
        int minVal = minTree.query(l, r, n);
        int maxVal = maxTree.query(l, r, n);
        return (long) maxVal - minVal;
    }

    public long maxTotalValue(int[] nums, int k) {
        int n = nums.length;

        SegmentHelper minTree = new SegmentHelper(nums, true);
        SegmentHelper maxTree = new SegmentHelper(nums, false);

        // Max Heap -> {value, left, right}
        PriorityQueue<long[]> maxHeap = new PriorityQueue<>(
                (a, b) -> Long.compare(b[0], a[0])
        );

        // Initialize heap
        for (int i = 0; i < n; i++) {
            long val = calculateValue(i, n - 1, minTree, maxTree, n);
            maxHeap.offer(new long[]{val, i, n - 1});
        }

        long answer = 0;

        while (k-- > 0) {
            long[] curr = maxHeap.poll();

            long val = curr[0];
            int left = (int) curr[1];
            int right = (int) curr[2];

            answer += val;

            if (left <= right - 1) {
                long nextVal = calculateValue(left, right - 1, minTree, maxTree, n);
                maxHeap.offer(new long[]{nextVal, left, right - 1});
            }
        }

        return answer;
    }
}