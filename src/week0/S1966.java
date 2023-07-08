package week0;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;
import java.util.StringTokenizer;

public class S1966 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(br.readLine());

        for (int i = 0; i < testCase; i++) {
            ArrayList<Integer> q = new ArrayList<>();
            String[] nm = br.readLine().split(" ");
            int n = Integer.parseInt(nm[0]);
            int m = Integer.parseInt(nm[1]);
            int count = 0;
//            String[] print;
            StringTokenizer print = new StringTokenizer(br.readLine(), " ");
//            if(n != 1) print = br.readLine().split(" ");
//            else print = br.readLine();

            for (int tmp = 0; tmp < n; tmp++) {
                q.add(q.size(), Integer.parseInt(print.nextToken()));
            }
            for (int tmp = 0; tmp < n; tmp++) {
                count++;
                if (!Objects.equals(Collections.max(q), q.get(tmp))) {
                    q.add(q.size(), q.get(tmp));
                    q.remove(0);
                    tmp--;
                } else {
                    if (q.remove(0) == m) bw.write(count + "");
                    else tmp--;
                }
            }
        }

        bw.flush();
        br.close();
        bw.close();
    }

}
