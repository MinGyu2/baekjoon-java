package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P4949 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] stack = new int[102];
        StringBuilder sb = new StringBuilder();
        for(;;){
            int i = 0;
            char[] arr = br.readLine().toCharArray();
            int temp;
            if(arr[0] == '.'){ break; }
            for(int c:arr){
                if(c == '(' || c == '['){ // push
                    stack[i++] = c;
                }else if(c == ')'){ // pop
                    if(--i < 0 ){
                        break;
                    }
                    temp = stack[i];
                    if(temp != '('){
                        i++;
                        break;
                    }
                }else if( c == ']'){
                    if(--i < 0 ){
                        break;
                    }
                    temp = stack[i];
                    if(temp != '['){
                        i++;
                        break;
                    }
                }
            }
            sb.append((i==0)?"yes" : "no").append('\n');
        }
        System.out.print(sb);
    }
}
