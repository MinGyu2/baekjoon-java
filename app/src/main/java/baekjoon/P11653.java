package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P11653 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int z = (int)Math.sqrt(n) + 1;
        for(int i=2; i < z;i++){
            if(i > n) break;
            while(true){
                if(n%i == 0){
                    sb.append(i);
                    sb.append("\n");
                    n = n/i;
                }else{
                    break;
                }
            }
        }
        if(n != 1){
            sb.append(n);
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
