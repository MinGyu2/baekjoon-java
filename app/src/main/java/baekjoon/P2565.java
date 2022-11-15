package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P2565 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][2];
        StringTokenizer st;
        // 입력
        for(int i = 0;i<n;i++){
            st = new StringTokenizer(br.readLine()," ");
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        // 정렬
        Arrays.sort(arr, (a,b)-> {
            return a[0] - b[0];
        });

        // 증가하는 부분 수열 찾기
        int[] f = new int[n];
        for(int i = 0;i<n;i++){
            f[i] = Integer.MAX_VALUE;
        }
        int fmax = 0;
        for(int k = 0;k<n;k++){
            for(int i = 0;i<n;i++){
                if(f[i] >= arr[k][1]){
                    f[i] = arr[k][1];
                    if(fmax < i+1){
                        fmax = i+1;
                    }
                    break;
                }
            }
        }
        System.out.println(n-fmax);
    }
}
