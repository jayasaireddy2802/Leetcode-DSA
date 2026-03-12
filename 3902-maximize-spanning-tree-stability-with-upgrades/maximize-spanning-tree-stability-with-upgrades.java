class UnionFind {

    private int[] root;

    public UnionFind(int[] base) {
        root = base.clone();
    }

    public int getRoot(int x) {
        if (root[x] == x) {
            return x;
        }
        root[x] = getRoot(root[x]);
        return root[x];
    }

    public void connect(int a, int b) {
        int ra = getRoot(a);
        int rb = getRoot(b);
        root[ra] = rb;
    }

    public int[] snapshot() {
        return root;
    }
}

public class Solution {

    private static final int INF = 200000;

    public int maxStability(int nodes, int[][] edges, int k) {

        if (edges.length < nodes - 1) {
            return -1;
        }

        List<int[]> mandatory = new ArrayList<>();
        List<int[]> optional = new ArrayList<>();

        for (int[] e : edges) {
            if (e[3] == 1) {
                mandatory.add(e);
            } else {
                optional.add(e);
            }
        }

        if (mandatory.size() > nodes - 1) {
            return -1;
        }

        optional.sort((a, b) -> Integer.compare(b[2], a[2]));

        int[] baseParent = new int[nodes];
        for (int i = 0; i < nodes; i++) {
            baseParent[i] = i;
        }

        UnionFind baseUF = new UnionFind(baseParent);

        int usedEdges = 0;
        int minMandatoryWeight = INF;

        for (int[] e : mandatory) {
            int u = e[0];
            int v = e[1];
            int weight = e[2];

            if (baseUF.getRoot(u) == baseUF.getRoot(v) || usedEdges == nodes - 1) {
                return -1;
            }

            baseUF.connect(u, v);
            usedEdges++;
            minMandatoryWeight = Math.min(minMandatoryWeight, weight);
        }

        int left = 0;
        int right = minMandatoryWeight;
        int result = -1;

        while (left < right) {

            int target = left + (right - left + 1) / 2;

            UnionFind uf = new UnionFind(baseUF.snapshot());
            int edgesChosen = usedEdges;
            int boosted = 0;

            for (int[] e : optional) {

                int u = e[0];
                int v = e[1];
                int weight = e[2];

                if (uf.getRoot(u) == uf.getRoot(v)) {
                    continue;
                }

                if (weight >= target) {
                    uf.connect(u, v);
                } 
                else if (boosted < k && weight * 2 >= target) {
                    boosted++;
                    uf.connect(u, v);
                } 
                else {
                    break;
                }

                edgesChosen++;

                if (edgesChosen == nodes - 1) {
                    break;
                }
            }

            if (edgesChosen == nodes - 1) {
                result = target;
                left = target;
            } else {
                right = target - 1;
            }
        }

        return result;
    }
}