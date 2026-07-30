class Solution {
    public int minimumPushes(String word) {
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        StringBuilder sb3 = new StringBuilder();
        StringBuilder sb4 = new StringBuilder();
        int len = word.length();
        int ans = 0;

        for(int i = 0; i < len; i++)
        {
            char ch = word.charAt(i);

            if(sb1.indexOf(String.valueOf(ch)) != -1) continue;
            else if(sb2.indexOf(String.valueOf(ch)) != -1) continue;
            else if(sb3.indexOf(String.valueOf(ch)) != -1) continue;
            else if(sb4.indexOf(String.valueOf(ch)) != -1) continue;

            if(sb1.length() < 8)
                sb1.append(ch);
            
            else if(sb2.length() < 8)
                sb2.append(ch);

            else if(sb3.length() < 8)
                sb3.append(ch);
            
            else if(sb4.length() < 8)
                sb4.append(ch);
            
        }

        for(int i = 0; i < len; i++)
        {
            char ch = word.charAt(i);

            if(sb1.indexOf(String.valueOf(ch)) != -1) ans++;
            else if(sb2.indexOf(String.valueOf(ch)) != -1) ans += 2;
            else if(sb3.indexOf(String.valueOf(ch)) != -1) ans += 3;
            else if(sb4.indexOf(String.valueOf(ch)) != -1) ans += 4;
        }

        return ans;
        
    }
}