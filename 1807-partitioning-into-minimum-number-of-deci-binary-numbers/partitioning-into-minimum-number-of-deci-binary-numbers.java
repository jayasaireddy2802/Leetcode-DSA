class Solution {
    public int minPartitions(String value) {
        int maxDigit = 0;
        
        for (char c : value.toCharArray()) {
            int current = c - '0';
            if (current > maxDigit) {
                maxDigit = current;
            }
        }
        
        return maxDigit;
    }
}