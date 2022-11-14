package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1149 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int preR, preG, preB;
        int r = 0,g=0,b=0;
        preR = Integer.parseInt(st.nextToken());
        preG = Integer.parseInt(st.nextToken());
        preB = Integer.parseInt(st.nextToken());
        n--;
        while(n-->0){
            st = new StringTokenizer(br.readLine()," ");
            r = Integer.parseInt(st.nextToken()) + Math.min(preG,preB);
            g = Integer.parseInt(st.nextToken()) + Math.min(preR,preB);
            b = Integer.parseInt(st.nextToken()) + Math.min(preR,preG);
            preR = r;
            preG = g;
            preB = b;
        }
        System.out.println(Math.min(r, Math.min(g, b)));
    }
}
