package list;

public class TestList {

    public static void main(String[] args) {
        MyListNode myListNode = new MyListNode(new ListNode(1));
        myListNode.add(5).add(4).add(5).add(4).add(5).add(4).add(2).add(3);
        myListNode.print();
        System.out.println(myListNode.findMid());
        myListNode.reverse().print();
        System.out.println("长度为： " + myListNode.length());
    }

}
