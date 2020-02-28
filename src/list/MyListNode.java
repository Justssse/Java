package list;

import java.util.HashMap;
import java.util.Map;

public class MyListNode {

    //头结点
    ListNode head;

    public MyListNode(ListNode head) {
        this.head = head;
    }

    /**
     * 添加节点
     */
    public MyListNode add(int value){
        if (head != null){
            ListNode current = head;
            while (current.next != null){
                current = current.next;
            }
            current.next = new ListNode(value);
        }else {
            head = new ListNode(value);
        }
        return this;
    }

    /**
     * 删除某一节点(多个节点相同时删除第一个)
     */
    public MyListNode delete(int value){
        ListNode preNode = null;
        ListNode current = head;
        while (current != null){
            //当前节点不是待删除节点
            if (current.value != value){
                preNode = current;
                current = current.next;
            }else {
                //当前节点为待删除节点
                if (preNode == null){
                    //前节点为空，说明删除的是头结点
                    head = head.next;
                }else {
                    preNode.next = current.next;
                }
                break;
            }
        }
        return this;
    }

    /**
     * 求链表长度
     */
    public int length(){
        int length = 0;
        ListNode current = head;
        while (current != null){
            length ++;
            current = current.next;
        }
        return length;
    }

    /**
     * 使用选择排序对链表排序
     */
    public MyListNode sort(){
        ListNode current = head;
        while (current.next != null){
            ListNode min = current;
            ListNode nextNode = current.next;
            while (nextNode != null){
                if (nextNode.value < min.value){
                    min = nextNode;
                }
                nextNode = nextNode.next;
            }
            if (!current.equals(min)){
                //此处只需要交换两个节点的值即可，不需要把指向都交换了
                int temp = current.value;
                current.value = min.value;
                min.value = temp;
            }
            current = current.next;
        }
        return this;
    }

    /**
     * 链表去重
     */
    public MyListNode distinct(){
        if (head == null){
            return null;
        }
        ListNode current = head;
        Map<Integer,Integer> hashMap = new HashMap<>();
        hashMap.put(current.value,current.value);
        while (current.next != null){
            if (hashMap.containsKey(current.next.value)){
//                delete(current.value); //可以直接使用之前的删除函数，但效率不高

                //直接跳过该点即可
                current.next = current.next.next;
            }else {
                hashMap.put(current.next.value,current.next.value);
                current = current.next;
            }
        }
        return this;
    }

    /**
     * 返回倒数第N个节点（两个指针，第一个指针向前移动k-1次，之后两个指针共同前进，当前面的指针到达末尾时，后面的指针所在的位置就是倒数第k个位置）
     */
    public ListNode getLast(int n){
        ListNode current = head;
        int index = 0;
        ListNode node = null;
        while (current != null){
            current = current.next;
            index ++;
            if (index == n ){
                node = head;
            }else if (index > n){
                node = node.next;
            }
        }
        return node;
    }

    /**
     * 反转链表
     */
    public MyListNode reverse(){
        ListNode pre = null;
        while (head != null){
            ListNode temp = head.next;
            head.next = pre;
            pre = head;
            head = temp;
        }
        head = pre;
        return this;
    }

    /**
     * 找到链表中间点（两个指针，一个每次移动一步，一个每次移动两步）
     */
    public ListNode findMid(){
        if (head == null){
            return null;
        }
        ListNode oneStep = head;
        ListNode twoStep = head;
        int index = 0;
        while (twoStep.next != null){
            twoStep = twoStep.next;
            index ++;
            if (index % 2 == 0){
                oneStep = oneStep.next;
            }
        }
        return oneStep;
    }

    /**
     * 判断链表是否有环(设置快指针和慢指针，慢指针每次走一步，快指针每次走两步，当快指针与慢指针相等时，就说明该链表有环)
     */
    public boolean isCircle(){
        if (head == null){
            return false;
        }
        ListNode oneStep = head;
        ListNode twoStep = head;
        while (twoStep.next != null && twoStep.next.next != null){
            oneStep = oneStep.next;
            twoStep = twoStep.next.next;
            if (oneStep == twoStep){
                return true;
            }
        }
        return false;
    }

    /**
     * 在不知道head时，删除给定的节点，将其该结点的值与下一结点交换，然后该结点的指针指向下一结点的后续结点
     * 尾节点无法删除
     */
    public MyListNode delete(ListNode node){
        if (node.next != null){
            ListNode temp = node.next;
            int value = node.next.value;
            node.next.value = node.value;
            node.value = value;
            node.next = node.next.next;
        }
        return this;
    }

    /**
     * 判断两个链表是否相交，两个链表相交，则它们的尾结点一定相同，比较两个链表的尾结点是否相同即可
     */
    public boolean cross(ListNode head1, ListNode head2){
        if (head1 == null || head2 == null){
            return false;
        }
        ListNode node1 = head1;
        ListNode node2 = head2;
        while (node1.next != null){
            node1 = node1.next;
        }
        while (node2.next != null){
            node2 = node2.next;
        }
        if (node1 == node2){
            return true;
        }
        return false;
    }

    /**
     * 找到两个链表相交的起始点
     * 1、首先判断链表是否相交，如果两个链表不相交，则求相交起点没有意义
     * 2、求出两个链表长度之差：len=length1-length2
     * 3、让较长的链表先走len步
     * 4、然后两个链表同步向前移动，没移动一次就比较它们的结点是否相等，第一个相等的结点即为它们的第一个相交点
     */


    /**
     * 顺序输出链表
     */
    public void print(){
        if (head == null){
            System.out.println("链表为空");
        }else {
            ListNode current = head;
            System.out.print("链表：");
            while (current != null){
                System.out.print(current);
                current = current.next;
            }
        }
    }

}
