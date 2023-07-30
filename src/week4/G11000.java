package week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class G11000 {
    private static int N;
    private static long[][] ST;
    private static PriorityQueue<Long> CLASSROOM;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        ST = new long[N][2];
        CLASSROOM = new PriorityQueue<>();
        for (int temp = 0; temp < N; temp++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            ST[temp][0] = Long.parseLong(st.nextToken());
            ST[temp][1] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(ST, (ST1, ST2) -> (int) (ST1[0] == ST2[0] ? ST1[1] - ST2[1] : ST1[0] - ST2[0]));
        CLASSROOM.offer(ST[0][1]);
        for (int temp = 1; temp < N; temp++) {
            long[] st = ST[temp];
            if (CLASSROOM.peek() <= st[0]) {
                CLASSROOM.poll();
            }
            CLASSROOM.offer(st[1]);
        }
        System.out.println(CLASSROOM.size());
        br.close();
    }
}
