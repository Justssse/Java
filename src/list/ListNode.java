package list;

/**
 * 存储int型的单向链表
 */
public class ListNode {

    ListNode next;
    int value;

    public ListNode(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return " " + value + " ";
    }

    @Override
    public boolean equals(Object obj) {
        return ((ListNode)obj).value == value;
    }

}
