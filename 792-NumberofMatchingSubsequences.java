import java.util.Map;
import java.util.HashMap;
import java.util.LinkedList;

class Solution792 {
    public int numMatchingSubseq(String S, String[] words) {
        // create a waiting list from 'a' to 'z'
        Map<Character, LinkedList<String>> waitinglist = new HashMap<>();

        for (char i = 'a'; i <= 'z'; i++) {
            waitinglist.put(i, new LinkedList<>());
        }

        // get the first char of the words, put them in the waiting list
        for (String word : words) {
            waitinglist.get(word.charAt(0)).addLast(word);
        }

        int count = 0;
        for (char c : S.toCharArray()) {
            LinkedList<String> queue = waitinglist.get(c);
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String word = queue.removeFirst();
                if (word.length() == 1) {
                    count++;
                } else {
                    // update the waiting list
                    waitinglist.get(word.charAt(1)).addLast(word.substring(1));
                }
            }
        }

        return count;
    }
}