class Solution {
    public void generate(boolean[] used, String tiles, int len, StringBuilder sb, Set<String> set)
    {
        if(sb.length() > 0)
        {
            set.add(sb.toString());
            
        }

        for(int i = 0; i < len; i++)
        {
            if(used[i] == true)
                continue;
            
            used[i] = true;
            sb.append(tiles.charAt(i));
            generate(used, tiles, len, sb, set);
            sb.deleteCharAt(sb.length() - 1);
            used[i] = false;
        }

    }
    public int numTilePossibilities(String tiles) {
        Set<String> set = new HashSet<>();
        int len = tiles.length();
        StringBuilder sb = new StringBuilder();
        boolean[] used = new boolean[len];

        generate(used, tiles, len, sb, set);
        return set.size();
    }
} 