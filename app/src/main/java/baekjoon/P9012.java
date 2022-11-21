package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P9012 {
    // public static void main(String[] args) throws IOException{
    //     int t = readInt();
    //     StringBuilder sb = new StringBuilder();
    //     while(t--> 0){
    //         int ch;
    //         while((ch = System.in.read()) == '\r' || ch == '\n');
    //         int stack = 0;
    //         do{
    //             if(ch == '('){
    //                 stack++;
    //             }else{
    //                 stack--;
    //                 if(stack < 0) { break; }
    //             }
    //         }while((ch = System.in.read()) != '\r' && ch != '\n');
    //         sb.append((stack == 0)? "YES":"NO").append('\n');

    //         // 나머지 괄호 제거
    //         while((ch = System.in.read()) != '\r' && ch != '\n');
    //     }
    //     System.out.println(sb);
    // }
    // static int readInt() throws IOException{
    //     int ch;
    //     while((ch = System.in.read()) == '\r' || ch == '\n');
    //     int num = 0;
    //     do{
    //         num = num * 10 + ch - '0';
    //     }while((ch = System.in.read()) != '\r' && ch != '\n');
    //     return num;
    // }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while(t-->0){
            String s = br.readLine();
            int cnt = 0;
            for(int c:s.toCharArray()){
                if(c == '('){
                    cnt++;
                }else{
                    cnt--;
                }
                if(cnt < 0){
                    break;
                }
            }
            if(cnt == 0) {
                sb.append("YES\n");
            }else{
                sb.append("NO\n");
            }
        }
        System.out.println(sb);
    }
}
