package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P9935 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] arr = br.readLine().toCharArray();
        char[] cmp = br.readLine().toCharArray(); // 비교용
        final int cmpLen = cmp.length;
        char[] ans = new char[arr.length+1];
        int i = 0;
        for(char c:arr){
            ans[i++] = c;
            if(i >= cmpLen){
                int j = 0;
                for(int k = cmpLen-1;k>-1;k--){
                    if(ans[i-j-1] != cmp[k]){
                        j = 0;
                        break;
                    }else{
                        j++;
                    }
                }
                if(j != 0){
                    i = i-cmpLen;
                }
            }
        }
        String s =(i == 0)?"FRULA":String.valueOf(ans).substring(0, i);
        System.out.println(s);
    }
}
