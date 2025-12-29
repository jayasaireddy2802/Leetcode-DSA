// class Solution {

//     public void getNextRows(String curr, Map<String, List<Character>> map, int idx, StringBuilder sb, List<String> list)
//     {
//         if(idx == curr.length() - 1)
//         {
//             list.add(sb.toString());
//             return ;
//         }

//         String key = curr.substring(idx, idx + 2);

//         if(!map.containsKey(key))
//             return ;
        
//         for(char ch : map.get(key))
//         {
//             sb.append(ch);
//             getNextRows(curr, map, idx + 1, sb, list);
//             sb.deleteCharAt(sb.length() - 1);
//         }

//     }

//     public boolean solve(String curr, Map<String, List<Character>> map)
//     {
//         int len = curr.length();
//         if(len == 1)
//             return true;

//         List<String> nextrows = new ArrayList<>();
//         getNextRows(curr, map, 0, new StringBuilder(), nextrows);

//         for(String row : nextrows)
//         {
//             if(solve(row, map)) return true;
//         }

//         return false;
//     }

//     public boolean pyramidTransition(String bottom, List<String> allowed) {
        
//         Map<String, List<Character>> map = new HashMap<>();

//         for(String str : allowed)
//         {
//             String substr = str.substring(0,2);
//             List<Character> list = map.getOrDefault(substr, null);
//             if(list == null)
//                 list = new ArrayList<>();
//             list.add(str.charAt(2));
//             map.put(substr, list);
//         }

//         return solve(bottom, map);
//     }
// }



class Solution {
    Set<String> notPossible = new HashSet<>();

    public void getNextRows(String curr, Map<String, List<Character>> map, int idx, StringBuilder sb, List<String> list)
    {
        if(idx == curr.length() - 1)
        {
            list.add(sb.toString());
            return ;
        }

        String key = curr.substring(idx, idx + 2);

        if(!map.containsKey(key))
            return ;
        
        for(char ch : map.get(key))
        {
            sb.append(ch);
            getNextRows(curr, map, idx + 1, sb, list);
            sb.deleteCharAt(sb.length() - 1);
        }

    }

    public boolean solve(String curr, Map<String, List<Character>> map)
    {
        int len = curr.length();
        if(len == 1)
            return true;

        if(notPossible.contains(curr))
            return false;

        List<String> nextrows = new ArrayList<>();
        getNextRows(curr, map, 0, new StringBuilder(), nextrows);

        for(String row : nextrows)
        {
            if(solve(row, map)) return true;
        }

        notPossible.add(curr);

        return false;
    }

    public boolean pyramidTransition(String bottom, List<String> allowed) {
        
        Map<String, List<Character>> map = new HashMap<>();

        for(String str : allowed)
        {
            String substr = str.substring(0,2);
            List<Character> list = map.getOrDefault(substr, null);
            if(list == null)
                list = new ArrayList<>();
            list.add(str.charAt(2));
            map.put(substr, list);
        }

        return solve(bottom, map);
    }
}