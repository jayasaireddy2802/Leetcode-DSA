class Solution {
    public int bestClosingTime(String customers) {
        int idx = -1;
        int min = Integer.MAX_VALUE;
        int len = customers.length();
        int y_count = 0;
        int n_count = 0;

        for(int i = 0; i < len; i++)
        {
            if(customers.charAt(i) == 'Y')
                y_count++;
        }

        for(int i = 0; i < len; i++)
        {
            int penalty = n_count + y_count;
            if(penalty < min)
            {
                min = penalty;
                idx = i;
            }

            if(customers.charAt(i) == 'N')
                n_count++;
            else
                y_count--;
        }
        int penalty = n_count + y_count;
        if(penalty < min)
        {
            min = penalty;
            idx = len;
        }

        return idx;
    }
}