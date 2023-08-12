package week7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S1012 {
    static private int T;
    static private int M;
    static private int N;
    static private int K;
    static private int count;
    static private int[][] graphics;
    static private boolean[][] visited;
    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {1, 0, -1, 0};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for (int temp = 0; temp < T; temp++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            visited = new boolean[M][N];
            graphics = new int[M][N];
            count = 0;
            initVisited();

            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int n = Integer.parseInt(st.nextToken());
                int m = Integer.parseInt(st.nextToken());
                graphics[n][m] = 1;
            }

            for (int x = 0; x < M; x++) {
                for (int y = 0; y < N; y++) {
                    if (graphics[x][y] == 1 && !visited[x][y]) {
                        dfs(x, y);
                        count++;
                    }
                }
            }

            System.out.println(count);
        }
    }

    private static void dfs(int x, int y) {
        visited[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int cx = x + dx[i];
            int cy = y + dy[i];

            if (cx >= 0 && cy >= 0 && cx < M && cy < N) {
                if (!visited[cx][cy] && graphics[cx][cy] == 1) {
                    dfs(cx, cy);
                }
            }
        }
    }
    private static void initVisited() {
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                visited[i][j] = false;
            }
        }
    }
}
