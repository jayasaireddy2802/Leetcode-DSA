class Solution {
    public int[] plusOne(int[] digits) {
        List<Integer> list = new ArrayList<>();
        int len = digits.length;
        int carry = 1;
        int i = len - 1;

        while(carry > 0 && i >= 0)
        {
            int sum = digits[i] + 1;
            list.add(sum % 10);
            carry = sum / 10;
            i--;
        }

        while(i >= 0)
        {
            list.add(digits[i]);
            i--;
        }

        while(carry > 0)
        {
            list.add(carry % 10);
            carry /= 10;
        }

        int size = list.size();
        int[] ans = new int[size];
        int j = 0;
        size--;

        while(size >= 0)
        {
            ans[j] = list.get(size);
            size--;
            j++;
        }

        return ans;
    }
}