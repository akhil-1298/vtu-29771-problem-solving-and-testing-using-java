import java.util.*;

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {

        int n = temperatures.length;
        int[] answer = new int[n];

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {

            // Find warmer day for previous temperatures
            while (!stack.isEmpty() &&
                   temperatures[i] > temperatures[stack.peek()]) {

                int previousDay = stack.pop();

                answer[previousDay] = i - previousDay;
            }

            // Store current day's index
            stack.push(i);
        }

        return answer;
    }
}