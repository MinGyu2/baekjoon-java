package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P2740 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] arr1 = new int[n][]; // nxm 배열
        for(int i = 0;i<n;i++){
            arr1[i] = Arrays.stream(br.readLine().split(" ")).mapToInt((s)-> Integer.parseInt(s)).toArray();
        }

        st = new StringTokenizer(br.readLine());
        st.nextToken();
        int k = Integer.parseInt(st.nextToken());
        int[][] arr2 = new int[m][];
        for(int i = 0; i<m;i++){
            arr2[i] = Arrays.stream(br.readLine().split(" ")).mapToInt((s)-> Integer.parseInt(s)).toArray();
        }

        int[][] arr3 = new int[n][k];
        for(int j = 0;j<n;j++){
            for(int i = 0;i<k;i++){
                int temp = 0;
                for(int z = 0;z<m;z++){
                    temp += arr1[j][z] * arr2[z][i];
                }
                arr3[j][i] = temp;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int[] a:arr3){
            sb.append(Arrays.toString(a).replaceAll("\\[|\\]|,", "")).append('\n');
        }
        System.out.print(sb);
    }
}
