package week1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class U17945 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] coeffi = br.readLine().split(" ");

        int a = Integer.parseInt(coeffi[0]);
        int b = Integer.parseInt(coeffi[1]);
        int x1 = 0;
        int x2 = 0;
        int minus = 1;
        if (b < 0) minus = -1;

        for (int tmp = 1; tmp <= minus * b; tmp++) {
            if (minus * b % tmp == 0) {
                x1 = tmp;
                x2 = b / tmp;
                if ((-1) * x1 + (-1) * x2 == 2 * a) break;
                else if (x1 + x2 == 2 * a) {
                    x1 = (-1) * x1;
                    x2 = (-1) * x2;
                    break;
                }
            }
        }
        if (x1 == x2) bw.write(x1 + "");
        else if (x1 < x2) bw.write(x1 + " " + x2);
        else bw.write(x2 + " " + x1);


        bw.flush();
        br.close();
        bw.close();
    }
}
