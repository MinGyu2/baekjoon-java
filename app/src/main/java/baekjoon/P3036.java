package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P3036 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int base = Integer.parseInt(st.nextToken());
        int z;
        int gcd;
        StringBuilder sb = new StringBuilder();
        while(--n>0){
            z = Integer.parseInt(st.nextToken());
            gcd = gcd(base, z);
            sb.append(base/gcd).append("/").append(z/gcd).append('\n');
        }
        System.out.println(sb);
    }
    static int gcd(int a, int b) {
        int temp;
        while(b > 0){
            temp = a%b;
            a = b;
            b = temp;
        }
        return a;
    }
}
