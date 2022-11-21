package baekjoon;

import java.io.IOException;

public class P1541 {
    public static void main(String[] args) throws IOException{
        int sum = 0;
        int temp = 0;
        int mul = 1;
        boolean isPlus = true;
        int ch;
        while((ch = System.in.read()) != '\r' && ch != '\n'){
            if(ch == '-' || ch == '+'){
                if(isPlus){
                    sum += temp;
                }else{
                    sum -= temp;
                }
                mul = 1;
                temp = 0;
                if(ch == '-'){
                    isPlus = false;
                }
            }else{
                temp = temp*mul + ch - '0';
                mul = 10;
            }
        }
        if(isPlus){
            sum +=temp;
        }else{
            sum -= temp;
        }
        System.out.println(sum);
    }
}
