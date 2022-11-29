package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1992 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        char[][] arr = new char[n][];
        for(int i = 0;i<n;i++){
            arr[i] = br.readLine().toCharArray();
        }
        Pair p = recursion(arr, n, 0, 0);
        System.out.println(p.getS());
    }
    static Pair recursion(char[][] arr, int n, int x, int y){
        if(n == 1){
            return new Pair(arr[y][x]-'0', String.valueOf(arr[y][x]));
        }else{
            int nextN = n/2;
            int oneCnt = 0;
            int zeroCnt = 0;
            Pair a = recursion(arr, nextN, x, y);
            if(a.getI() == 1){oneCnt++;}else if(a.getI() == 0) {zeroCnt++;}
            Pair b = recursion(arr, nextN, x+nextN, y);
            if(b.getI() == 1){oneCnt++;}else if(b.getI() == 0) {zeroCnt++;}
            Pair c = recursion(arr, nextN, x, y+nextN);
            if(c.getI() == 1){oneCnt++;}else if(c.getI() == 0) {zeroCnt++;}
            Pair d = recursion(arr, nextN, x+nextN, y+nextN);
            if(d.getI() == 1){oneCnt++;}else if(d.getI() == 0) {zeroCnt++;}
            
            if(oneCnt == 4){
                return new Pair(1,"1");
            }else if(zeroCnt == 4){
                return new Pair(0,"0");
            }else{
                return new Pair(2,String.format("(%s%s%s%s)", a.getS(), b.getS(),c.getS(),d.getS()));
            }
        }
    }
}
class Pair{
    private int i;
    private String s;
    public Pair(int i, String s){
        this.i = i;
        this.s = s;
    }
    public int getI(){ return i; }
    public String getS(){ return s; }
}