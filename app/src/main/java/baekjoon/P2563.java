package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P2563 {
    public static void main(String[] agrs) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());

        // 100*100
        int[][] arr = new int[100][100];

        //
        StringTokenizer tk;
        int aa,bb;
        for(int k = 0; k < n; k++){
            tk = new StringTokenizer(reader.readLine()," ");
            aa = Integer.parseInt(tk.nextToken());
            bb = Integer.parseInt(tk.nextToken());
            for(int aaa = 0; aaa<10;aaa++){
                for(int bbb = 0; bbb<10; bbb++){
                    arr[aa + aaa][bb + bbb] = 1;
                }
            }
        }
        
        // sum all 
        int sum = 0;
        for(int[] a:arr){
            sum += Arrays.stream(a).sum();
        }
        System.out.println(sum);
    }
}
