package week1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashSet;

public class S2503 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        HashSet<Integer> answer = new HashSet<>();
        for (int hundred = 1; hundred < 10; hundred++) {
            for (int ten = 1; ten < 10; ten++) {
                if (hundred != ten) {
                    for (int one = 1; one < 10; one++) {
                        if (ten != one && hundred != one) answer.add(hundred * 100 + ten * 10 + one);
                    }
                }

            }
        }
        for (int temp = 0; temp < n; temp++) {

        }
        for (int i : answer) {
//            findAnswer(answer, )
        }

        bw.flush();
        br.close();
        bw.close();
    }

    public boolean findAnswer(ArrayList<String> a, ArrayList<String> q, int s, int b) {
        int tempS = 0;
        int tempB = 0;
        for (String number : a) {
            if (q.contains(number)) tempB++;
        }
        for (int temp = 0; temp < 3; temp++) {
            if (a.get(temp).equals(q.get(temp))) {
                tempS++;
                tempB--;
            }
        }
        return tempS == s && tempB == b;
    }
}
