class Solution {

    public void swap(int i, int j, StringBuilder sb)
    {
        char ch = sb.charAt(i);
        sb.setCharAt(i, sb.charAt(j));
        sb.setCharAt(j, ch);
    }

    public boolean canBeEqual(String s1, String s2) {
        int len = 4;

        if(s1.equals(s2)) return true;

        StringBuilder sb1 = new StringBuilder(s2);
        swap(0, 2, sb1);
        if(s1.equals(sb1.toString())) return true;

        sb1 = new StringBuilder(s2);
        swap(1, 3, sb1);
        if(s1.equals(sb1.toString())) return true;

        sb1 = new StringBuilder(s2);
        swap(0, 2, sb1);
        swap(1, 3, sb1);
        if(s1.equals(sb1.toString())) return true;
        
        return false;
    }
}