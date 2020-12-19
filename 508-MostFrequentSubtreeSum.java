import java.util.HashMap;
import java.util.Collections;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

class Solution508 {
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

    int maxCount = 0;

    public int[] findFrequentTreeSum(TreeNode root) {
        if (root == null)
            return new int[0];

        HashMap<Integer, Integer> map = new HashMap<>();
        postorder(map, root);

        // int maxValueInMap = Collections.max(map.values());

        List<Integer> mode = new ArrayList<>();

        // Itrate through hashmap to find same frequency values
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == maxCount) {
                mode.add(entry.getKey());
            }
        }

        // convert list to array
        int[] array = new int[mode.size()];
        for (int i = 0; i < mode.size(); i++)
            array[i] = mode.get(i);

        return array;

    }

    private int postorder(HashMap<Integer, Integer> map, TreeNode root) {
        if (root == null)
            return 0;

        int left = postorder(map, root.left);
        int right = postorder(map, root.right);

        int sum = left + right + root.val;

        int count = map.getOrDefault(sum, 0);
        map.put(sum, count + 1);

        maxCount = Math.max(maxCount, count + 1);

        return sum;

    }
}