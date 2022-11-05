package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class P10816 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Map<Integer,Integer> map = new HashMap<>();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int i;
        while(n-->0){
            i = Integer.parseInt(st.nextToken());
            if(map.containsKey(i)){
                map.put(i, map.get(i)+1);
                map.putIfAbsent(null, null);
            }else{
                map.put(i,1);
            }
        }
        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine()," ");
        StringBuilder sb = new StringBuilder();
        while(m-->0){
            i = Integer.parseInt(st.nextToken());
            sb.append(map.getOrDefault(i, 0)).append(" ");
        }
        System.out.println(sb);
    }
}
