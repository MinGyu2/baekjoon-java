package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1021 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        for(int i =1;i<n+1;i++){
            arr[i-1] = i;
        }
        
        int i = 0;
        int size = arr.length;
        int sum = 0;
        st = new StringTokenizer(br.readLine());
        while(m-->0){
            int temp = Integer.parseInt(st.nextToken());
            int cnt = 0;
            while(true){
                if(arr[i] == temp){
                    arr[i] = 0;
                    i = (i+1)%n;
                    size -= 1;
                    break;
                }if(arr[i] != 0){
                    cnt++;
                }
                i = (i+1)%n;
            }
            // System.out.println((size+1)+" "+cnt);
            sum += Math.min(cnt, size+1 - cnt);
        }
        // System.out.println(Arrays.toString(arr));
        System.out.println(sum);
    }
}
