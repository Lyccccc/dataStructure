package net.coderchen.practice.search;

import java.util.Random;

/**
 * @author Liuyuchen
 * @date 2019/08/23
 * 跳表
 * 支持快速增、删、查（O(logn)）
 */
public class SkipList {

    /**
     * 底层数据根节点
     */
    private Node root;
    /**
     * 索引根节点
     */
    private Node indexRoot;
    /**
     * 索引深度
     */
    private int indexDepth;

    public SkipList(int length) {
        Random random = new Random();
        int value = random.nextInt(5);
        root = new Node(value, null, null);
        Node tail = root;
        //初始化链表
        for (int i = 0; i < length - 1; i++) {
            value += random.nextInt(5);
            Node node = new Node(value, null, null);
            tail.next = node;
            tail = node;
        }
        //创建索引
        indexRoot = buildIndex(root);
    }

    /**
     * 创建索引
     * @param first 当前行的第一个元素
     */
    private Node buildIndex(Node first){
        //终止条件：链表长度=2
        if(null == first.next.next){
            return first;
        }
        Node lineRoot = new Node(first.value, null, first);
        Node lineTail = lineRoot;
        int count = 0;
        Node node = first;
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
        return buildIndex(lineRoot);
    }

    /**
     * 打印链表
     * @param first 当前行的第一个元素
     */
    private String printNodeList(Node first){
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
        if(root == null){
            return null;
        }
        StringBuilder builder = new StringBuilder("");
        Node node = indexRoot;
        do{
            if(null == node.down){
                builder.append("链表元素：");
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
     * @return 位置
     */
    public Node search(int value){
        Node node = indexRoot;
        while(true){
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
     * @param value 待删除的元素
     * @return 删除成功标识
     */
    public boolean delete(int value){
        return true;
    }

    /**
     * 向跳表中新增元素
     * @param value 新增的元素
     */
    public void add(int value){

    }

    /**
     * 索引节点
     */
    class Node{
        private int value;
        private Node next;
        private Node down;

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
                    ", nextValue" + (null == next ? "null" : next.value) +
                    '}';
        }
    }

    public static void main(String[] args) {
        SkipList skipList = new SkipList(100);
        System.out.println(skipList.toString());
        for (int i = 0; i < 50; i++) {
            int random = new Random().nextInt(200);
            System.out.print("random:" + random + " ");
            System.out.println(skipList.search(random));
        }
    }
}
