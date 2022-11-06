package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1004 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while(t-->0){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(br.readLine());
            // int[][] isIn = new int[n][2];
            int sum = 0;
            int temp;
            while(n-->0){
                temp = 0;
                st = new StringTokenizer(br.readLine()," ");
                int pX = Integer.parseInt(st.nextToken());
                int pY = Integer.parseInt(st.nextToken());
                int pR = Integer.parseInt(st.nextToken());
                int dist = (x1-pX)*(x1-pX) + (y1-pY)*(y1-pY);
                if(dist < pR*pR){
                    // isIn[n][0] = 1; // 행성 안에 속함
                    temp = 1;
                }
                dist = (x2-pX)*(x2-pX) + (y2-pY)*(y2-pY);
                if(dist < pR*pR){
                    // isIn[n][1] = 1; // 행성 안에 속함
                    temp ^=1;
                }
                sum += temp;
            }
            // for(int[] i:isIn){
            //     sum += i[0]^i[1]; // 같이 속하면 0으로 만듬
            // }
            sb.append(sum).append('\n');
        }
        System.out.println(sb);
    }
}
