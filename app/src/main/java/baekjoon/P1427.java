package baekjoon;

import java.io.IOException;

public class P1427 {
    public static void main(String[] args) throws IOException{
        int i;
        int[] arr = new int[10];
        while(!((i = System.in.read()) == '\r' || i == '\n')){
            arr[i-48]++;
        }
        StringBuilder sb = new StringBuilder();
        for(int x = 9; x>-1;x--){
            while(arr[x]-- > 0){
                sb.append(x);
            }
        }
        System.out.println(sb);
    }
}
