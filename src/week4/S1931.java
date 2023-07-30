package week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S1931 {
    static private int N;

    static class meetingTime {
        private int start;
        private int end;

        public meetingTime(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        meetingTime[] times = new meetingTime[N];
        ArrayList<meetingTime> classes = new ArrayList<>();
        for (int temp = 0; temp < N; temp++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            times[temp] = new meetingTime(start, end);
        }
        Arrays.sort(times, (t1, t2) -> t1.start == t2.start ? t1.end - t2.end : t1.start - t2.start);

        for (meetingTime mt : times) {
            if (classes.size() == 0) {
                classes.add(0, mt);
            }
            else{
                if(mt.start>classes.get(classes.size()-1).start && mt.end<classes.get(classes.size()-1).end){
                    classes.set(classes.size() - 1, mt);
                }
                else if (mt.start >= classes.get(classes.size()-1).end){
                    classes.add(classes.size(),mt);
                }
            }
        }

        System.out.println(classes.size());
        br.close();
    }
}
