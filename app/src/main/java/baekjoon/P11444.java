package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P11444{
    static final int MOD = 1000000007;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());
        
        System.out.println(fiboncci(n));
    }
    // n 번째 피보나치 수 구하기
    static int fiboncci(final long n){
        if(n == 1){ return 1; }
        // F0 = 0 , F1 = 1
        //  Fn+1 Fn      =   (1 1) ^ n
        //  Fn   Fn-1        (1 0)
        // arr^n-1 승의 arr[0][0]의 값을 구하면 된다.
        // 1
        long[] cp = new long[63];
        cp[0] = 1;
        for(int i = 1; i<63;i++){
            cp[i] = cp[i-1] * 2;
        }

        // 2
        boolean[] indexs = new boolean[63];
        long b = n-1;
        for(int i = 62;i>-1;i--){
            if(b >= cp[i]){
                b -= cp[i];
                indexs[i] = true;
            }
        }

        // 3 arr^n-1 구하기
        int[][] arr = {{1,1},{1,0}}; // 처음 초기화
        int[][] answer = {{1,0},{0,1}};
        for(int i = 0; i<63;i++){
            if(indexs[i]){
                answer = arrayMul(answer, arr);
            }
            arr = arrayMul(arr, arr);
        }
        return answer[0][0];
    }
    // 무조건 곱할 수 있는 변수만 온다. 또 n x n 형태만 온다.
    static int[][] arrayMul(int[][] a1, int[][] a2){
        int n = a1.length;
        int[][] answer = new int[n][n];
        long temp = 0;
        for(int j = 0; j<n;j++){
            for(int i = 0; i<n;i++){
                temp = 0;
                for(int z = 0;z<n;z++){
                    temp = (temp + (long)a1[j][z]*(long)a2[z][i])%MOD;
                }
                answer[j][i] = (int)temp;
            }
        }
        return answer;
    }
}