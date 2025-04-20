// class Solution {
//     public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
//         Set<String> set = new HashSet<>();
//         Set<String> ans = new HashSet<>();
//         List<String> res = new ArrayList<>();

//         for(String supply : supplies)
//             set.add(supply);

//         int len = recipes.length;

//         while(len > 0)
//         {
//             for(int i = 0; i < recipes.length; i++)
//             {
//             boolean flag = false;
//             List<String> list = ingredients.get(i);
//             for(String str : list)
//             {
//                 if(!set.contains(str))
//                 {
//                     flag = true;
//                     break;
//                 }
//             }
//             if(!flag)
//             {
//                 set.add(recipes[i]);
//                 ans.add(recipes[i]);
                
//             }

//             }
//         len--;
//         }

//         for(String str : ans)
//             res.add(str);

//         return res;
//     }
// }

class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        List<List<Integer>> adj = new ArrayList<>();
        Map<String, List<Integer>> map = new HashMap<>();
        Set<String> set = new HashSet<>();
        int[] indegree = new int[recipes.length];
        for(String str : supplies)
            set.add(str);
        for(int i = 0; i < recipes.length; i++)
        {
            for(String ingredient : ingredients.get(i))
            {
                if(!set.contains(ingredient))
                {
                    List<Integer> list = map.getOrDefault(ingredient, new ArrayList<>());
                    list.add(i);
                    map.put(ingredient, list);   
                    indegree[i]++;
                }
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < indegree.length; i++)
        {
            if(indegree[i] == 0)
                queue.add(i);
        }

        while(!queue.isEmpty())
        {
            int x = queue.poll();
            set.add(recipes[x]);
            if(map.containsKey(recipes[x]))
            {
                for(int val : map.get(recipes[x]))
                {
                    indegree[val]--;
                    if(indegree[val] == 0)
                        queue.add(val);
                }
            }
        }

        List<String> ans = new ArrayList<>();
        for(int i = 0; i < recipes.length; i++)
        {
            boolean make = true;
            for(int j = 0; j < ingredients.get(i).size(); j++)
            {
                if(!set.contains(ingredients.get(i).get(j))){
                    make = false;
                    break;
                }
            }
            if(make)
                ans.add(recipes[i]);
        }

        return ans;
    }
}