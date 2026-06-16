class Solution {
    public String processStr(String s) {
        StringBuilder sb = new StringBuilder();

        for (int k = 0; k < s.length(); k++) {
            char ch = s.charAt(k);

            if (ch >= 'a' && ch <= 'z') {
                sb.append(ch);
            }
            else if (ch == '*') {
                if (sb.length() > 0) {
                    sb.deleteCharAt(sb.length() - 1);  
                }
            }
            else if (ch == '#') {
                int size = sb.length();
                for (int i = 0; i < size; i++) {
                    sb.append(sb.charAt(i));           
                }
            }
            else if (ch == '%') {
                sb.reverse();                          
            }
        }

        return sb.toString();
    }
}