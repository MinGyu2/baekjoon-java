package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1018 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        final int n = Integer.parseInt(st.nextToken());
        final int m = Integer.parseInt(st.nextToken());
        // 0. 입력
        char[][] arr = new char[n][];
        for(int i=0; i<n;i++){
            arr[i] = br.readLine().toCharArray();
        }
        // 1. WBWBWBWB 시작 white
        char[][] white = {{'W','B','W','B','W','B','W','B'},{'B','W','B','W','B','W','B','W'},{'W','B','W','B','W','B','W','B'},{'B','W','B','W','B','W','B','W'},{'W','B','W','B','W','B','W','B'},{'B','W','B','W','B','W','B','W'},{'W','B','W','B','W','B','W','B'},{'B','W','B','W','B','W','B','W'}};
        // 2. BWBWBWBW 시작 black
        char[][] black = {{'B','W','B','W','B','W','B','W'},{'W','B','W','B','W','B','W','B'},{'B','W','B','W','B','W','B','W'},{'W','B','W','B','W','B','W','B'},{'B','W','B','W','B','W','B','W'},{'W','B','W','B','W','B','W','B'},{'B','W','B','W','B','W','B','W'},{'W','B','W','B','W','B','W','B'}};

        int temp;
        int min = 65;
        for(int i = 0;i< n-8+1;i++){
            for(int j = 0;j<m-8+1;j++){
                temp = changeNumber(arr, i, j, white);
                if(temp < min) { min = temp; }
                temp = changeNumber(arr, i, j, black);
                if(temp < min) { min = temp; }
            }
        }
        // 출력
        System.out.println(min);
    }
    static int changeNumber(char[][] board,int startI, int startJ, char[][] cmp){
        int cnt = 0;
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                if(board[startI+i][startJ+j] != cmp[i][j]) { cnt++; }
            }
        }
        return cnt;
    }
}
