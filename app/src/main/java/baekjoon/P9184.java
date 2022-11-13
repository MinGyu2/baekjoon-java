package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P9184 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s;
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int[][][] arr = wArr();
        while(!(s = br.readLine()).equals("-1 -1 -1")){
            st = new StringTokenizer(s);
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            // sb.append(w(a,b,c)).append('\n');
            sb.append(String.format("w(%d, %d, %d) = %d", a,b,c,ww(arr,a,b,c))).append('\n');
        }
        System.out.println(sb);
    }
    // static int w(int a, int b, int c){
    //     if(a <= 0 || b <= 0 || c <= 0) { return 1;}
    //     if(a > 20 || b > 20 || c > 20) {
    //         return w(20,20,20);
    //     }
    //     if(a < b && b < c) {
    //         return w(a,b,c-1) + w(a, b-1, c-1) - w(a,b-1,c);
    //     }
    //     return w(a-1, b, c) + w(a-1, b-1, c) + w(a-1, b, c-1) - w(a-1,b-1,c-1);
    // }
    static int[][][] wArr(){
        int[][][] arr = new int[21][21][21];
        for(int x = 0; x < 21;x++){
            for(int y = 0; y < 21;y++){
                for(int z = 0; z < 21;z++){
                    if(x <= 0 || y <= 0 || z <= 0) {
                        arr[x][y][z] = 1;
                    }else if(x<y && y < z){
                        arr[x][y][z] = arr[x][y][z-1] + arr[x][y-1][z-1] - arr[x][y-1][z];
                    }else {
                        arr[x][y][z] = arr[x-1][y][z] + arr[x-1][y-1][z] + arr[x-1][y][z-1] - arr[x-1][y-1][z-1];
                    }
                }
            }
        }
        return arr;
    }
    static int ww(int[][][] arr,int a, int b, int c){
        if(a <= 0 || b <= 0 || c <= 0) {
            return 1;
        }else if(a > 20 || b > 20 || c > 20){
            return arr[20][20][20];
        }else {
            return arr[a][b][c];
        }
    }
}
