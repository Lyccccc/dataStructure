package net.coderchen.practice.adt;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Liuyuchen
 * @date 2019/09/11
 * 无向图 邻接表实现
 */
public class Graph {
    /**
     * 顶点个数
     */
    private int vertexs;
    /**
     * 邻接表 adjacency list
     * 由链表组成的数组
     */
    private LinkedList<Integer>[] adj;

    public Graph(int vertexs) {
        this.vertexs = vertexs;
        //初始化
        adj = new LinkedList[vertexs];
        for (int i = 0; i < adj.length; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    /**
     * 增加边 无向图需要增加两次
     * @param s
     * @param t
     */
    public void addEdge(int s, int t){
        adj[s].add(t);
        adj[t].add(s);
    }

    /**
     * 广度优先搜索
     * @param s 起点
     * @param t 终点
     * 0 —— 1 —— 2
     * |      |      |
     * 3 —— 4 —— 5
     *        |      |
     *        6 —— 7
     */
    public void bfs(int s, int t){
        if(s == t){
            return;
        }
        //queue 记录已经被访问，但相连的顶点还没被访问的顶点
        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(s);
        //visited 记录顶点是否被访问过
        boolean[] visited = new boolean[vertexs];
        visited[s] = true;
        //prev 记录顶点的上一个顶点，例如 2 -> 3 ->6，则prev[3] == 2, prev[6] == 3
        int[] prev = new int[vertexs];
        for (int i : prev) {
            prev[i] = -1;
        }
        while(queue.size() > 0){
            //queue 出队列
            int w = queue.poll();
            //将adj[w]链表中的元素加入到queue中
            for (int i : adj[w]) {
                //若没访问过，入队，否则不做处理
                if(!visited[i]){
                    prev[i] = w;
                    //i == t表示到达终点
                    if(i == t){
                        printTrace(prev, s, t);
                        System.out.println("");
                        return;
                    }
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }
    }

    private void printTrace(int[] prev, int s, int t){
        if (prev[t] != -1 && s != t) {
            printTrace(prev, s, prev[t]);
        }
        System.out.print(t + " ");
    }

    public static void main(String[] args) {
        Graph graph = new Graph(8);
        graph.addEdge(0, 1);
        graph.addEdge(0, 3);
        graph.addEdge(1, 2);
        graph.addEdge(1, 4);
        graph.addEdge(3, 4);
        graph.addEdge(2, 5);
        graph.addEdge(4, 5);
        graph.addEdge(4, 6);
        graph.addEdge(5, 7);
        graph.addEdge(6, 7);
        System.out.println("bfs搜索0 - 7");
        graph.bfs(0, 7);
        System.out.println("bfs搜索1 - 6");
        graph.bfs(1, 6);
        System.out.println("bfs搜索3 - 5");
        graph.bfs(3, 5);
        System.out.println("bfs搜索4 - 4");
        graph.bfs(4, 4);
    }
}
