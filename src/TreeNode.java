public class TreeNode<T> {

    //节点值
    T value;
    //左子树
    TreeNode<?> leftChild;
    //右子树
    TreeNode<?> rightChild;

    public TreeNode() { }

    public TreeNode(T value) {
        this.value = value;
    }

    /**
     * 增加左子节点
     */
    public void addLeft(T value){
        this.leftChild = new TreeNode<>(value);
    }

    /**
     * 增加右子节点
     */
    public void addRight(T value){
        this.rightChild = new TreeNode<>(value);
    }

    @Override
    public int hashCode() {
        return this.value.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof TreeNode){
            return this.value.equals(((TreeNode<?>)obj).value);
        }
        return false;
    }

    @Override
    public String toString() {
        return this.value == null ? "" : this.value.toString();
    }

}
