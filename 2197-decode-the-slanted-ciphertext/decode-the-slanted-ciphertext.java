class Solution {
    public String decodeCiphertext(String encodedText, int rows) {
        int len = encodedText.length();
        int cols = len/rows;
        char[][] arr = new char[rows][cols];
        int k = 0;
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < rows; i++)
        {
            for(int j = 0; j < cols; j++)
            {
                arr[i][j] = encodedText.charAt(k);
                k++;
            }
        }
        
        for(k = 0; k < cols; k++)
        {
            int i = 0;
            int j = k;

            while(i < rows && j < cols)
            {
                sb.append(arr[i][j]);
                i++;
                j++;
            }
        }

        String str = sb.toString();
        return str.stripTrailing();
    }
}