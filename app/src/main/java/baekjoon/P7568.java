package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P7568 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][2];
        StringTokenizer st;
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        // search
        int[] answer = new int[n];
        for(int i=0;i<n-1;i++){
            for(int j=i+1;j<n;j++){
                if(i == j) { continue; }
                if(arr[i][0] > arr[j][0] && arr[i][1] > arr[j][1]){
                    answer[j]++;
                }else if(arr[j][0] > arr[i][0] && arr[j][1] > arr[i][1]){
                    answer[i]++;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i:answer){
            sb.append(i+1).append(' ');
        }
        System.out.println(sb);
    }
}
