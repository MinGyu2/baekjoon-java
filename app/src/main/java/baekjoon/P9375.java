package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class P9375 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while(t-->0){
            HashMap<String,Integer> set = new HashMap<>();
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st;
            String s;
            while(n-->0){
                st = new StringTokenizer(br.readLine()," ");
                st.nextToken();
                s = st.nextToken();
                set.put(s,set.getOrDefault(s, 0)+1);
            }
            int mul = 1;
            for(int a:set.values()){
                mul *= a+1;
            }
            sb.append(mul-1).append("\n");
        }
        System.out.println(sb);
    }
}
