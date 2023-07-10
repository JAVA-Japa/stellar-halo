package week1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class B1145 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int i1 = Integer.parseInt(st.nextToken());
        int i2 = Integer.parseInt(st.nextToken());
        int i3 = Integer.parseInt(st.nextToken());
        int i4 = Integer.parseInt(st.nextToken());
        int i5 = Integer.parseInt(st.nextToken());
        int mostMultiple = 1;

        for (; mostMultiple <= Math.pow(100,3); mostMultiple++) {
            int count = 0;
            if (mostMultiple % i1 == 0) count++;
            if (mostMultiple % i2 == 0) count++;
            if (mostMultiple % i3 == 0) count++;
            if (mostMultiple % i4 == 0) count++;
            if (mostMultiple % i5 == 0) count++;
            if (count >= 3) break;
        }
        bw.write(mostMultiple + "");
        bw.flush();
        br.close();
        bw.close();
    }
}
