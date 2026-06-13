class Solution {
    public String mapWordWeights(String[] words, int[] weights) {
        char[] arr = new char[26];
        char ch = 'z';
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < 26; i++)
        {
            arr[i] = (char)(ch - i);
        }

        for(String word : words)
        {
            int len = word.length();
            int sum = 0;

            for(int i = 0; i < len; i++)
            {
                sum += weights[word.charAt(i) - 'a'];
            }
            sum = sum % 26;
            sb = sb.append(arr[sum]);
        }   

        return sb.toString();
    }
}