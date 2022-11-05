package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P1181 {
    static class newString {

    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int n = Integer.parseInt(br.readLine());
        String[] arr = new String[n];
        for(int i = 0; i<n;i++){
            arr[i] = br.readLine();
        }
        Arrays.sort(arr, (o1, o2) -> {
            if(o1.length() == o2.length()){
                return o1.compareTo(o2);
            }
            return o1.length() - o2.length();
        });
        String pre = "";
        StringBuilder sb = new StringBuilder();
        for(String a:arr){
            if(a.compareTo(pre) != 0){ // 두 단어 다름 
                sb.append(a).append("\n");
                pre = a;
            }
        }
        // System.out.println(Arrays.toString(Arrays.stream(arr).distinct().toArray()).replaceAll("\\[|\\]|,", "").replaceAll(" ", "\n"));
        System.out.println(sb);
    }
}
