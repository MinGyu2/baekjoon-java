package baekjoon;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;

public class P1300_1 {
    public static void main(String[] args) throws IOException{
        // long[][] arr = new long[n][n];
        long n = 100;
        ArrayList<Long> arr = new ArrayList<>();
        for(long j = 1;j<n+1;j++){
            for(long i = 1;i<n+1;i++){
                arr.add(j*i);
            }
        }
        Collections.sort(arr);
        // System.out.println(arr);
        FileOutputStream f = new FileOutputStream(new File("C:\\Users\\mq2022\\Desktop\\t2.txt"));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(f));
        for(int k = 0;k<n*n;k++){
            bw.append(k+" "+arr.get(k) ).append('\n');
        }
        bw.close();
    }
}
