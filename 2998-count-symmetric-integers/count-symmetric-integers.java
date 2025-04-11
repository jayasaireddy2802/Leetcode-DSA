class Solution {

    public boolean symmetric(int num){
        String str = Integer.toString(num);
        int leftSum = 0;
        int rightSum = 0;
        int len = str.length();
        if(len % 2 == 1)
            return false;
        int len1 = len / 2;
        for(int i = 0; i < len1; i++)
        {
            leftSum = leftSum + Integer.parseInt(String.valueOf(str.charAt(i)));
            rightSum = rightSum + Integer.parseInt(String.valueOf(str.charAt(len - i - 1)));
        }
        
        return (leftSum == rightSum);
    }

    public int countSymmetricIntegers(int low, int high) {

        int ct = 0;
        for(int i = low; i <= high; i++)
        {
            if(symmetric(i))
            {
                ct++;
            }
        }
        return ct;
    }
}