class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        Set<String> set = new HashSet<>();
        Set<String> ans = new HashSet<>();
        List<String> res = new ArrayList<>();

        for(String supply : supplies)
            set.add(supply);

        int len = recipes.length;

        while(len > 0)
        {
            for(int i = 0; i < recipes.length; i++)
            {
            boolean flag = false;
            List<String> list = ingredients.get(i);
            for(String str : list)
            {
                if(!set.contains(str))
                {
                    flag = true;
                    break;
                }
            }
            if(!flag)
            {
                set.add(recipes[i]);
                ans.add(recipes[i]);
                
            }

            }
        len--;
        }

        for(String str : ans)
            res.add(str);

        return res;
    }
}