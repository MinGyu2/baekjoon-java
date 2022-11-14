package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1932 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[2][n];
        int temp = 0;
        int select = 1;
        StringTokenizer st;
        for(int j = 1; j<n+1;j++){
            st = new StringTokenizer(br.readLine()," ");
            for(int i = 0; i<j;i++){
                temp = Integer.parseInt(st.nextToken());
                if(i == 0){
                    arr[(select+1)%2][i] = arr[select%2][i];
                }else if(i == j-1){
                    arr[(select+1)%2][i] = arr[select%2][i-1];
                }else {
                    arr[(select+1)%2][i] = Math.max(arr[select%2][i-1], arr[select%2][i]);
                }
                arr[(select+1)%2][i] += temp;
            }
            select +=1;
        }
        System.out.println(maxArr(arr[select%2]));
    }
    static int maxArr(int[] arr){
        int max = 0;
        for(int i:arr){
            if(max < i){
                max = i;
            }
        }
        return max;
    }
}
