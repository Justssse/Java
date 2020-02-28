package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreeNodeUtil {

    /**
     * 返回树中节点的个数
     */
    public static int getTreeNum(TreeNode<?> root){
        if (root == null){
            return 0;
        }
        return getTreeNum(root.leftChild) + getTreeNum(root.rightChild) + 1;
    }

    /**
     * 返回树的深度
     */
    public static int getTreeHeight(TreeNode<?> root){
        if (root == null){
            return 0;
        }
        int leftHeight = getTreeHeight(root.leftChild) + 1;
        int rightHeight = getTreeHeight(root.rightChild) + 1;
        return Math.max(leftHeight,rightHeight);
    }

    /**
     * 前序遍历
     */
    public static void preVisitTree(TreeNode<?> root){
        if (root == null){
            return;
        }
        print(root);
        preVisitTree(root.leftChild);
        preVisitTree(root.rightChild);
    }

    /**
     *中序遍历
     */
    public static void midVisitTree(TreeNode<?> root){
        if (root == null){
            return;
        }
        midVisitTree(root.leftChild);
        print(root);
        midVisitTree(root.rightChild);
    }

    /**
     *后序遍历
     */
    public static void backVisitTree(TreeNode<?> root){
        if (root == null){
            return;
        }
        backVisitTree(root.leftChild);
        backVisitTree(root.rightChild);
        print(root);
    }

    /**
     *层次遍历
     */
    public static void levelVisitTree(TreeNode<?> root){
        if (root == null){
            return;
        }
        Queue<TreeNode<?>> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            TreeNode<?> treeNode = queue.poll();
            print(treeNode);
            if (treeNode.leftChild != null){
                queue.offer(treeNode.leftChild);
            }
            if (treeNode.rightChild != null){
                queue.offer(treeNode.rightChild);
            }
        }
    }

    /**
     *返回第K层节点个数
     */
    public static int getLevelNum(TreeNode<?> root, int level){
        if (root == null || level < 1 ){
            return 0;
        }else if (level == 1){
            return 1;
        }else {
            int leftNum = getLevelNum(root.leftChild, level - 1);
            int rightNum = getLevelNum(root.rightChild,level - 1);
            return leftNum + rightNum;
        }
    }

    /**
     *返回叶子节点个数
     */
    public static int getLeafNum(TreeNode<?> root){
        if (root == null){
            return 0;
        }else if (root.leftChild == null && root.rightChild == null){
            return 1;
        }else {
            int leftLeaf = getLeafNum(root.leftChild);
            int rightLeaf = getLeafNum(root.rightChild);
            return leftLeaf + rightLeaf;
        }
    }

    /**
     *交换节点的左右子树
     */
    public static TreeNode<?> exchange(TreeNode<?> root){
        if (root == null){
            return null;
        }
        TreeNode<?> left = exchange(root.leftChild);
        TreeNode<?> right = exchange(root.rightChild);
        root.leftChild = right;
        root.rightChild = left;
        return root;
    }

    /**
     *查看Node是否是root子节点
     */
    public static boolean findNode(TreeNode<?> node, TreeNode<?> root){
        if (root == null || node == null){
            return false;
        }else if (node == root){
            return true;
        }else if (findNode(node,root.leftChild)){
            return true;
        }else {
            return findNode(node,root.rightChild);
        }
    }

    /**
     *返回两个节点node1、node2以root为根节点的公共父节点
     */
    public static TreeNode<?> getFather(TreeNode<?> root, TreeNode<?> node1, TreeNode<?> node2){
        if (root == null || node1 == null || node2 == null){
            return null;
        }else if (node1 == root && node2 == root){
            return root;
        }else {
            //如果node1是左子树上的节点
            if (findNode(node1,root.leftChild)){
                //node2是右子树上节点，那么root就是公共父节点
                if (findNode(node2,root.rightChild)){
                    return root;
                }else {
                    //否则继续在左子树上查找
                    return getFather(root.leftChild,node1,node2);
                }
            }else {
                //node1是右子树上节点
                if (findNode(node2,root.leftChild)){
                    //node2是左子树上节点，那么root就是公共父节点
                    return root;
                }else {
                    //否则继续在右子树上查找
                    return getFather(root.rightChild,node1,node2);
                }
            }
        }
    }

    /**
     *比较两个树是否完全一致
     */
    public static boolean equals(TreeNode<?> root1, TreeNode<?> root2){
        if (root1 == null && root2 == null){
            return true;
        }
        if (root1 == null || root2 == null){
            return false;
        }
        return root1.value.equals(root2.value)
                && equals(root1.leftChild,root2.leftChild)
                && equals(root1.rightChild,root2.rightChild);
    }

    /**
     * 根据先序遍历和中序遍历结果还原树
     */
    public static TreeNode<?> getTreeNodeFromPreAndMid(List<?> pre, List<?> mid){
        if (pre == null || mid == null || pre.size() == 0 || mid.size() == 0){
            return null;
        }
        if (pre.size() == 1){
            return new TreeNode<>(pre.get(0));
        }
        //首先找到根节点
        TreeNode<?> root = new TreeNode<>(pre.get(0));
        //找到根节点在中序的下标
        int index = 0;
        while (!pre.get(0).equals(mid.get(index))){
            index++;
        }
        //构建左子树的前序
        List<?> preLeft = new ArrayList<>(index);
        //构建左子树的中序
        List<?> midLeft = new ArrayList<>(index);
        for (int i = 1; i < index; i++) {
//            preLeft.add(pre.get(i));
        }
        for (int i = 0; i < index - 1; i++) {
//            midLeft.add(mid.get(i));
        }
        //重建左子树
        root.leftChild = getTreeNodeFromPreAndMid(preLeft,midLeft);

        //构建右子树的前序
        List<?> preRight = new ArrayList<>(pre.size() - index - 1);
        //构建右子树的中序
        List<?> midRight = new ArrayList<>(pre.size() - index - 1);
        for (int i = index; i < pre.size() - 1; i++) {
//            preRight.add(pre.get(i));
        }
        for (int i = 0; i < pre.size() - 1; i++) {
//            midRight.add(mid.get(i));
        }
        //重建右子树
        root.rightChild = getTreeNodeFromPreAndMid(preRight,midRight);
        return root;
    }

    public static void print(TreeNode<?> root){
        System.out.print(" " + root.value + " ");
    }

}
