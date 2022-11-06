package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1002 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while(t-- > 0){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int r1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int r2 = Integer.parseInt(st.nextToken());
            int distS = (x1-x2)*(x1-x2) + (y1-y2)*(y1-y2);
            // int temp = (r1+r2)*(r1+r2);
            // int maxR = Math.max(r1, r2);
            // int temp2 = maxR-Math.min(r1, r2);
            // temp2 *=temp2;
            // maxR *=maxR;
            // if(x1 == x2 && y1 == y2 && r1 == r2){
            //     // 무한대 -1
            //     // 두 점이 같고 r1 r2 가 같을 때
            //     sb.append(-1);
            // }else if(temp == distS ||  temp2 == distS){ 
            //     // 1 일 때 1
            //     // r1 + r2 == 두 점 사이 거리 or min(r1, r2) + 두 점 사이 거리 == max(r1,r2)
            //     sb.append(1);
            // }else if(maxR > distS){
            //     if(temp2 < distS){
            //         sb.append(2);
            //     }else{
            //         sb.append(0);
            //     }
            // }else if(temp > distS){
            //     sb.append(2);
            // }else{
            //     sb.append(0);
            // }
            if(x1 == x2 && y1 == y2 && r1 == r2){
                sb.append(-1);
            }else if(x1 == x2 && y1 == y2 || distS < (r1 - r2)*(r1-r2) || distS > (r1+r2)*(r1+r2)){
                sb.append(0);
            }else if(distS == (r1 - r2)*(r1-r2) || distS == (r1+r2)*(r1+r2)){
                sb.append(1);
            }else{
                sb.append(2);
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }
}
