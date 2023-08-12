package week7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class S1260 {
    static private int N;
    static private int M;
    static private int V;
    static private ArrayList<Integer>[] graphics;
    static private boolean[] visited;
    static private Queue<Integer> q;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());
        graphics = new ArrayList[N + 1];
        visited = new boolean[N + 1];
        q = new LinkedList<>();

        initGraphics();
        initVisited();
        addNodes(br);
        sortGraphics();
        dfs(V);
        System.out.println();
        initVisited();
        bfs(V);
    }

    private static void sortGraphics() {
        for (int temp = 0; temp < N + 1; temp++) {
            Collections.sort(graphics[temp]);
        }
    }

    private static void addNodes(BufferedReader br) throws IOException {
        StringTokenizer st;
        for (int temp = 0; temp < M; temp++) {
            st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());
            if (!graphics[node1].contains(node2)) graphics[node1].add(node2);
            if (!graphics[node2].contains(node1)) graphics[node2].add(node1);
        }
    }

    private static void initGraphics() {
        for (int temp = 0; temp < N + 1; temp++) {
            graphics[temp] = new ArrayList<>();
        }
    }

    private static void initVisited() {
        for (int temp = 0; temp < N + 1; temp++) {
            visited[temp] = false;
        }
    }

    static void dfs(int nodeIdx) {
        visited[nodeIdx] = true;
        System.out.print(nodeIdx + " ");
        for (int node : graphics[nodeIdx]) {
            if (!visited[node]) {
                dfs(node);
            }
        }
    }

    static void bfs(int start) {
        q.offer(start);
        visited[start] = true;
        while (!q.isEmpty()) {
            int nodeIdx = q.poll();
            System.out.print(nodeIdx + " ");
            for (int node : graphics[nodeIdx]) {
                if (!visited[node]) {
                    visited[node] = true;
                    q.add(node);
                }
            }
        }
    }
}
