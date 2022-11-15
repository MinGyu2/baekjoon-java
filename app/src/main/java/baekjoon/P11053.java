package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P11053 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int temp = 0;
        int temp2 = 0;
        int[] arr = new int[1001];
        while(n-->0){
            temp = Integer.parseInt(st.nextToken());
            temp2 = arr[temp-1] + 1;
            for(int i = temp; i<1001;i++){
                if(arr[i] < temp2){
                    arr[i] = temp2;
                }else{
                    break;
                }
            }
        }
        System.out.println(arr[1000]);
    }
}
