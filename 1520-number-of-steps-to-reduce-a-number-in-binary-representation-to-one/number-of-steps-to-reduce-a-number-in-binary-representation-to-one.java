// class Solution {
//     public int numSteps(String s) {
//         int num = Integer.parseInt(s, 2);
//         int steps = 0;
//         while(num > 1)
//         {
//             if(num % 2 == 0)
//                 num = num / 2;
//             else
//                 num++;
//             steps++;
//         }
//         return steps;
//     }
// }

class Solution {
    public int numSteps(String s) {
        
        int steps = 0;
        StringBuilder sb = new StringBuilder(s);

        while(true)
        {
            int len = sb.length();
            if(len == 1)
                break;
            else if(sb.charAt(len - 1) == '0')
            {
                sb.deleteCharAt(len - 1);
            }
            else
            {
                int j = len - 1;
                while(j >= 0)
                {
                    if(sb.charAt(j) == '0')
                    {
                        sb.setCharAt(j, '1');
                        break;
                    }
                    sb.setCharAt(j, '0');
                    j--;
                }
                if(j < 0)
                    sb.insert(0, '1');
            }

            steps++;
        }

        return steps;
    }
}