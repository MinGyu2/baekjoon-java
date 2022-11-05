package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P1673 {
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        
        int[] alphabet = new int[26];
        int word = 0;
        while(n-->0){
            Arrays.fill(alphabet, -1);
            char[] a = bf.readLine().toCharArray();
            char f = a[0];
            boolean b = true;
            for(char ch : a){
                if(f != ch){
                    if(alphabet[f-97] == 0){// 이미 앞에 존재 함
                        b = false;
                        break;
                    }else{// 한번만 반복됨
                        alphabet[f-97] = 0;
                    }
                    f = ch;
                }
            }
            if(b && alphabet[f-97] != 0){
                word++;
            }
        }
        System.out.println(word);
    }
}
