package week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S11399 {
    private static int N;
    private static int[] P;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        P = new int[N];
        int sum = 0;
        for (int t = 0; t < N; t++) {
            P[t] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(P);
        for (int tmp = 0; tmp < N; tmp++) {
            sum += P[tmp] * (P.length - tmp);
        }
        System.out.println(sum);
    }
}
