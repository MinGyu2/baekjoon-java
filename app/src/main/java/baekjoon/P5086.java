package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P5086 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s;
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        while(!(s = br.readLine()).equals("0 0")){
            st = new StringTokenizer(s," ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if(a>b && a%b == 0){
                sb.append("multiple");
            }else if(a<b && b%a == 0){
                sb.append("factor");
            }else {
                sb.append("neither");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
