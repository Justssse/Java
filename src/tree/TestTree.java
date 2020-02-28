package tree;

public class TestTree {

    public static void main(String[] args) {

        //二叉树测试
        TreeNode<Integer> root = new TreeNode<>(1);
        root.addLeft(2);
        root.addRight(3);
        ((TreeNode<Integer>)root.leftChild).addLeft(4);
        ((TreeNode<Integer>)root.leftChild).addRight(5);
        System.out.println("\n先序：");
        TreeNodeUtil.preVisitTree(root);
        System.out.println("\n中序：");
        TreeNodeUtil.midVisitTree(root);
        System.out.println("\n后序：");
        TreeNodeUtil.backVisitTree(root);
        System.out.println("\n深度： " + TreeNodeUtil.getTreeHeight(root));
        System.out.println("叶子节点个数：" + TreeNodeUtil.getLeafNum(root));
        System.out.println("节点个数：" + TreeNodeUtil.getTreeNum(root));
        System.out.println("第二层节点个数：" + TreeNodeUtil.getLevelNum(root,2));
        System.out.println("2是否为节点：" + TreeNodeUtil.findNode(new TreeNode<>(2),root));
        System.out.println("公共父节点：" + TreeNodeUtil.getFather(root,root.leftChild.leftChild,root.leftChild.rightChild));
        TreeNode<Integer> root2 = new TreeNode<>(1);
        root2.addLeft(2);
        root2.addRight(3);
        ((TreeNode<Integer>)root2.leftChild).addLeft(4);
        ((TreeNode<Integer>)root2.leftChild).addRight(5);
        System.out.println("两个树是否完全相等：" + TreeNodeUtil.equals(root,root2));
        System.out.println("交换左右子树后：" + TreeNodeUtil.exchange(root));
        System.out.println("\n先序：");
        TreeNodeUtil.preVisitTree(root);
        System.out.println("\n中序：");
        TreeNodeUtil.midVisitTree(root);
        System.out.println("\n后序：");
        TreeNodeUtil.backVisitTree(root);

    }

}
