// class Solution {
//     public int compareVersion(String version1, String version2) {
//         int len1 = version1.length();
//         int len2 = version2.length();
//         int i = 0, j = 0;
    
//         while(i < len1 || j < len2)
//         {
//             int num1 = 0;
//             while(i < len1 && version1.charAt(i) != '.')
//             {
//                 num1 = num1*10 + (version1.charAt(i) - '0');
//                 i++;
//             }

//             int num2 = 0;
//             while(j < len2 && version2.charAt(j) != '.')
//             {
//                 num2 = num2*10 + (version2.charAt(j) - '0');
//                 j++;
//             }

//             if(num1 > num2)
//                 return 1;

//             if(num1 < num2)
//                 return -1;

//             i++;
//             j++;            
//         }

        

//         return 0;
//     }
// }



// import java.util.StringTokenizer;
// class Solution {
//     public int compareVersion(String version1, String version2) {
//         StringTokenizer st1 = new StringTokenizer(version1, ".");
//         StringTokenizer st2 = new StringTokenizer(version2, ".");    

//         while(st1.hasMoreTokens() || st2.hasMoreTokens())
//         {
//             int num1 = 0;
//             if(st1.hasMoreTokens())
//                 num1 = Integer.parseInt(st1.nextToken());
            
//             int num2 = 0;
//             if(st2.hasMoreTokens())
//                 num2 = Integer.parseInt(st2.nextToken());
            
//             if(num1 > num2)
//                 return 1;
//             if(num2 > num1)
//                 return -1;
//         }   

//         return 0;
//     }
// }



class Solution {
    public int compareVersion(String version1, String version2) {
        String[] st1 = version1.split("\\.");
        String[] st2 = version2.split("\\.");   
        int len1 = st1.length;
        int len2 = st2.length; 
        int i = 0;
        int j = 0;

        while(i < len1 || j < len2)
        {
            int num1 = 0;
            if(i < len1)
            {
                num1 = Integer.parseInt(st1[i++]);
            }
            
            int num2 = 0;
            if(j < len2)
                num2 = Integer.parseInt(st2[j++]);
            
            if(num1 > num2)
                return 1;
            if(num2 > num1)
                return -1;
        }   

        return 0;
    }
}



