package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class P1620 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        HashMap<String,Integer> map = new HashMap<>();
        String[] arr = new String[n];
        //
        int i = 0;
        String s;
        while(n-->0){
            s = br.readLine();
            map.put(s, i+1);
            arr[i++] = s;
        }
        // 출력
        StringBuilder sb = new StringBuilder();
        while(m-- >0){
            s = br.readLine();
            if(map.containsKey(s)){
                sb.append(map.get(s)).append('\n');
            }else{
                sb.append(arr[Integer.parseInt(s)-1]).append('\n');
            }
        }
        System.out.println(sb);
    }
}
