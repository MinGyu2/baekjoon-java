package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P2477 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int[] direction = new int[6];
        int[] len = new int[6];
        int maxW = 0;
        int maxH = 0;
        for(int i=0;i<6;i++){
            st = new StringTokenizer(br.readLine()," ");
            direction[i] = Integer.parseInt(st.nextToken());
            len[i] = Integer.parseInt(st.nextToken());
            // 1 or 2 - 3 or 4 - 1 or 2
            if(direction[i] == 1 || direction[i] == 2){
                if(len[i] > maxW){
                    maxW = len[i];
                }
            }else if(len[i] > maxH){
                maxH = len[i];
            }
        }
        int minW = 0;
        int minH = 0;
        for(int i=0;i<6;i++){
            // 중심
            // 중심 변에 이어진 변이 가장 긴 세로를 안 가지면 파여진 가로 변 
            // 중심 변에 이어진 변이 가장 긴 가로를 안 가지면 파여진 세로 변 
            if(direction[i] == 1 || direction[i] == 2){ // 수평
                if(maxH > len[(i-1 < 0)?5:i-1] && maxH> len[(i+1>5)?0:i+1]){
                    minW = len[i];
                }
            }else{ // 수직
                if(maxW > len[(i-1 < 0)?5:i-1] && maxW> len[(i+1>5)?0:i+1]){
                    minH = len[i];
                }
            }
        }
        System.out.println((maxW*maxH - minW*minH)*k);
    }
}
