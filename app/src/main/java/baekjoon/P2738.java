package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.function.BiFunction;

public class P2738 {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer tk = new StringTokenizer(reader.readLine()," ");
        int n = Integer.parseInt(tk.nextToken());
        int m = Integer.parseInt(tk.nextToken());
        //1
        int[][] matrix1 = new int[n][m];
        for(int i=0; i< n;i++){
            matrix1[i] = Arrays.stream(reader.readLine().split(" ")).mapToInt((s)->Integer.parseInt(s)).toArray();
        }
        //2
        int[][] matrix2 = new int[n][m];
        for(int i=0; i< n;i++){
            matrix2[i] = Arrays.stream(reader.readLine().split(" ")).mapToInt((s)->Integer.parseInt(s)).toArray();
        }
        //sum
        BiFunction<int[],int[],int[]> f = (a, b) -> {
            int[] z = new int[b.length];
            for(int i=0;i<b.length;i++){
                z[i] = a[i] + b[i];
            }
            return z;
        };
        int[][] z = new int[n][m];
        for(int i=0; i<n;i++){
            z[i] = f.apply(matrix1[i],matrix2[i]);
            // Arrays.sumn
            // matrix1[i]
        }

        // 출력
        for(int[] t: z){
            for(int l:t){
                sb.append(l+" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
