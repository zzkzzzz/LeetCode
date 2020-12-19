import java.util.HashMap;
import java.util.Collections;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

class Solution501 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public int[] findMode(TreeNode root) {
        if (root == null)
            return new int[0];

        HashMap<Integer, Integer> map = new HashMap<>();
        helper(map, root);

        int maxValueInMap = Collections.max(map.values());

        List<Integer> mode = new ArrayList<>();

        // Itrate through hashmap to find same frequency values
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == maxValueInMap) {
                mode.add(entry.getKey());
            }
        }

        // convert list to array
        int[] array = new int[mode.size()];
        for (int i = 0; i < mode.size(); i++)
            array[i] = mode.get(i);

        return array;

    }

    private void helper(HashMap<Integer, Integer> map, TreeNode root) {
        if (root == null)
            return;

        int count = map.getOrDefault(root.val, 0);
        map.put(root.val, count + 1);

        helper(map, root.left);
        helper(map, root.right);
    }

    int max = 0;
    int count = 0;
    int curr;

    public int[] findMode2(TreeNode root) {

        if (root == null)
            return new int[0];

        List<Integer> mode = new ArrayList<>();
        curr = root.val;
        inorder(root, mode);

        int[] array = new int[mode.size()];
        for (int i = 0; i < mode.size(); i++)
            array[i] = mode.get(i);

        return array;

    }

    private void inorder(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }

        inorder(root.left, list);
        count = curr == root.val ? count + 1 : 1;

        if (count == max) {
            list.add(root.val);
        } else if (count > max) {
            list.clear();
            list.add(root.val);
            max = count;
        }

        curr = root.val;

        inorder(root.right, list);
    }

}