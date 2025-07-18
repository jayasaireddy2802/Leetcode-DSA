class Solution {
    public int maximumGroups(int[] grades) {
        int len = grades.length;
        int cnt = 1;

        while(cnt*(cnt + 1)/2 <= len)
            cnt++;

        return --cnt;
    }
}