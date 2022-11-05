package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P3009 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // byte[] arrX = new byte[1001];
        // byte[] arrY = new byte[1001];
        // for(int i=0;i<3;i++){
        //     st = new StringTokenizer(br.readLine(), " ");
        //     arrX[Integer.parseInt(st.nextToken())]++;
        //     arrY[Integer.parseInt(st.nextToken())]++;
        // }
        // int x=0,y=0;
        // for(int i=1;i<1001;i++){
        //     if(arrX[i] == 1) { x = i;}
        //     if(arrY[i] == 1) { y = i;}
        // }
        // System.out.println(x+" "+y);
        
        int x=0,y=0;
        for(int i=0;i<3;i++){
            st = new StringTokenizer(br.readLine(), " ");
            x ^=Integer.parseInt(st.nextToken());
            y ^=Integer.parseInt(st.nextToken());
        }
        System.out.println(x+" "+y);
        
    }
}
