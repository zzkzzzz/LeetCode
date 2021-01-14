import java.util.Stack;

class Solution316 {
    String removeDuplicateLetters(String s) {
        Stack<Character> stk = new Stack<>();

        // to count the occurrences of the character
        int[] count = new int[256];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i)]++;
        }

        // to prevent duplicates elements
        boolean[] inStack = new boolean[256];

        for (char c : s.toCharArray()) {

            count[c]--;

            if (inStack[c])
                continue;

            while (!stk.isEmpty() && stk.peek() > c) {
                // if the top element not exist after, then no need pop
                if (count[stk.peek()] == 0) {
                    break;
                }
                // if the top element still exist after, then pop it
                inStack[stk.pop()] = false;
            }

            // push current element into stack
            stk.push(c);
            // mark current element
            inStack[c] = true;
        }

        StringBuilder sb = new StringBuilder();
        while (!stk.empty()) {
            sb.append(stk.pop());
        }
        return sb.reverse().toString();
    }
}