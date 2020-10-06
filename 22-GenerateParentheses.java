import java.util.ArrayList;
import java.util.List;

class Solution22 {
    List<String> list = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        recursiveFunction(new char[2 * n], 0, 0, 0, n);
        return list;
    }

    // currIndex => the index of the array currently
    // opened => the number of open parenthesis
    // closed => the number of closed parenthesis
    // toBeOpened => the number of open parenthesis left need to create
    private void recursiveFunction(char[] arr, int currIndex, int opened, int closed, int toBeOpened) {
        // if all empty spaces in array are filled
        if (currIndex == arr.length) {
            list.add(new String(arr));
            return;
        }

        if (toBeOpened != 0) {
            arr[currIndex] = '(';
            recursiveFunction(arr, currIndex + 1, opened + 1, closed, toBeOpened - 1);
        }

        // opened and closed must equal
        if (opened > closed) {
            arr[currIndex] = ')';
            recursiveFunction(arr, currIndex + 1, opened, closed + 1, toBeOpened);
        }

    }

}