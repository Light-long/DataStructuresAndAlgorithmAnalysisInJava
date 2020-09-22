package com.tx.datastructur.linkedlist;

public class LinkedListTest {

    // 创建一个空的头指针（头结点）
    private static Node head = new Node();


    // main方法调用其他静态方法
    public static void main(String[] args) {

        //test addData
        System.out.println("======添加数据========");
        addData(5);
        addData(6);
        addData(8);

        // test traverse
        traverse(head);

        // test insertNode
        insertNode(head,4,4);
        System.out.println("======插入数据以后======");
        traverse(head);

        // test delete
        deleteNode(head,3);
        System.out.println("========删除数据之后=======");
        traverse(head);
    }

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
     * 遍历链表
     * @param head 头指针(头结点)
     */
    public static void traverse(Node head) {

        // 从首元节点开始
        Node temp = head.getNext();
        // 遍历输出
        while (temp != null) {
            if (temp.getData() != null)
                System.out.println(temp.getData());
            temp = temp.getNext();
        }
    }

    /**
     * 计算链表长度
     * @param head
     * @return 链表长度
     */
    public static Integer linkedListLength(Node head) {

        Integer length = 0;
        // 从首元节点开始
        Node temp = head.getNext();

        while (temp != null) {
            length ++;
            temp = temp.getNext();
        }

        return length;
    }

    /**
     * 插入节点
     * @param head
     * @param index
     * @param value
     *
     * @bug 在链表最后插入时失败(解决)
     */
    public static void insertNode(Node head, Integer index, Integer value) {

        // 判断插入位置是否合理
        if (index < 1 || index > linkedListLength(head)+1 ) {
            System.out.println("插入位置不合法");
            return;
        }

        Node temp = head;
        int currentPos = 1;
        // 创建要插入的节点
        Node insertNode = new Node(value);

        while ( temp.getNext() != null) {
            // 判断插入的位置
            if (index == currentPos) {
                // 插入节点
                insertNode.setNext(temp.getNext());
                temp.setNext(insertNode);
                return;
            }
            currentPos ++;
            temp = temp.getNext();
        }
        // 在链表最后插入数据
        addData(value);
    }

    /**
     * 删除节点
     * @param head
     * @param index
     */
    public static void deleteNode(Node head, Integer index) {

        // 判断删除位置是否合理
        if (index < 1 || index > linkedListLength(head)) {
            System.out.println("删除位置不合法");
            return;
        }

        Node temp = head;
        int currentPos = 1;
        // 找到删除的前一个节点
        while (temp.getNext() != null) {
            if (index == currentPos) {
                // 保存删除的节点
                Node deleteNode = temp.getNext();
                // 删除（gc自动回收deleteNode）
                temp.setNext(deleteNode.getNext());
                return;
            }

            currentPos ++;
            temp = temp.getNext();
        }
    }



}
