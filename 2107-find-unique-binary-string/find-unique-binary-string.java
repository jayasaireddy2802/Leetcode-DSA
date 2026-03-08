class Solution {
    public String findDifferentBinaryString(String[] nums) {
        Set<String> set = new HashSet<>();

        for(String str : nums)
        {
            set.add(str);
        }

        int num = 0;
        int len = nums[0].length();
        int i = 0;
        while(i < len)
        {
            num = num | (1 << i);
            i++;
        }

        for(int j = 0; j <= num; j++)
        {
            String binaryString = Integer.toString(j, 2);
            while (binaryString.length() < len) {
                binaryString = "0" + binaryString;
            }
            if(!set.contains(binaryString))
                return binaryString;
        }

        return "";
    }
}