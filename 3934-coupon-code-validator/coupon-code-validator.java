class Solution {
    public boolean isValidCoupon(String str)
    {
        for(char ch : str.toCharArray())
        {
            if(ch == '_' || (ch >= '0' && ch <= '9') || (ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z'))
                continue;
            return false;
        }
        return true;
    }

    public List<String> validateCoupons(String[] code, String[] businessLine, boolean[] isActive) {
        List<List<String>> list = new ArrayList<>();
        int n = code.length;

        for(int i = 0; i < n; i++)
        {
            if(code[i].equals("") || (!isValidCoupon(code[i])))
                continue;

            String cat = businessLine[i];
            boolean valid = false;
            if(cat.equals("electronics") || cat.equals("grocery") || cat.equals("pharmacy") || cat.equals("restaurant"))
                valid = true;

            if(isActive[i] && valid)
                list.add(Arrays.asList(code[i], cat));
        }       
        Collections.sort(list, (a, b) -> {
            String cat1 = a.get(1);
            String cat2 = b.get(1);

            if(cat1.equals(cat2))
            {
                return a.get(0).compareTo(b.get(0));
            }
            else
                return cat1.charAt(0) - cat2.charAt(0);
        });
        
        List<String> ans = new ArrayList<>();
        for(List<String> l : list)
            ans.add(l.get(0));
        
        return ans;
    }
}