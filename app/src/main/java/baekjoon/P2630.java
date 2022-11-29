package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P2630 {
    static int blueTotal = 0;
    static int whiteTotal = 0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][];
        for(int i = 0;i<n;i++){
            arr[i] = Arrays.stream(br.readLine().split(" ")).mapToInt((s)->Integer.parseInt(s)).toArray();
        }
        
        int temp = recursion(arr, n, 0, 0);
        if(temp == 1){ blueTotal++; }else if(temp == 0){ whiteTotal++; }
        System.out.println(whiteTotal);
        System.out.println(blueTotal);
    }
    // return 1 이면 전체 블럭 다 파란색으로 칠해져있음
    // return 0 이면 전체 블럭 다 하얀색으로 칠해져있음
    // return 2 이면 색이 섞여서 칠해져 있음
    static int recursion(int[][] arr, int n, int x, int y){
        if(n==1){
            return arr[y][x];
        }else{
            int nextN = n/2;
            int blue = 0;
            int white = 0;
            int temp;
            temp = recursion(arr, nextN, x, y);
            if(temp == 1){ blue++; }else if(temp == 0){ white++; }
            temp = recursion(arr, nextN, x+nextN, y);
            if(temp == 1){ blue++; }else if(temp == 0){ white++; }
            temp = recursion(arr, nextN, x, y+nextN);
            if(temp == 1){ blue++; }else if(temp == 0){ white++; }
            temp = recursion(arr, nextN, x+nextN, y+nextN);
            if(temp == 1){ blue++; }else if(temp == 0){ white++; }

            if(white == 4){
                return 0;
            }else if(blue == 4){
                return 1;
            }else{
                blueTotal += blue;
                whiteTotal += white;
                return 2;
            }
        }
    }
}