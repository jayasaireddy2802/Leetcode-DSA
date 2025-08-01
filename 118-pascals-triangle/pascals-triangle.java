class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(new ArrayList<>(Arrays.asList(1)));
        if(numRows == 1)
            return ans;
        ans.add(new ArrayList<>(Arrays.asList(1, 1)));
        if(numRows == 2)
            return ans;

        for(int i = 0; i < numRows - 2; i++)
        {
            List<Integer> curr = new ArrayList<>();
            List<Integer> prev = ans.get(i + 1);

            int len = prev.size();

            curr.add(1);
            for(int j = 0; j < len - 1; j++)
            {
                curr.add(prev.get(j) + prev.get(j + 1));
            }
            curr.add(1);

            ans.add(curr);
        }

        return ans;
    }
}