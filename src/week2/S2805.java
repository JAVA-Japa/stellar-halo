package week2;

import java.io.IOException;
import java.util.Scanner;

public class S2805 {
    private static int N;
    private static int M;
    private static int[] trees;
    private static long max = 0;

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        N = scanner.nextInt();
        M = scanner.nextInt();

        trees = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            trees[i] = scanner.nextInt();
            max = Math.max(max, trees[i]);
        }

        long start = 0;
        long end = max;

        while (start <= end) {
            long mid = (start + end) / 2;
            long sum = 0;

            for (int tree : trees) {
                sum += Math.max(tree - mid, 0);
            }

            if (sum >= M) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        System.out.println(end);
    }
}
