package net.coderchen.practice.search;

import java.util.Random;

/**
 * @author Liuyuchen
 * @date 2019/08/23
 * 跳表
 */
public class SkipList {
    private Node root;

    public SkipList(int length) {
        Random random = new Random();
        int value = random.nextInt(10);
        root = new Node(value, null, null);
        Node tail = root;
        for (int i = 0; i < length - 1; i++) {
            value += random.nextInt(10);
            Node node = new Node(value, null, null);
            tail.next = node;
            tail = node;
        }
    }



    @Override
    public String toString() {
        if(root == null){
            return null;
        }
        Node node = root;
        StringBuilder resultBuilder = new StringBuilder();
        resultBuilder.append(node.value);
        while(node.next != null){
            resultBuilder.append("->");
            node = node.next;
            resultBuilder.append(node.value);
        }
        return resultBuilder.toString();
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
