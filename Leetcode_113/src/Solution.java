import java.util.ArrayList;
import java.util.List;

public class Solution {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(5);
        TreeNode node1 = new TreeNode(4);
        TreeNode node2 = new TreeNode(8);
        TreeNode node3 = new TreeNode(11);
        TreeNode node4 = new TreeNode(13);
        TreeNode node5 = new TreeNode(4);
        TreeNode node6 = new TreeNode(7);
        TreeNode node7 = new TreeNode(2);
        TreeNode node8 = new TreeNode(5);
        TreeNode node9 = new TreeNode(1);

        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node3.left = node6;
        node3.right = node7;
        node2.left = node4;
        node2.right = node5;
        node5.left = node8;
        node5.right = node9;
        List<List<Integer>> resultList = new ArrayList<>();

        rootToLeafPaths(root, 22, resultList, new ArrayList<>(), 0);
        System.out.println(resultList);
    }

    private static void rootToLeafPaths(TreeNode root, int targetSum, List<List<Integer>> resultList,
                                 List<Integer> list, Integer sumTillNow) {

        if (root == null) {
            return;
        }
        list.add(root.val);
        sumTillNow += root.val;

        if (root.left == null && root.right == null && sumTillNow == targetSum) {
            resultList.add(new ArrayList<>(list));
            list.remove(list.size() - 1);
            sumTillNow -= root.val;
            return;
        }

        rootToLeafPaths(root.left, targetSum, resultList, list, sumTillNow);
        rootToLeafPaths(root.right, targetSum, resultList, list, sumTillNow);

        list.remove(list.size() - 1);
        sumTillNow -= root.val;
    }
}
