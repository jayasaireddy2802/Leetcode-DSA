class Solution {
    public String answerString(String word, int numFriends) {
        int len = word.length();
        int possible = len - (numFriends - 1);
        String ans = "";
        if (numFriends == 1) {
            return word;
        }
        for(int i = 0; i < len; i++)
        {
            int res = Math.min(possible, len-i);
            String sub = word.substring(i, i + res);
            if (sub.compareTo(ans) > 0) {
                ans = sub;
            }
        }

        return ans;
    }
}