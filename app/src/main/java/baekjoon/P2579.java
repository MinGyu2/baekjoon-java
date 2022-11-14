package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P2579 {
    // static int max = 0;
    // public static void main(String[] args) throws IOException{
    //     BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    //     int n = Integer.parseInt(br.readLine());
    //     final int[] arr = new int[n+1];
    //     for(int i=1;i<n+1;i++){
    //         arr[i] = Integer.parseInt(br.readLine());
    //     }
    //     final int[][] memo = new int[2][n+1];
    //     System.out.println(Arrays.toString(arr));
    //     upStair(memo, arr, 0, 0, 0, n);
    //     System.out.println(Arrays.toString(memo[0]));
    //     System.out.println(Arrays.toString(memo[1]));
    // }
    // static int upStair(final int[][] memo,final int[] arr,int sum, int s,int n, final int maxN){
    //     if(n == maxN){
    //         sum = sum+arr[n];
    //         // System.out.println(sum);
    //         // if(s == 2) memo[0][n] = Math.max(sum, memo[0][n]);
    //         // else memo[1][n] = Math.max(sum, memo[1][n]);
    //         return sum;
    //     }else if(n > maxN) {
    //         return -1;
    //     }
    //     int a = -1,b;
    //     int temp;
    //     if(s!=2){
    //         temp = memo[0][n];
    //         a = (temp == 0)?upStair(memo, arr, sum+arr[n], s+1, n+1, maxN):temp;
    //         if(a != -1){
    //             memo[0][n] = Math.max(a, memo[0][n]);
    //         }
    //     }
    //     temp = memo[1][n];
    //     b = (temp == 0)?upStair(memo, arr,sum+arr[n], 1, n+2, maxN):temp;
    //     if(b != -1){
    //         memo[1][n] = Math.max(b, memo[1][n]);
    //     }
    //     return Math.max(a, b);
    // }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n+1];
        for(int i = 1;i<n+1;i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        int[] stair = new int[n+1];
        stair[1] = arr[1];
        if(n > 1){
            stair[2] = arr[2]+arr[1];
            for(int i = 3; i<n+1;i++){
                stair[i] = Math.max(arr[i]+stair[i-2], arr[i]+arr[i-1]+stair[i-3]);
            }
        }
        System.out.println(stair[n]);
    }
}
