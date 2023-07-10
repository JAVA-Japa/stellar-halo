package week1;

import java.util.List;
import java.util.Scanner;
import java.util.concurrent.CopyOnWriteArrayList;

public class S2503 {
    private static List<Integer> answer;
    private static int N;
    private static int NUMBER;
    private static int S;
    private static int B;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        answer = new CopyOnWriteArrayList<>();
        for (int hundred = 1; hundred < 10; hundred++) {
            for (int ten = 1; ten < 10; ten++) {
                if (hundred != ten) {
                    for (int one = 1; one < 10; one++) {
                        if (ten != one && hundred != one) answer.add(hundred * 100 + ten * 10 + one);
                    }
                }
            }
        }
        for (int temp = 0; temp < N; temp++) {
            NUMBER = scanner.nextInt();
            S = scanner.nextInt();
            B = scanner.nextInt();
            findAnswer();
        }
        System.out.println(answer.size());
    }

    private static void findAnswer() {
        int hundred = NUMBER / 100;
        int ten = NUMBER / 10 % 10;
        int one = NUMBER % 10;
        for (int i : answer) {
            int strike = 0;
            int ball = 0;
            int h = i / 100;
            int t = i / 10 % 10;
            int o = i % 10;
            if (hundred == h) strike++;
            else {
                if (hundred == t) ball++;
                else if (hundred == o) ball++;
            }
            if (ten == t) strike++;
            else {
                if (ten == h) ball++;
                else if (ten == o) ball++;
            }
            if (one == o) strike++;
            else {
                if (one == h) ball++;
                else if (one == t) ball++;
            }
            if (S != strike || B != ball) answer.remove((Integer) i);
        }
    }
}
