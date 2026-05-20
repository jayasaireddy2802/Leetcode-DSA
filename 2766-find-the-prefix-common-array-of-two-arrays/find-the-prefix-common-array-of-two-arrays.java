class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;
        int[] freq = new int[n+1];
        int ct = 0;
        int[] res = new int[n];
        for(int i = 0 ; i < n ; i++)
        {
            freq[A[i]]++;
            freq[B[i]]++;
            if(A[i] == B[i])
            {
                ct++;
            }
            else
            {
                if(freq[A[i]] == 2)
                    ct++;
                if(freq[B[i]] == 2)
                    ct++;
            }
            res[i] = ct;
        }
        return res;
    }
}