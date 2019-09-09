package net.coderchen.practice.adt;

import java.util.Arrays;

/**
 * @author Liuyuchen
 * @date 2019/09/09
 */
public class Heap {
    private int capacity;
    private int[] arr;
    private int count;

    public Heap(int capacity) {
        this.capacity = capacity;
        arr = new int[capacity + 1];
        count = 0;
    }

    /**
     * 向堆中添加元素
     * @param item 添加的元素
     */
    public void insert(int item){
        //堆已满
        if(count >= capacity){
            return;
        }
        arr[++count] = item;
        int i = count;
        //新节点上浮
        //当存在父节点且子节点大于父节点时，交换
        while(i/2 > 0 && arr[i] > arr[i/2]){
            swap(arr, i, i/2);
            i /= 2;
        }
    }

    /**
     * 删除堆顶元素
     */
    public void deleteTop(){
        //堆为空
        if(0 == count){
            return;
        }
        //把最后一个元素放在堆顶
        arr[1] = arr[count--];
        //堆顶节点下沉
        int i = 1;
        int maxPos = i;
        while(true){
            if(i * 2 <= count && arr[i * 2] > arr[i]){
                maxPos = i * 2;
            }
            if(i * 2 + 1 <= count && arr[i * 2 + 1] > arr[i * 2]){
                maxPos = i * 2 + 1;
            }
            if(i == maxPos){
                break;
            }
            swap(arr, i, maxPos);
            i = maxPos;
        }
    }

    private void swap(int[] arr, int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 1; i <= count; i++) {
            stringBuilder.append(arr[i]).append(" ");
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        Heap heap = new Heap(10);
        heap.insert(40);
        heap.insert(20);
        heap.insert(28);
        heap.insert(66);
        heap.insert(19);
        heap.insert(74);
        heap.insert(30);
        heap.insert(65);
        heap.insert(90);
        heap.insert(25);
        //arr = 0, 90, 74, 66, 65, 25, 28, 30, 20, 40, 19
        System.out.println(heap.toString());
        heap.deleteTop();
        heap.deleteTop();
        heap.deleteTop();
        heap.deleteTop();
        heap.deleteTop();
        heap.deleteTop();
        heap.deleteTop();
        heap.deleteTop();
        heap.deleteTop();
        heap.deleteTop();

    }
}
