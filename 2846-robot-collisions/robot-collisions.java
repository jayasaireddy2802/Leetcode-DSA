class Solution {
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        int len = positions.length;
        int[][] robots = new int[len][2];

        for(int i = 0; i < len; i++)
        {
            robots[i][0] = positions[i];
            robots[i][1] = i;
        }

        Arrays.sort(robots, (a, b) -> a[0] - b[0]);

        Stack<Integer> st = new Stack<>();

        for(int i = 0; i < len; i++)
        {
            if(directions.charAt(robots[i][1]) == 'R')
                st.add(robots[i][1]);
            else
            {
                while(!st.isEmpty())
                {
                    if(healths[st.peek()] > healths[robots[i][1]])
                    {
                        healths[robots[i][1]] = 0;
                        healths[st.peek()]--;
                        break;
                    }
                    else if(healths[st.peek()] < healths[robots[i][1]])
                    {
                        healths[st.pop()] = 0;
                        healths[robots[i][1]]--;
                    }
                    else
                    {
                        healths[st.pop()] = 0;
                        healths[robots[i][1]] = 0;
                        break;
                    }
                }
            }
        }

        List<Integer> list = new ArrayList<>();

        for(int i = 0; i < len; i++)
        {
            if(healths[i] != 0)
                list.add(healths[i]);
        }

        return list;
    }
}