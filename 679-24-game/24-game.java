// class Solution {
//     char[] op = {'+', '-', '*', '/'};

//     public boolean solve(int idx, int a, int b, int num1, int num2, int[] cards, double val1, double val2)
//     {
//         if(idx >= 2)
//             {
//                 if(val1 + val2 == 24)
//                     return true;
//                 else if(val1 - val2 == 24)
//                     return true;
//                 else if(val1 * val2 == 24)
//                     return true;
//                 else if(val1 / val2 == 24)
//                     return true;

//                 return false;
//             }
//         if(idx == 0)
//         {
//             for(int i = 0; i < 4; i++)
//             {
//                 char ch = op[i];
//                 if(ch == '+')
//                 {
//                     val1 = val1 + (a + b);
//                 }
//                 else if(ch == '-')
//                 {
//                     val1 = val1 + (a - b);
//                 }
//                 else if(ch == '*')
//                 {
//                     val1 = val1 + (a * b);
//                 }
//                 else
//                 {
//                     val1 = val1 + ((double)a / (double)b);
//                 }
//             }
//         }

//         if(idx == 1)
//         {
//             for(int i = 0; i < 4; i++)
//             {
//                 char ch = op[i];
//                 if(ch == '+')
//                 {
//                     val2 = val2 + (num1 + num2);
//                 }
//                 else if(ch == '-')
//                 {
//                     val2 = val2 + (num1 - num2);
//                 }
//                 else if(ch == '*')
//                 {
//                     val2 = val2 + (num1 * num2);
//                 }
//                 else
//                 {
//                     val2 = val2 +((double)num1 / (double)num2);
//                 }

//             }
//         }
//         if(solve(idx+ 1, a, b, num1, num2, cards, val1, val2))
//             return true;
//         return false;
//     }
//     public boolean judgePoint24(int[] cards) {
        
//         for(int i = 0; i < 4; i++)
//         {
//             for(int j = i + 1; j < 4; j++)
//             {
//                 int a = 0, b = 0;
//                 for(int k = 0; k < 4; k++)
//                 {
//                     if(cards[k] != cards[i] || cards[k] != cards[j])
//                     {
//                         if(a == 0)
//                             a = cards[k];
//                         else
//                             b = cards[k];
//                     }
//                 }

//                 if(solve(0, a, b, cards[i], cards[j], cards, 0, 0))
//                     return true;
//             }
//         }

//         return false;
//     }
// }



class Solution {
    private static final double EPSILON = 1e-6;
    private static final double TARGET = 24.0;

    public boolean judgePoint24(int[] cards) {
        List<Double> nums = new ArrayList<>();
        for (int card : cards) nums.add((double) card);
        return solve(nums);
    }

    private boolean solve(List<Double> nums) {
        if (nums.size() == 1) {
            return Math.abs(nums.get(0) - TARGET) < EPSILON;
        }

        // Try all pairs
        for (int i = 0; i < nums.size(); i++) {
            for (int j = 0; j < nums.size(); j++) {
                if (i == j) continue;

                List<Double> next = new ArrayList<>();
                for (int k = 0; k < nums.size(); k++) {
                    if (k != i && k != j) next.add(nums.get(k));
                }

                for (double val : compute(nums.get(i), nums.get(j))) {
                    next.add(val);
                    if (solve(next)) return true;
                    next.remove(next.size() - 1);
                }
            }
        }
        return false;
    }

    private List<Double> compute(double a, double b) {
        List<Double> results = new ArrayList<>();
        results.add(a + b);
        results.add(a - b);
        results.add(b - a);
        results.add(a * b);
        if (Math.abs(b) > EPSILON) results.add(a / b);
        if (Math.abs(a) > EPSILON) results.add(b / a);
        return results;
    }
}
