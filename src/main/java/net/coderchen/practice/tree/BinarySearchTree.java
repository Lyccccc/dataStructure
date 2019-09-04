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
        Node p = tree;
        Node node = new Node(val);
        while(true){
            while(val < p.data){
                if(null != p.left){
                    p = p.left;
                }else{
                    p.left = node;
                    return;
                }
            }
            while(val > p.data){
                if(null != p.right){
                    p = p.right;
                }else{
                    p.right = node;
                    return;
                }
            }
        }
    }

    /**
     * 删除节点
     * @param val
     * 三种情况：
     * 1、若要删除的节点没有子节点，则直接将父节点指向该节点的指针置为null
     * 2、若要删除的节点只有一个子节点，则将父节点指向该节点的指针，置为该节点的子节点
     * 3、若要删除的节点由两个子节点，把将右子树的最小节点替换到该节点的位置上，然后删除右子树的最小节点
     */
    public void delele(int val){
        //待删除的节点
        Node p = tree;
        //p的父节点
        Node pp = null;
        while(null != p){
            if(val < p.data){
                pp = p;
                p = p.left;
            }else if(val > p.data){
                pp = p;
                p = p.right;
            }else{
                break;
            }
        }
        if(null == p){
            return;
        }
        if(null != p.left && null != p.right){//情况3
            //寻找右子树的最小节点
            Node minp = p.right;
            //右子树最小节点的父节点
            Node minpp = p;
            while(null != minp.left){
                minpp = minp;
                minp = minp.left;
            }
            //minP替换到p位置，然后删除minP
            if(minpp == p){
                p.right = minp.right;
                p.data = minp.data;
            }else{
                p.data = minp.data;
                minpp.left = minp.right;
            }
        }else if(null == p.left && null == p.right){//情况1
            if(null == pp){//删除的是根节点
                tree = null;
                return;
            }
            //直接删除p
            if(null != pp.left && p.data == pp.left.data){
                pp.left = null;
            }else{
                pp.right = null;
            }
        }else{//情况2，左右两个子树其中一个不为空
            if(null != p.left){
                if(null == pp){
                    tree = p.left;
                }else{
                    pp.left = p.left;
                }
            }else{
                if(null == pp){
                    tree = p.right;
                }else{
                    pp.right = p.right;
                }
            }
        }
    }

    public Node find(int val){
        Node p = tree;
        while(null != p){
            if(val < p.data){
                p = p.left;
            }else if(val > p.data){
                p = p.right;
            }else{
                return p;
            }
        }
        return null;
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
        System.out.println(binarySearchTree.find(1));
        System.out.println(binarySearchTree.find(0));
        System.out.println(binarySearchTree.find(47));
        System.out.println(binarySearchTree.find(61));
        System.out.println(binarySearchTree.find(10));
        binarySearchTree.delele(61);
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
