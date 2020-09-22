package com.tx.datastructur.linkedlist;

public class LinkedListAlgorithm {

    // 创建一个空的头指针（头结点）
    private static Node head = new Node();

    /**
     * 添加节点
     * @param value
     */
    public static void addData(Integer value) {

        // 初始化要加入的节点
        Node newNode = new Node(value);
        // 保存头指针
        Node temp = head;
        // 找到尾结点
        while (temp.getNext() != null) {
            temp = temp.getNext();
        }
        // 添加节点
        temp.setNext(newNode);
    }

    /**
     * main方法用来测试其他静态方法
     * @param args
     */
    public static void main(String[] args) {
        addData(5);
        addData(6);
        addData(3);
        addData(1);
        addData(10);
        addData(8);
        System.out.println("=====链表排序前=====");
        LinkedListTest.traverse(head);
        System.out.println("=====链表排序后=====");
        sortLinkedList(head);
        LinkedListTest.traverse(head);
        System.out.println("=====查找倒数第3个节点=====");
        Node kNode = findKNode(head, 3);
        System.out.println("倒数第k个节点"+kNode.getData());
        System.out.println("=====查找链表的中间节点=====");
        Node midNode = searchMidNode(head);
        System.out.println("中间节点" + midNode.getData());
        System.out.println("=====倒序输出单链表=====");
        printLinkedListReversely(head);
        System.out.println("=====翻转链表=====");
        Node reverseLinkedList = reverseLinkedList(head);
        LinkedListTest.traverse(reverseLinkedList);
    }

    /**
     * 对链表排序(冒泡排序)
     * @param head
     */
    public static void sortLinkedList(Node head) {
        Node currentNode;
        Node nextNode;

        for (currentNode = head.getNext(); currentNode.getNext() != null; currentNode= currentNode.getNext()) {
            for (nextNode = head.getNext(); nextNode.getNext() != null; nextNode = nextNode.getNext()) {
                // 把最大的放在最右边
                if (nextNode.getData() > nextNode.getNext().getData()) {
                    Integer temp = nextNode.getData();
                    nextNode.setData(nextNode.getNext().getData());
                    nextNode.getNext().setData(temp);

                }
            }
        }
    }

    /**
     * 找链表中的倒数第k个节点
     * 思路：设置两个指针p1,p2,让p2比p1快k-1个节点，然后一起向后走，当p2=null是，p1为倒数第k个节点
     * @param head
     * @param k
     * @return
     */
    public static Node findKNode(Node head, int k) {
        Node p1,p2;
        p1 = head;
        p2 = head;
        // p2先走k-1步
        for (int i = 0; i < k-1 ; i++) {
            p2 = p2.getNext();
        }
        // 指针一起向后移动
        while (p2.getNext() != null) {
            p2 = p2.getNext();
            p1 = p1.getNext();
        }
        return p1;
    }

    /**
     * 找链表的中间节点
     * 思路：两个指针，一个每次走一步，另一个每次走两步
     * @param head
     * @return
     * @bug: 当中间节点有两个的时候，返回的是前一个节点
     */
    public static Node searchMidNode(Node head) {
        Node p1,p2;
        p1 = head;
        p2 = head;
        while (p2 != null && p2.getNext() !=null && p2.getNext().getNext() != null) {
            p2 = p2.getNext().getNext();
            p1 = p1.getNext();
        }
        return p1;
    }

    /**
     * 通过递归从尾到头输出单链表
     * @param head
     */
    public static void printLinkedListReversely(Node head) {
        if (head != null) {
            printLinkedListReversely(head.getNext());
            if (head.getData() != null) {
                System.out.println(head.getData());
            }
        }
    }

    /**
     * 翻转链表
     * @param head
     * @return
     *
     * @bug 反转后，第一个（原链表最后一个）不见了
     */
    public static Node reverseLinkedList(Node head) {
        Node pre = null;
        Node cur = head;
        Node next;

        while (cur != null) {
            next = cur.getNext();
            cur.setNext(pre);
            pre = cur;
            cur = next;
        }
        return pre;
    }

}
