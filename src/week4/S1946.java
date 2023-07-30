package week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class S1946 {
    static private int T;
    static private int N;
    static private ArrayList<Score> scores;

    static class Score{
        int s1;
        int s2;

        public Score(int s1, int s2) {
            this.s1 = s1;
            this.s2 = s2;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for (int temp = 0; temp < T; temp++) {
            N = Integer.parseInt(br.readLine());
            scores = new ArrayList<>();
            int count = 0;
            for (int tmp = 0; tmp < N; tmp++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int s1 = Integer.parseInt(st.nextToken());
                int s2 = Integer.parseInt(st.nextToken());
                scores.add(tmp, new Score(s1, s2));
            }
            Collections.sort(scores, Comparator.comparingInt(o -> o.s1));
            for (int tmp1 = 0; tmp1 < N; tmp1++) {
                if (tmp1 == 0) count++;
                else if (tmp1 == N - 1) {
                    if (scores.get(tmp1).s2 == 1) count++;
                } else {
                    if (scores.get(tmp1).s2 > scores.get(tmp1 - 1).s2) scores.get(tmp1).s2 = scores.get(tmp1 - 1).s2;
                    else count++;
                }
            }
            System.out.println(count);
        }
        br.close();
    }
}
