package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P11051 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        System.out.println(C(n,k));
    }
    static int C(final int n, final int k){
        int[][] arr = new int[k+1][n+1];
        for(int j=0;j<k+1;j++){
            for(int i=1;i<n+1;i++){
                if(j == 0 || i == j){
                    arr[j][i] = 1;
                }else{
                    arr[j][i] = (arr[j][i-1] + arr[j-1][i-1])%10007;
                }
            }
        }
        return arr[k][n];
    }
}
