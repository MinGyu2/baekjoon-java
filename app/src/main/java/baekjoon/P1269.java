package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class P1269 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int answer = a+b;
        st = new StringTokenizer(br.readLine()," ");
        Set<Integer> setA = new HashSet<>();
        while(a-->0){
            setA.add(Integer.parseInt(st.nextToken()));
        }
        st = new StringTokenizer(br.readLine()," ");
        Set<Integer> setB = new HashSet<>();
        while(b-->0){
            setB.add(Integer.parseInt(st.nextToken()));
        }
        // input end
        setA.retainAll(setB); // 교집합
        System.out.println(answer - setA.size()*2);
    }
}
