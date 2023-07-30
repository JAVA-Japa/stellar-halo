package week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S11047 {
    private static int N;
    private static int K;
    private static int[] A;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        int copyK = K;
        int count = 0;
        A = new int[N];
        for (int t = 0; t < N; t++) {
            A[t] = Integer.parseInt(br.readLine());
        }
        for (int tmp = N-1; tmp >=0; tmp--) {
            if(copyK>=A[tmp]){
                count += copyK / A[tmp];
                copyK = copyK % A[tmp];
            }
            if(copyK == 0) break;
        }
        System.out.println(count);
    }
}
