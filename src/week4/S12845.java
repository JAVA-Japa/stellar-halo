package week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S12845 {
    static private int N;
    static private int[] cards;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        cards = new int[N];
        int sum = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int temp = 0; temp < N; temp++) {
            cards[temp] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(cards);
        for (int temp = 0; temp < N-1; temp++) {
            sum += cards[N-1] + cards[temp];
        }
        System.out.println(sum);
        br.close();
    }
}
