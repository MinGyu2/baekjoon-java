package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class P11478 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Set<String> set = new HashSet<>();
        String s = br.readLine();
        final int len = s.length();
        // int i = 0;
        // while(++i < len+1){
        //     for(int j = 0;j<len-i+1;j++){
        //         set.add(s.substring(j, j+i));
        //     }
        // }
        // System.out.println(set.size());
        // System.out.println(s.substring(1));
        int cnt = 0;
        for(int i=0; i<len;i++){
            for(int j=i; j<len;j++){
                String v1 = s.substring(i+1);
                String v2 = s.substring(i, j+1);
                if(! v1.contains(v2)) cnt++;
            }
        }
        System.out.println(cnt);
    }
}
