package baekjoon;

import java.io.IOException;

public class P10773 {
    public static void main(String[] args) throws IOException{
        int n = readInt();
        int[] arr = new int[n];
        int i = 0;
        int temp;
        int sum = 0;
        while(n-- > 0){
            if((temp = readInt()) == 0){
                sum -= arr[--i];
            }else{
                arr[i++] = temp;
                sum += temp;
            }
        }
        System.out.println(sum);
    }
    static int readInt() throws IOException{
        int value = 0;
        int ch;
        while((ch = System.in.read()) == '\r' || ch == '\n');
        do{
            value = value*10 + ch-'0';
        }while((ch = System.in.read()) != '\r' && ch != '\n');
        return value;
    }
}
