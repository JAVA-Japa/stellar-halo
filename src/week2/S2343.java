package week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S2343 {
    private static int N;
    private static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] video = new int[N];
        long start = 0;
        long end = 0;
        long mid = 0;
        for (int tmp = 0; tmp < N; tmp++) {
            video[tmp] = Integer.parseInt(st.nextToken());
            end += video[tmp];
            if (start != 0) start = Math.max(start, video[tmp]);
            else start = video[tmp];
        }

        while (start < end) {
            int sum = 0;
            int count = 0;
            mid = start + (end - start) / 2;
            for (int i : video) {
                if (sum + i > mid) {
                    sum = i;
                    count++;
                } else sum += i;
            }
            if (M > count) end = mid;
            else start = mid + 1;
        }
        System.out.println(start);
        br.close();
    }
}
