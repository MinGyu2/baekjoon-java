package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P2775 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        int[][] arr = new int[15][15];
        for(int i=0;i<15;i++){
            arr[0][i] = i;
        }
        for(int i=1;i<15;i++){
            for(int j=1;j<15;j++){
                arr[i][j] = arr[i-1][j] + arr[i][j-1];
            }
        }
        StringBuilder sb = new StringBuilder();
        while(t-- > 0){
            int k = Integer.parseInt(br.readLine()); // 층
            int n = Integer.parseInt(br.readLine()); // 호
            sb.append(arr[k][n]);
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
