package net.coderchen.practice.tree;

/**
 * @author Liuyuchen
 * @date 2019/09/03
 * 二叉查找树
 */
public class BinarySearchTree {
    private Node tree;
    private int[] arr = new int[]{61, 2, 6, 33, 10, 36, 99, 47, 21, 88, 5, 78, 16, 70, 83};

    public BinarySearchTree() {
        tree = new Node(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            buildTree(arr[i]);
        }
    }

    private void buildTree(int val){
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
    }

    public Node find(int val){
        return null;
    }

    static class Node{
        public int data;
        public Node left;
        public Node right;

        public Node(int data) {
            this.data = data;
        }
    }
}
