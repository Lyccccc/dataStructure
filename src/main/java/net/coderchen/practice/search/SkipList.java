package net.coderchen.practice.search;

import java.util.Random;

/**
 * @author Liuyuchen
 * @date 2019/08/23
 * 跳表
 */
public class SkipList {

    private Node root;
    private Node indexRoot;
    private int indexDepth;

    public SkipList(int length) {
        Random random = new Random();
        int value = random.nextInt(10);
        root = new Node(value, null, null);
        Node tail = root;
        //初始化链表
        for (int i = 0; i < length - 1; i++) {
            value += random.nextInt(10);
            Node node = new Node(value, null, null);
            tail.next = node;
            tail = node;
        }
        //创建索引
        indexRoot = buildIndex(root);
    }

    /**
     * 创建索引
     * @param first
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
     * @param first
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
                builder.append("第" + ++indexDepth + "层索引：");
            }
            builder.append(printNodeList(node));
            node = node.down;
        }while (null != node);
        return builder.toString();
    }

    public static void main(String[] args) {
        SkipList skipList = new SkipList(100);
        System.out.println(skipList.toString());
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
    }
}
