package net.coderchen.practice;

/**
 * @author Liuyuchen
 * @date 2019/03/28
 * @Description 反转单向链表
 */
public class ReverseLinkedList {

    public static void main(String[] args) {
        MyNode a = new MyNode("a");
        MyNode b = new MyNode("b");
        MyNode c = new MyNode("c");
        MyNode d = new MyNode("d");
        MyNode e = new MyNode("e");
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = null;
        MyNode node = reverse(a);
        System.out.println(node.content);
        while(null != node.next){
            node = node.next;
            System.out.println(node.content);
        }
    }

    public static MyNode reverse(MyNode root){
        if(null == root.next){
            return root;
        }
        MyNode copy = root;
        MyNode res = new MyNode(root.content, root);
        res.next = null;
        while(null != copy.next){
            copy = copy.next;
            MyNode node = new MyNode(copy.content);
            node.next = res;
            res = node;
        }
        return res;
    }

    static class MyNode{
        /**
         * 为了方便，写成了public
         */
        public String content;
        public MyNode next;

        public MyNode(String content, MyNode next) {
            this.content = content;
            this.next = next;
        }

        public MyNode(String content) {
            this.content = content;
        }
    }
}
