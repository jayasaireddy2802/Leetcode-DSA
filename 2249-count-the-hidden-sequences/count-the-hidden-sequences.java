class Solution {
    public int numberOfArrays(int[] differences, int lower, int upper) {
        int curr = 0;
        int mini = 0;
        int maxi = 0;

        for(int diff : differences)
        {
            curr = curr + diff;

            mini = Math.min(mini, curr);
            maxi = Math.max(maxi, curr);

            if((upper - lower) - (maxi - mini) + 1 < 0)
                return 0; 
        }

        return (upper - lower) - (maxi - mini) + 1;
    }
}