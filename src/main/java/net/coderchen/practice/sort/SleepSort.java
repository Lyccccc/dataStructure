package net.coderchen.practice.sort;

/**
 * @author Liuyuchen
 * @date 2019/08/12
 */
public class SleepSort {
    private static int[] arr = new int[]{1, 55, 61, 32, 9, 13, 21, 8, 23, 47};

    public static void main(String[] args) {
        for (int i : arr) {
            new Thread(new MyTask(i)).start();
        }
    }

    static class MyTask implements Runnable{
        private int value;

        public MyTask(int value) {
            this.value = value;
        }

        public void run() {
            try {
                //放大10倍，避免误差
                Thread.sleep(value * 10 + 10);
                System.out.print(value + " ");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
