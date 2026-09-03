class Solution {
    public boolean uniformArray(int[] nums1) {
        int len = nums1.length;
        int minOdd = Integer.MAX_VALUE;
        int oddCnt = 0;
        int evenCnt = 0;

        for(int num : nums1)
        {
            if(num % 2 == 0)
            {
                evenCnt++;
            }
            else
            {
                oddCnt++;
                minOdd = Math.min(minOdd, num);
            }
        }

        if(oddCnt == len || evenCnt == len)
            return true;

        for(int num : nums1)
        {
            if(num % 2 == 0)
            {
                if(num - minOdd < 1)
                    return false;
            }
        }

        return true;

    }
}