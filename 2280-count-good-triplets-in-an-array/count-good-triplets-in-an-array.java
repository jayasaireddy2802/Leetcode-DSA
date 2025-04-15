import java.util.*;

class Solution {
    public long goodTriplets(int[] nums1, int[] nums2) {
        int n = nums1.length;

        Map<Integer, Integer> pos2 = new HashMap<>();
        for (int i = 0; i < n; i++) {
            pos2.put(nums2[i], i);
        }

        int[] position = new int[n];
        for (int i = 0; i < n; i++) {
            position[i] = pos2.get(nums1[i]);
        }

        SegmentTree leftSeg = new SegmentTree(n);
        SegmentTree rightSeg = new SegmentTree(n);

        for (int i = 2; i < n; i++) {
            rightSeg.update(position[i], 1);
        }

        long ans = 0;
        leftSeg.update(position[0], 1);

        for (int i = 1; i < n - 1; i++) {
            int k = position[i];
            int a = leftSeg.query(0, k - 1);
            int b = rightSeg.query(k + 1, n - 1);
            ans += (long) a * b;
            leftSeg.update(k, 1);
            rightSeg.update(position[i + 1], 0);
        }

        return ans;
    }

    static class SegmentTree {
        int[] tree;
        int size;

        SegmentTree(int n) {
            size = n;
            tree = new int[4 * n];
        }

        void update(int index, int value) {
            update(0, 0, size - 1, index, value);
        }

        void update(int node, int l, int r, int idx, int val) {
            if (l == r) {
                tree[node] = val == 0 ? 0 : tree[node] + val;
                return;
            }
            int mid = (l + r) / 2;
            if (idx <= mid) update(2 * node + 1, l, mid, idx, val);
            else update(2 * node + 2, mid + 1, r, idx, val);
            tree[node] = tree[2 * node + 1] + tree[2 * node + 2];
        }

        int query(int ql, int qr) {
            return query(0, 0, size - 1, ql, qr);
        }

        int query(int node, int l, int r, int ql, int qr) {
            if (ql > r || qr < l) return 0;
            if (ql <= l && r <= qr) return tree[node];
            int mid = (l + r) / 2;
            return query(2 * node + 1, l, mid, ql, qr) + query(2 * node + 2, mid + 1, r, ql, qr);
        }
    }
}
