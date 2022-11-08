package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P2004 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int nSm = n-m; // n - m 값 저장
        System.out.println(Math.min(getCountNumber(n,5)-getCountNumber(m, 5)-getCountNumber(nSm, 5),getCountNumber(n,2)-getCountNumber(m, 2)-getCountNumber(nSm, 2)));
    }
    static int getCountNumber(int a, final int num){
        int cnt = 0;
        while(a/num != 0){
            cnt += a/num;
            a /=num;
        }
        return cnt;
    }
}
