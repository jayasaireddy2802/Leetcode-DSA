class Solution {

    public boolean isValid(String word, String query)
    {
        int len = word.length();
        int ct = 0;

        for(int i = 0; i < len; i++)
        {
            if(word.charAt(i) != query.charAt(i))
            {
                ct++;
                if(ct > 2) return false;
            }
        }

        return true;
    }   

    public List<String> twoEditWords(String[] queries, String[] dictionary) {
        
        List<String> list = new ArrayList<>();

        for(String query : queries)
        {
            for(String word : dictionary)
            {
                if(isValid(word, query))
                {
                    list.add(query);
                    break;
                }
            }
        }
        return list;
    }
}