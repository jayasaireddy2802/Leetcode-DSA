class Solution {

    public boolean isPossible(int mid, int[][] tasks)
    {
        for(int[] task : tasks)
        {
            int actual = task[0];
            int minimum = task[1];

            if(mid >= minimum)
            {
                mid -= actual;
            }

            else
                return false;
        }

        return true;
    }

    public int minimumEffort(int[][] tasks) {
        Arrays.sort(tasks, (task1, task2) -> {
            int rem1 = task1[1] - task1[0];
            int rem2 = task2[1] - task2[0];

            return rem2 - rem1;
        });

        int low = 0;
        int high = 1000000000;
        int ans = -1;

        while(low <= high)
        {
            int mid = low + (high - low)/2;

            if(isPossible(mid, tasks))
            {
                ans = mid;
                high = mid - 1;
            }
            else 
                low = mid + 1;
        }

        return ans;
    }
}