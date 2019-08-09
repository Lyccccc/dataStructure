package net.coderchen.practice.adt;

import sun.security.util.Length;

/**
 * @author Liuyuchen
 * @date 2019/08/09
 */
public class Stack {
    private String[] arr;
    /**
     * 栈容量
     */
    int capacity;
    /**
     * 栈顶元素位置
     */
    int top = -1;

    Stack(int capacity){
        this.arr = new String[capacity];
        this.capacity = capacity;
    }

    /**
     * 入栈
     * @param item
     * @return
     */
    public boolean push(String item){
        if(top == capacity-1){
            return false;
        }
        arr[++top] = item;
        return true;
    }

    /**
     * 出栈
     * @return
     */
    public String pop(){
        if(top == -1){
            return null;
        }
        return arr[top--];
    }

    public static void main(String[] args) {
        Stack stack = new Stack(5);
        stack.push("a");
        stack.push("b");
        stack.push("c");
        stack.push("d");
        stack.push("e");
        for (int i = 0; i < 10; i++) {
            System.out.println(stack.pop());
        }
    }
}
