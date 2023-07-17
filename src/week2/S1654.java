package week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S1654 {
    private static int N;
    private static int K;
    private static int[] lan;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        lan = new int[K];
        long max = 0;

        for (int i = 0; i < K; i++) {
            lan[i] = Integer.parseInt(br.readLine());
            if (max < lan[i]) {
                max = lan[i];
            }
        }

        long start = 0;
        long end = max + 1;
        long mid = 0;

        while (start < end) {
            mid = start + (end - start) / 2;
            long count = 0;
            for (int tmp = 0; tmp < lan.length; tmp++) {
                count += (lan[tmp] / mid);
            }
            if (count < N) end = mid;
            else start = mid + 1;
        }

        System.out.println(end - 1);
        br.close();
    }
}
