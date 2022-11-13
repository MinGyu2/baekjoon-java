package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1912 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int max = -1001;
        int sum = 0;
        int temp = 0;
        for(int i=0;i<n;i++){
            temp = Integer.parseInt(st.nextToken());
            if(temp > max){
                max = temp;
            }
            sum += temp;
            if(sum < 0){
                sum = 0;
            }else if(sum > max){
                max = sum;
            }
        }
        System.out.println(max);
    }
}
