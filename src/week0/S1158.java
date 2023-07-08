package week0;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class S1158 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> people = new ArrayList<>();
        String[] nk = br.readLine().split(" ");

        int n = Integer.parseInt(nk[0]);
        int k = Integer.parseInt(nk[1]);
        int idx = k;

        while (people.size() < n) {
            idx = idx > n ? idx % n : idx;
            if (people.contains(idx)) idx++;
            else {
                people.add(people.size(), idx);
                idx += k;
            }
        }

        for (int i : people) {
            bw.write(i + "");
        }

        bw.flush();
        br.close();
        bw.close();
    }
}
