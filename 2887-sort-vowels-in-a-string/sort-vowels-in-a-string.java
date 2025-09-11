class Solution {

    private boolean isVowel(char ch)
    {
        ch = Character.toLowerCase(ch);
        if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u')
            return true;
        return false;
    }

    public String sortVowels(String s) {
        List<Character> list = new ArrayList<>();
        char[] arr = s.toCharArray();
        int len = arr.length;

        for(char ch : arr)
        {
            if(isVowel(ch))
            {
                list.add(ch);
            }
        }

        Collections.sort(list);
        int j = 0;

        for(int i = 0; i < len; i++)
        {
            if(isVowel(arr[i]))
            {
                arr[i] = list.get(j);
                j++;
            }
        }

        return new String(arr);
    }
}