package week1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class U14568 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int candy = Integer.parseInt(br.readLine());
        int count = 0;

        for (int tmp = 1; tmp * 2 <= candy - 4; tmp++) {
            count += ((candy - 2) - (tmp * 2)) / 2;
        }

        bw.write(count + "");

        bw.flush();
        br.close();
        bw.close();
    }
}
