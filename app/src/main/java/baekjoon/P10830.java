package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P10830 {
    static int MOD = 1000;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        long b = Long.parseLong(st.nextToken());

        int[][] arr = new int[n][];
        for(int i = 0;i<n;i++){
            arr[i] = Arrays.stream(br.readLine().split(" ")).mapToInt((s)-> Integer.parseInt(s)).toArray();
        }
        arraySqu(arr, b);
    }
    static void arraySqu(int[][] arr, long b){ // arr ^ B 값 구하기
        long[] cp = new long[37];
        cp[0] = 1;
        for(int i = 1; i<37;i++){
            cp[i] = cp[i-1]*2;
        }
        boolean[] indexs = new boolean[37];
        for(int i = 36;i>-1;i--){
            if(b >= cp[i]){
                b -= cp[i];
                indexs[i] = true;
            }
        }
        // 초기화
        int[][] answer = new int[arr.length][arr.length];
        for(int i = 0;i<answer.length;i++){
            answer[i][i] = 1;
        }
        // 제곱 구하기
        for(int i = 0;i<37;i++){
            if(indexs[i]){
                answer = arrayMul(answer, arr);
            }
            arr = arrayMul(arr, arr);
        }
        for(int[] a:answer){
            System.out.println(Arrays.toString(a).replaceAll("\\[|\\]|,", ""));
        }
    }
    // 무조건 곱할 수 있는 매개변수만 넘어온다. n x n 이다 항상
    static int[][] arrayMul(int[][] arr1, int[][] arr2){
        int n = arr1.length;
        int temp;
        int[][] answer = new int[n][n];
        for(int j = 0; j < n;j++){
            for(int i = 0;i < n;i++){
                temp = 0;
                for(int z = 0; z < n;z++){
                    temp = (temp+arr1[j][z]*arr2[z][i])%MOD;
                }
                answer[j][i] = temp;
            }
        }
        return answer;
    }
}
