package week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S2514 {
    private static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] request = new int[N];
        int max = 0;
        for (int temp = 0; temp < N; temp++) {
            request[temp] = Integer.parseInt(st.nextToken());
            if (max < request[temp]) {
                max = request[temp];
            }
        }
        int budget = Integer.parseInt(br.readLine());

        int end = max + 1;
        int start = 0;
        int mid = 0;
        while (start < end) {
            int sum = 0;
            mid = start + (end - start) / 2;
            for (int tmp : request) {
                sum += Math.min(tmp, mid);
            }
            if (budget >= sum) start = mid + 1;
            else end = mid;
        }
        System.out.println(start - 1);
        br.close();
    }
}
