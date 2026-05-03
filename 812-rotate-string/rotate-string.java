class Solution {

    public boolean isValid(String s, String goal, int idx)
    {
        int len = s.length();
        
        for(int i = 0; i < len; i++)
        {
            if(s.charAt(i) != goal.charAt(idx))
                return false;
            idx = (idx + 1) % len;
        }

        return true;
    }
    public boolean rotateString(String s, String goal) {
        int len = s.length();
        int idx = -1;
        

        if(len != goal.length()) return false;

        for(int i = 0; i < len; i++)
        {
            char ch = s.charAt(i);

            for(int j = 0; j < len; j++)
            {
                if(goal.charAt(j) == ch)
                {
                    if(isValid(s, goal, j)) return true;
                }
            } 
        }

        return false;
    }
}