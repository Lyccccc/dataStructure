package net.coderchen.practice.adt;

import java.util.LinkedList;

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

    public void addEdge(int s, int t){
        adj[s].add(t);
        adj[t].add(s);
    }
}
