package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P5430 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sbOut = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        while(t-->0){
            char[] cmd = br.readLine().toCharArray();
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine().replaceAll("\\[|\\]", ""),",");
            StringBuilder sb = new StringBuilder();
            int s = 0; // start
            int e = n-1; // end
            boolean isFront = true;

            for(char c : cmd){
                if(c == 'R'){
                    isFront = !isFront;
                }else if(isFront){
                    s++;
                }else {
                    e--;
                }
                if(e - s < -1){
                    break;
                }
            }
            if(e - s < -1){
                sb.append("error\n");
            }else if(isFront){
                for(int i = 0;i<s;i++){
                    st.nextToken();
                }
                sb.append("[");
                for(int i = 0;i<e-s+1;i++){
                    if(i != 0){
                        sb.append(",");
                    }
                    sb.append(st.nextToken());
                }
                sb.append("]\n");
            }else{
                for(int i = 0;i<s;i++){
                    st.nextToken();
                }
                for(int i = 0;i<e-s+1;i++){
                    if(i != 0){
                        sb.insert(0,",");
                    }
                    sb.insert(0,st.nextToken());
                }
                sb.append("]\n");
                sb.insert(0, "[");
            }
            sbOut.append(sb);
        }
        System.out.print(sbOut);
    }
}
