package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1934 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while(t-->0){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            sb.append(lcm(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()))).append("\n");
        }
        System.out.println(sb);
    }
    static int lcm(final int a, final int b){
        return a*b/gcd(a, b);
    }
    static int gcd(final int a, final int b){
        int i = a;
        int j = b;
        int temp = -1;
        while(j != 0){
            temp = i%j;
            i = j;
            j = temp;
        }
        return i;
    }
}
