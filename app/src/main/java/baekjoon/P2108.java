package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P2108 {
    public static void main(String[] args) throws IOException{
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int n = Integer.parseInt(br.readLine()); // 무조건 홀수
        int sum = 0;
        int max = -4000;
        int min = 4000;

        final int[] arr = new int[8001];
        int freqV = 0;
        int freqN = -1;
        for(int i=0; i<n;i++){
            int in = Integer.parseInt(br.readLine());
            sum+=in;
            if(in > max){
                max = in;
            }
            if(in < min){
                min = in;
            }
            arr[in+4000]++;
            if(arr[in+4000] > freqN){
                freqN = arr[in+4000];
                freqV = in;
            }
        }
        // 산술평균
        System.out.println(Math.round((double)sum/(double)n));
        // 중앙값
        int cnt = 0;
        for(int i=0;i<8001;i++){
            cnt+=arr[i];
            if(cnt >= n/2+1){
                System.out.println(i-4000);
                break;
            }
        }
        // 최빈값
        int fff= -1;
        int ttt= -1;
        for(int i=0;i<8001;i++){
            if(arr[i] == freqN){
                if(fff == -1){
                    fff = i;
                }else{
                    ttt = i;
                    break;
                }
            }
        }
        System.out.println((ttt == -1)?fff-4000:ttt-4000);
        
        // 범위
        System.out.println(max-min);
    }
}
