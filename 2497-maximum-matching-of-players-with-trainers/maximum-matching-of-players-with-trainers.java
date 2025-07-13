class Solution {
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        int len1 = players.length;
        int len2 = trainers.length;
        int i = 0, j = 0, ct = 0;

        Arrays.sort(players);
        Arrays.sort(trainers);
        
        while(i < len1)
        {
            while(j < len2)
            {
                if(players[i] <= trainers[j])
                {
                    ct++;
                    j++;
                    break;
                }
                j++;
            }

            i++;
        }

        return ct;
    }
}