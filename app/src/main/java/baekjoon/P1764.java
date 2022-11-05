package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class P1764 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        final Set<String> noHear = new HashSet<>();
        final Set<String> noWatch = new HashSet<>();
        while(n-->0){
            noHear.add(br.readLine());
        }
        while(m-->0){
            noWatch.add(br.readLine());
        }
        noHear.retainAll(noWatch);
        Object[] arr = noHear.stream().sorted().toArray();
        System.out.println(arr.length);
        for(Object a:arr){
            System.out.println((String)a);
        }
    }
}
