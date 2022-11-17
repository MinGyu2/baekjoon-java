package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P25683 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        final int n = Integer.parseInt(st.nextToken());
        final int m = Integer.parseInt(st.nextToken());
        final int k = Integer.parseInt(st.nextToken());
        char[][] arr = new char[n][];
        for(int i = 0;i<n;i++){
            arr[i] = br.readLine().toCharArray();
        }

        int[][] white = new int[n+1][m+1];
        int[][] black = new int[n+1][m+1];
        char temp;
        char sW = 'W';
        char sB = 'B';
        char nW = 'B';
        char nB = 'W';
        for(int j = 1; j<n+1;j++){
            for(int i = 1;i<m+1;i++){
                // white start
                white[j][i] = ((arr[j-1][i-1] != sW)?1:0) + white[j-1][i] + white[j][i-1] - white[j-1][i-1];
                
                // black start
                black[j][i] = ((arr[j-1][i-1] != sB)?1:0) + black[j-1][i] + black[j][i-1] - black[j-1][i-1];
                
                // 스위치
                temp = sW;
                sW = sB;
                sB = temp;
            }
            sW = nW;
            sB = nB;

            // 스위치
            temp = nW;
            nW = nB;
            nB = temp;
        }
        // find min
        int min = Integer.MAX_VALUE;
        int tp;
        for(int j = 1; j < n-k+2;j++){
            for(int i = 1;i<m-k+2;i++){
                tp = white[j+k-1][i+k-1] - white[j-1][i+k-1] - white[j+k-1][i-1] + white[j-1][i-1];
                min = Math.min(tp, min);
                tp = black[j+k-1][i+k-1] - black[j-1][i+k-1] - black[j+k-1][i-1] + black[j-1][i-1];
                min = Math.min(tp, min);
            }
        }

        System.out.println(min);
        // for(int[] w:white){
        //     System.out.println(Arrays.toString(w));
        // }
        // System.out.println();
        // for(int[] b:black){
        //     System.out.println(Arrays.toString(b));
        // }
    }
}
