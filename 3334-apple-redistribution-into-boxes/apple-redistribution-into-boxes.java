class Solution {
    public int minimumBoxes(int[] apple, int[] capacity) {
        Arrays.sort(capacity);
        for(int i = 0, j = capacity.length - 1; i < j; i++, j--)
        {
            int temp = capacity[i];
            capacity[i] = capacity[j];
            capacity[j] = temp; 
        }
        int len = capacity.length;
        int sum = 0;

        for(int val : apple)
            sum += val;

        int i = 0;
        while(i < len)
        {
            if(sum <= 0)
                break;
            sum -= capacity[i];
            i++;
        }

        return i;
    }
}