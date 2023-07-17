package week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S2110 {
    private static int N;
    private static int C;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        long[] house = new long[N];
        for (int tmp = 0; tmp < N; tmp++) {
            house[tmp] = Long.parseLong(br.readLine());
        }
        Arrays.sort(house);

        long far = house[1] - house[0];
        for (int tmp = 2; tmp < N; tmp++) {
            far = Math.max(far, house[tmp] - house[tmp - 1]);
        }

        long start = 1;
        long end = far;
        long mid = 0;
        while (start <= end) {
            long sum = 0;
            int count = 0;
            mid = start + (end - start) / 2;
            for (int i = 1; i < N; i++) {
                long l = house[i] - house[i - 1];
                if (sum + l >= mid) {
                    sum = 0;
                    count++;
                } else sum += l;
            }
            if (C - 1 > count) end = mid - 1;
            else start = mid + 1;
        }
        System.out.println(start - 1);
        br.close();
    }
}
