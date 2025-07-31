// class Solution {
//     public int subarrayBitwiseORs(int[] arr) {
//         int len = arr.length;
//         Set<Integer> set = new HashSet<>();

//         for(int i = 0; i < len; i++)
//         {
//             for(int j = i; j < len; j++)
//             {
//                 int val = 0;
//                 for(int k = i; k <= j; k++)
//                 {
//                     val = val | arr[k];
//                 }
//                 set.add(val);
//             }
//         }

//         return set.size();
//     }
// }

// class Solution {
//     public int subarrayBitwiseORs(int[] arr) {
//         Set<Integer> set = new HashSet<>();
//         Set<Integer> ans = new HashSet<>();

//         for(int num : arr)
//         {
//             Set<Integer> curr = new HashSet<>();
//             curr.add(num);
//             for(int x : set)
//                 curr.add(x | num);

//             ans.addAll(curr);
//             set = curr;           
//         }
        
//         return ans.size();
//     }
// }

// class Solution {
//     public int subarrayBitwiseORs(int[] arr) {
//         Set<Integer> set = new HashSet<>();
        
//         for(int i = 0; i < arr.length; i++)
//         {
//             set.add(arr[i]);
//             int val = arr[i];

//             for(int j = i + 1; j < arr.length; j++)
//             {
//                 if(val == (val | arr[j])) break;
//                 val = val | arr[j];
//                 set.add(val);
//             }
//         }
        
//         return set.size();
//     }
// }

class Solution {
    public int subarrayBitwiseORs(int[] arr) {
        Set<Integer> result=new HashSet<>();
        for(int i=0;i<arr.length;i++){
            result.add(arr[i]);
            for(int j=i-1;j>=0;j--){
                if(arr[j]==(arr[j] | arr[i])) break;
                arr[j]|=arr[i];
                result.add(arr[j]);
            }
        }
        return result.size();
    }
}