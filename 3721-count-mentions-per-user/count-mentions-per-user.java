class Solution {
    public int[] countMentions(int numberOfUsers, List<List<String>> events) {

        Map<Integer, Integer> map = new HashMap<>();
        int[] ans = new int[numberOfUsers];

        Collections.sort(events, (a, b) -> {

            int t1 = Integer.parseInt(a.get(1));
            int t2 = Integer.parseInt(b.get(1));

            if (t1 == t2) {
                char c1 = a.get(0).charAt(1);
                char c2 = b.get(0).charAt(1);

                if (c1 > c2) return -1;
                if (c1 < c2) return 1;
                return 0;
            }

            return Integer.compare(t1, t2);
        });



        for (List<String> event : events) {
            String msg = event.get(0);
            if (msg.equals("OFFLINE")) {
                int time = Integer.parseInt(event.get(1));
                int id = Integer.parseInt(event.get(2));

                map.put(id, time);
            } else {
                String mention = event.get(2);
                if (mention.equals("ALL")) {
                    for (int i = 0; i < numberOfUsers; i++)
                        ans[i]++;
                } else if (mention.equals("HERE")) {
                    int currTime = Integer.parseInt(event.get(1));

                    for (int i = 0; i < numberOfUsers; i++) {
                        if (!map.containsKey(i))
                            ans[i]++;
                        else {
                            int last = map.get(i);
                            if (currTime - last >= 60) {
                                map.remove(i);
                                ans[i]++;
                            }
                        }
                    }
                } else {
                    String[] parts = event.get(2).split("\\s+");
                    for (String str : parts) {
                        int id = Integer.parseInt(str.substring(2));
                        int currTime = Integer.parseInt(event.get(1));

                        // if (map.containsKey(id)) {
                        //     int time = map.get(id);
                        //     if (currTime - time >= 60) {
                        //         map.remove(id);
                        //         ans[id]++;
                        //     }
                        // } else
                            ans[id]++;
                    }
                }
            }
        }
        return ans;
    }
}