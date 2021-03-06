package net.coderchen.practice.search;

import java.util.Random;

/**
 * @author Liuyuchen
 * @date 2019/08/23
 * 跳表
 * 支持快速增、删、查，复杂度均为O(logn)
 */
public class SkipList {

    /**
     * 底层数据根节点
     */
    private Node rootGuard = new Node();
    /**
     * 索引根节点
     */
    private Node indexRootGuard = new Node();
    /**
     * 索引深度
     */
    private int indexDepth = 0;

    /**
     * @param length 跳表长度
     */
    public SkipList(int length) {
        Random random = new Random();
        int value = 1 + random.nextInt(10);
        rootGuard.next = new Node(value, null, null);
        Node tail = rootGuard.next;
        //初始化链表
        for (int i = 0; i < length - 1; i++) {
            value += random.nextInt(10);
            Node node = new Node(value, null, null);
            tail.next = node;
            tail = node;
        }
        //创建索引
        buildIndex(rootGuard);
    }

    /**
     * 创建索引
     * @param guard 下一行的哨兵
     */
    private void buildIndex(Node guard){
        Node head = guard.next;
        //终止条件：链表长度=2
        if(null == head.next.next){
            indexRootGuard = guard;
            return;
        }
        //根节点
        Node lineRoot = new Node(head.value, null, head);
        //尾节点
        Node lineTail = lineRoot;
        int count = 0;
        Node node = head;
        while(null != node.next){
            count++;
            //逢2创建索引节点
            if(count == 2){
                count = 0;
                Node indexNode = new Node(node.next.value, null, node.next);
                lineTail.next = indexNode;
                lineTail = indexNode;
            }
            node = node.next;
        }
        //当前行的哨兵
        Node lineGuard = new Node(0, lineRoot, guard);
        //递归，构建上一层的索引
        buildIndex(lineGuard);
    }

    /**
     * 打印链表
     * @param guard 当前行的哨兵
     */
    private String printNodeList(Node guard){
        Node first = guard.next;
        StringBuilder builder = new StringBuilder("");
        builder.append(first.value);
        Node node = first;
        while(null != node.next){
            builder.append("->");
            node = node.next;
            builder.append(node.value);
        }
        builder.append("\n");
        return builder.toString();
    }

    @Override
    public String toString() {
        //空链表
        if(rootGuard.next == null){
            return null;
        }
        StringBuilder builder = new StringBuilder("");
        Node node = indexRootGuard;
        do{
            if(null == node.down){
                builder.append(" 链表元素：");
            }else{
                builder.append("第").append(++indexDepth).append("层索引：");
            }
            builder.append(printNodeList(node));
            node = node.down;
        }while (null != node);
        return builder.toString();
    }

    /**
     * 查找值在跳表中的位置
     * @param value 待查找的值
     * @return 第一个匹配的节点
     */
    public Node search(int value){
        Node node = indexRootGuard;
        while(true){
            //value不等于当前节点且大于等于右边节点时，向右移动
            while(null != node.next && value != node.value && value >= node.next.value){
                node = node.next;
            }
            if(null != node.down){
                node = node.down;
            }else{
                break;
            }
        }
        if(value == node.value){
            return node;
        }else{
            return null;
        }
    }

    /**
     * 从跳表中删除元素
     * @param val 待删除的元素
     * @return 删除成功标识
     * 思路：从索引根节点开始遍历
     */
    public boolean delete(int val){
        return true;
    }

    /**
     * 向跳表中新增元素，如果已存在相同的元素，插入到其后面
     * @param val
     * 1、先插入，再更新索引
     *
     */
    public void add(int val){
//        Node node = indexRootGuard;
//        while(true){
//            //value大于等于右边节点时，向右移动
//            while(null != node.next && val >= node.next.value){
//                node = node.next;
//            }
//            if(null != node.down){
//                node = node.down;
//            }else{
//                break;
//            }
//        }
    }

    /**
     * 索引节点
     */
    class Node{
        private int value;
        private Node next;
        private Node down;

        public Node() {
        }

        public Node(int value, Node next, Node down) {
            this.value = value;
            this.next = next;
            this.down = down;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    ", down=" + (null == down ? "null" : down.value) +
                    ", nextValue=" + (null == next ? "null" : next.value) +
                    '}';
        }
    }

    public static void main(String[] args) {
        SkipList skipList = new SkipList(50);
        System.out.println(skipList.toString());
        for (int i = 0; i < 10; i++) {
            int random = new Random().nextInt(150);
            System.out.print("随机查找:" + random + " ");
            System.out.println(null == skipList.search(random) ? "不存在" : skipList.search(random));
        }
    }
}
