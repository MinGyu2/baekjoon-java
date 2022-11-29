package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P1780 {
    static int[] total = new int[4];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][];
        for(int i = 0;i<n;i++){
            arr[i] = Arrays.stream(br.readLine().split(" ")).mapToInt((s)->(Integer.parseInt(s)+1)).toArray();
        }
        total[recursion(arr, n, 0, 0)]++;
        System.out.println(total[0]);
        System.out.println(total[1]);
        System.out.println(total[2]);
    }
    // -1 0 1 -> 0 1 2  ( 1씩 더하기 )
    static int recursion(int[][] arr, int n, int x, int y){
        if(n == 1){
            return arr[x][y];
        }else{
            int nextN = n/3;
            int[] cnt = new int[4];
            for(int j = 0;j<3;j++){
                for(int i = 0;i<3;i++){
                    cnt[recursion(arr, nextN, x+nextN*i, y+nextN*j)]++;
                }
            }
            for(int i = 0;i<3;i++){
                if(cnt[i] == 9){
                    return i;
                }
            }
            for(int i = 0;i<3;i++){
                total[i] += cnt[i];
            }
            return 3;
        }
    }
}
