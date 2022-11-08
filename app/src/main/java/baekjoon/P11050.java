package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P11050 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        System.out.println(C(n,k)%10007);
    }
    static int C(final int a, final int b){
        int temp = 1;
        for(int i=0; i<b; i++){
            temp = temp*(a-i) % 10007;
        }
        int p = 1;
        for(int i=1;i<b+1;i++){
            p = p*i % 10007;
        }
        while(temp%p != 0){
            temp += 10007;
        }
        return temp/p;
    }
}
