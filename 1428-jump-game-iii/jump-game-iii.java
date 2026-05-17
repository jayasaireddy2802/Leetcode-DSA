class Solution {
    public boolean solve(int[] arr, int idx, Set<Integer> set)
    {
        int len = arr.length;
        if(idx < 0 || idx >= len)
            return false;
        if(arr[idx] == 0)
            return true;
        if(set.contains(idx))
            return false;

        set.add(idx);
        
        boolean right = solve(arr, idx + arr[idx], set);
        boolean left = solve(arr, idx - arr[idx], set);

        return (right || left);

    }
    public boolean canReach(int[] arr, int start) {
        return solve(arr, start, new HashSet<>());
    }
}