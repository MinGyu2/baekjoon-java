package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P25501 {
    static int cnt = 0;
    public static void main(String[] args) throws IOException{
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while(n-->0){
            cnt = 0;
            sb.append(isPalindrome(br.readLine().toCharArray())).append(" ").append(cnt).append("\n");
        }
        System.out.println(sb);
    }
    static int recursion(char[] s, int l, int r){
        cnt++;
        if(l >= r){// 회기 끝! 팰린드롬 임
            return 1;
        }else if(s[l] != s[r]){ // 팰린드롬 아님
            return 0;
        }else {
            return recursion(s, l+1, r-1);
        }
    }
    static int isPalindrome(char[] s){ // 1 ok , 0 no
        return recursion(s, 0, s.length-1);
    }
}
