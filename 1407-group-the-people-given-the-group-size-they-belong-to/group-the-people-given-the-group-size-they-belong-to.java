class Solution {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        Map<Integer,List<List<Integer>>> map = new HashMap<>();
        List<List<Integer>> ans = new ArrayList<>();

        for(int i = 0; i < groupSizes.length; i++)
        {
            List<List<Integer>> groups = map.get(groupSizes[i]);
            if(groups == null)
            {
                List<Integer> list = new ArrayList<>(Arrays.asList(i));
                List<List<Integer>> newGroup = new ArrayList<>();
                newGroup.add(list);
                map.put(groupSizes[i], newGroup);

            } 
            else
            {
                int len = groups.size();
                List<Integer> list = groups.get(len - 1);
                if(list.size() == groupSizes[i])
                {
                    groups.add(new ArrayList<>(Arrays.asList(i)));
                }
                else
                {
                    list.add(i);
                }
                map.put(groupSizes[i], groups);
            }
        }

        for(int key : map.keySet())
        {
            for(List<Integer> l : map.get(key))
            {
                ans.add(l);
            }
        }

        return ans;
    }
}