package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1874 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        int[] stack = new int[100001];
        int i = 1;
        int cnt = 1;
        out:
        while(n-->0){
            int a = Integer.parseInt(br.readLine());
            while(true){
                if(stack[i-1] == a){ // pop
                    i--;
                    sb.append('-').append('\n');
                    break;
                }else if(stack[i-1] > a){
                    sb = new StringBuilder();
                    sb.append("NO").append('\n');
                    break out;
                }else{ // push
                    stack[i++] = cnt++;
                    sb.append('+').append('\n');
                }
            }
        }
        System.out.print(sb);
    }
}
