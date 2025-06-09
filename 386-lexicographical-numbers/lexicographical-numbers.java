// class Solution {

//     public void solve(String str, int n, List<Integer> ans)
//     {
//         int num = Integer.parseInt(str);
//         if(num > n)
//             return ;

//         if(num <= n)
//             ans.add(num);

//         for(int i = 0; i <= 9; i++)
//         {
//             String s = str + Integer.toString(i);
//             solve(s, n, ans);
//         }
        
//     }

//     public List<Integer> lexicalOrder(int n) {
//         List<Integer> ans = new ArrayList<>();
        
//         for(int i = 1; i <= 9; i++)
//         {
//             String str = Integer.toString(i);
//             solve(str, n, ans);
//         }

//         return ans;
//     }
// }


class Solution {

    public void solve(int num, int n, List<Integer> ans)
    {        
        if(num > n)
            return ;

        if(num <= n)
            ans.add(num);

        for(int i = 0; i <= 9; i++)
        {
            int newNum = num*10 + i;
            solve(newNum, n, ans);
        }
        
    }

    public List<Integer> lexicalOrder(int n) {
        List<Integer> ans = new ArrayList<>();
        
        for(int i = 1; i <= 9; i++)
        {
            solve(i, n, ans);
        }

        return ans;
    }
}