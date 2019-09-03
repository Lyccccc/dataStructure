package net.coderchen.practice.tree;

/**
 * @author Liuyuchen
 * @date 2019/09/03
 * 二叉查找树
 */
public class BinarySearchTree {
    private Node tree;
//    private int[] arr = new int[]{61, 2, 6, 33, 10, 36, 99, 47, 21, 88, 5, 78, 16, 70, 83};

    public BinarySearchTree() {

    }

    public void insert(int val){
        if(null == tree){
            tree = new Node(val);
            return;
        }
        Node tmp = tree;
        Node node = new Node(val);
        while(true){
            while(val < tmp.data){
                if(null != tmp.left){
                    tmp = tmp.left;
                }else{
                    tmp.left = node;
                    return;
                }
            }
            while(val > tmp.data){
                if(null != tmp.right){
                    tmp = tmp.right;
                }else{
                    tmp.right = node;
                    return;
                }
            }
        }
    }

    public static void main(String[] args) {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        binarySearchTree.insert(61);
        binarySearchTree.insert(2);
        binarySearchTree.insert(6);
        binarySearchTree.insert(33);
        binarySearchTree.insert(10);
        binarySearchTree.insert(36);
        binarySearchTree.insert(99);
        binarySearchTree.insert(47);
        binarySearchTree.insert(21);
        binarySearchTree.insert(88);
        binarySearchTree.insert(5);
        binarySearchTree.insert(78);
        binarySearchTree.insert(16);
        binarySearchTree.insert(70);
        binarySearchTree.insert(83);
        System.out.println(binarySearchTree.find(1));
        System.out.println(binarySearchTree.find(0));
        System.out.println(binarySearchTree.find(47));
        System.out.println(binarySearchTree.find(61));
        System.out.println(binarySearchTree.find(10));
    }

    public Node find(int val){
        Node tmp = tree;
        while(null != tmp){
            if(val < tmp.data){
                tmp = tmp.left;
            }else if(val > tmp.data){
                tmp = tmp.right;
            }else{
                return tmp;
            }
        }
        return null;
    }

    static class Node{
        public int data;
        public Node left;
        public Node right;

        public Node(int data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    '}';
        }
    }
}
