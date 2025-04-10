class Solution {
    
    private long countNumbersWithSuffix(String numStr, String requiredSuffix, int maxDigit) {
        if (numStr.length() < requiredSuffix.length()) {
            return 0;
        }

        long result = 0;
        int prefixLen = numStr.length() - requiredSuffix.length();
        String currentSuffix = numStr.substring(numStr.length() - requiredSuffix.length());

        for (int idx = 0; idx < prefixLen; idx++) {
            int currentDigit = numStr.charAt(idx) - '0';

            if (currentDigit <= maxDigit) {
                result += currentDigit * Math.pow(maxDigit + 1, prefixLen - idx - 1);
            } else {
                result += Math.pow(maxDigit + 1, prefixLen - idx);
                return result;
            }
        }

        if (currentSuffix.compareTo(requiredSuffix) >= 0) {
            result++;
        }

        return result;
    }

   
    public long numberOfPowerfulInt(long rangeStart, long rangeEnd, int digitLimit, String suffix) {
        String startAsString = String.valueOf(rangeStart - 1);
        String endAsString = String.valueOf(rangeEnd);
        return countNumbersWithSuffix(endAsString, suffix, digitLimit)
             - countNumbersWithSuffix(startAsString, suffix, digitLimit);
    }
}
