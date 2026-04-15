class Solution {
    public int closestTarget(String[] words, String target, int startIndex) {
        int len = words.length;
        int mini = 200;
        int ct = 0;
        int idx = startIndex;

        while(true)
        {
            if(words[idx].equals(target))
                mini = Math.min(ct, mini);
            if(ct > len) break;
            ct++;
            idx = (idx + 1) % len;
        }

        idx = startIndex;
        ct = 0;
        while(true)
        {
            if(words[idx].equals(target))
                mini = Math.min(ct, mini);
            if(ct > len) break;
            ct++;
            idx = (idx - 1 + len) % len;
        }

        return (mini == 200) ? -1 : mini;
    }
}