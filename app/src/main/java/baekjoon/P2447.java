package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P2447 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        char[][] cArr = star(n);
        for(char[] c:cArr){
            sb.append(new String(c)).append('\n');
        }
        System.out.println(sb);
    }
    static char[][] star(int n){
        if(n == 3){
            char[][] arr = {{'*','*','*'},{'*',' ','*'},{'*','*','*'}};
            return arr;
        }else{
            char[][] preArr = star(n/3); // 전 별
            char[][] arr = new char[n][n]; // 새로운 것
            for(int i = 0; i< 3;i++){
                for(int j = 0; j< 3;j++){
                    fillStar(arr, preArr, i, j);
                }
            }
            return arr;
        }
    }
    static void fillStar(char[][] arr, char[][] preArr, final int i, final int j){
        int len = preArr.length;
        if(i == 1 && j == 1){ // 중앙은 빈 공간으로 채우기
            for(int ii = 0; ii < len; ii++){
                for(int jj = 0; jj < len; jj++){
                    arr[ii + i*len][jj+j*len] = ' ';
                }
            }
        }else {
            for(int ii = 0; ii < len; ii++){
                for(int jj = 0; jj < len; jj++){
                    arr[ii + i*len][jj+j*len] = preArr[ii][jj]; // 나머지는 이전 배열을 이용하여 채우기
                }
            }
        }
    }

    // static StringBuilder[] star2(int n){
    //     if(n == 3){
    //         StringBuilder[] arr = {new StringBuilder("***"),new StringBuilder("* *"),new StringBuilder("***")};
    //         return arr;
    //     }else{
    //         StringBuilder[] preArr = star2(n/3); // 전 별
    //         StringBuilder[] arr = new StringBuilder[n]; // 새로운 것
    //         for(int i = 0; i< 3;i++){
    //             for(int j = 0; j< 3;j++){
    //                 fillStar2(arr, preArr, i, j);
    //             }
    //         }
    //         return arr;
    //     }
    // }
    // static void fillStar2(StringBuilder[] arr, StringBuilder[] preArr, final int i, final int j){
    //     int len = preArr.length;
    //     if(i == 0){
    //         for
    //     }
    //     // if(i == 1 && j == 1){ // 중앙은 빈 공간으로 채우기
    //     //     for(int ii = 0; ii < len; ii++){
    //     //         for(int jj = 0; jj < len; jj++){
    //     //             arr[ii + i*len][jj+j*len] = ' ';
    //     //         }
    //     //     }
    //     // }else {
    //     //     for(int ii = 0; ii < len; ii++){
    //     //         for(int jj = 0; jj < len; jj++){
    //     //             arr[ii + i*len][jj+j*len] = preArr[ii][jj]; // 나머지는 이전 배열을 이용하여 채우기
    //     //         }
    //     //     }
    //     // }
    // }
}
