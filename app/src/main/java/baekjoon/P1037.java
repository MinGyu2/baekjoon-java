package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1037 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int temp = 0;
        int min = 1000001;
        int max = 1;
        while(n-->0){
            temp = Integer.parseInt(st.nextToken());
            min = (min > temp)?temp:min;
            max = (max < temp)?temp:max;
        }
        System.out.println(min*max);
    }
}
