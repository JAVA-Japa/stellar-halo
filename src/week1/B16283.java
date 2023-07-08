package week1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class B16283 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int sheep = 0;
        int goat = 0;
        int possibility = 0;

        for (int temp = 1; temp < n; temp++) {
            if (temp * a + (n - temp) * b == w) {
                possibility++;
                sheep = temp;
                goat = n - sheep;
            }
        }

        if (possibility == 1) bw.write(sheep + " " + goat);
        else bw.write("-1");

        bw.flush();
        br.close();
        bw.close();
    }
}
