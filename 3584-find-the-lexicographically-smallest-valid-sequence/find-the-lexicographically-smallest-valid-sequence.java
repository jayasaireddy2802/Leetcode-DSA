class Solution {
    public int[] validSequence(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        int[] ans = new int[len2];
        int j = len2 - 1;
        int[] matchFreq = new int[len1 + 1];

        for(int i = len1 - 1; i >= 0; i--)
        {
            if(j >= 0 && word1.charAt(i) == word2.charAt(j))
            {
                j--;
                matchFreq[i] = matchFreq[i + 1] + 1;
            }

            else 
                matchFreq[i] = matchFreq[i + 1];
        }

        j = 0;
        int i = 0;
        int idx = 0;
        boolean canChange = true;
        while (i < len1 && j < len2)
        {
            if(j < len2 && word1.charAt(i) == word2.charAt(j))
            {
                ans[idx] = i;
                j++;
                idx++;
            }
            
            else if(canChange == true && matchFreq[i + 1] >= len2 - j - 1)
            {
                ans[idx] = i;
                canChange = false;
                j++;
                idx++;
            }
            i++;   
        }

        return idx == len2 ? ans : new int[0];
    }
}