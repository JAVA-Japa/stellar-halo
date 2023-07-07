package week0;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class S10773 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int count = 0;
        int sum = 0;
        ArrayList<Integer> accountBook = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int tmp = Integer.parseInt(br.readLine());
            if(tmp == 0){
                count--;
                accountBook.remove(count);
            } else {
                accountBook.add(count,tmp);
                count++;
            }
        }

        for(int account : accountBook){
            sum += account;
        }

        bw.write(sum+"");
        bw.flush();
        br.close();
        bw.close();
    }
}
