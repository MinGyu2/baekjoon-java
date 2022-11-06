package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P2609 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        final int a = Integer.parseInt(st.nextToken());
        final int b = Integer.parseInt(st.nextToken());
        final int gcd = gcd(a,b);
        // lcm 최소 공배수
        final int lcm = a*b/gcd;
        System.out.println(gcd+"\n"+lcm);
    }
    static int gcd(final int a,final int b){
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
