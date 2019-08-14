package net.coderchen.practice.adt;

/**
 * @author Liuyuchen
 * @date 2019/08/09
 */
public class Queue {
    private Node head;
    private Node tail;
    int capacity;
    int length;

    Queue(int capacity){
        this.capacity = capacity;
    }

    public boolean enqueue(String item){
        if(length >= capacity){
            return false;
        }
        length++;
        Node node = new Node(item, null);
        if(null == head){
            head = node;
            tail = node;
            return true;
        }
        Node oldTail = tail;
        tail = node;
        oldTail.next = tail;
        return true;
    }

    public String dequeue(){
        if(null == head){
            return null;
        }
        length--;
        Node oldHead = head;
        head = head.next;
        return oldHead.item;
    }

    class Node{
        private String item;
        private Node next;

        public Node(String item, Node next) {
            this.item = item;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        Queue queue = new Queue(5);
        queue.enqueue("a");
        queue.enqueue("b");
        queue.enqueue("c");
        queue.enqueue("d");
        queue.enqueue("e");
        for (int i = 0; i < queue.capacity; i++) {
            System.out.println(queue.dequeue());
        }
    }
}
