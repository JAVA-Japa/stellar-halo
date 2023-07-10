package week1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class B6131 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int b = 1;
        int a;
        int count = 0;

        for (; b < 500; b++) {
            a = 1;
            for (; a < 500; a++) {
                if (a * a == b * b + n) count++;
            }
        }

        bw.write(count + "");

        bw.flush();
        br.close();
        bw.close();
    }
}
