import java.util.*;

public class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> result = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();

        // Start with digits 1 to 9
        for (int i = 1; i <= 9; i++) {
            queue.offer(i);
        }

        while (!queue.isEmpty()) {
            int num = queue.poll();

            if (num >= low && num <= high) {
                result.add(num);
            }

            if (num > high) continue; 

            int lastDigit = num % 10;

            if (lastDigit < 9) {
                int nextNum = num * 10 + (lastDigit + 1);
                queue.offer(nextNum);
            }
        }

       
        return result;
    }
}