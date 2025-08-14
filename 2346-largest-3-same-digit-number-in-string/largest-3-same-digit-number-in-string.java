class Solution {
    public String largestGoodInteger(String num) {

        String ans = "";
        char prev = num.charAt(0);
        int ct = 0;

        for(char ch : num.toCharArray())
        {
            if(prev == ch)
                ct++;
            else
                ct = 1;
            if(ct == 3)
            {
                if(ans == "")
                {
                    ans = ans + ch;
                }
                else
                {
                    if(ch > ans.charAt(0))
                        ans = "" + ch;
                }
            }
            prev = ch;
        }


        if(ans != "")
        {
            int val = 0;
            char ch = ans.charAt(0);
            while(val < 2)
            {
                ans = ans + ch;
                val++;
            }

        }

        return ans;
    }
}