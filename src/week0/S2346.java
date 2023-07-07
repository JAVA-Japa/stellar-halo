package week0;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class S2346 {
    private final static String BURST = "0";

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> order = new ArrayList<>();

        int n = Integer.parseInt(br.readLine());
        String[] balloon = br.readLine().split(" ");
        int idx = 0;
        int move = Integer.parseInt(balloon[idx]);
        balloon[idx] = BURST;
        order.add(0, idx + 1);

        for (int tmp = 1; tmp < n; tmp++) {
            if (move > 0) {
                for (int temp = 0; temp < move; temp++) {
                    idx = (++idx + n) % n;
                    if (balloon[idx].equals(BURST)) --temp;
                }
            } else {
                for (int temp = 0; temp > move; temp--) {
                    idx = (--idx + n) % n;
                    if (balloon[idx].equals(BURST)) ++temp;
                }
            }
            move = Integer.parseInt(balloon[idx]);
            balloon[idx] = BURST;
            order.add(tmp, idx + 1);
        }

        for (int i : order) {
            bw.write(i + " ");
        }
        bw.flush();
        br.close();
        bw.close();
    }
}
