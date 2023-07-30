package week2;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class S10815 {
    private static int N;
    private static int M;
    private static List<Integer> cards;

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = scanner.nextInt();
        cards = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            cards.add(scanner.nextInt());
        }
        Collections.sort(cards);

        M = scanner.nextInt();
        for (int i = 0; i < M; i++) {
            int card = scanner.nextInt();
            if (binarySearch(card)) bw.write("1 ");
            else bw.write("0 ");
        }

        bw.flush();
        bw.close();
    }

    private static boolean binarySearch(int card) {
        int start = 0;
        int end = N - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (card == cards.get(mid)) {
                return true;
            } else if (card < cards.get(mid)) end = mid - 1;
            else start = mid + 1;
        }
        return false;
    }
}
