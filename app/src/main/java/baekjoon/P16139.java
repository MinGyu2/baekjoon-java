package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P16139 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] s = br.readLine().toCharArray();
        int[][] arr = new int[26][s.length+1];
        for(int j = 1; j<s.length+1;j++){
            for(int i = 0;i<26;i++){
                arr[i][j] = arr[i][j-1] + ((i+'a' == s[j-1])?1:0);
            }
        }
        int q = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while(q-->0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int ch = st.nextToken().toCharArray()[0];
            int l = Integer.parseInt(st.nextToken()) + 1;
            int r = Integer.parseInt(st.nextToken()) + 1;
            sb.append(arr[ch-'a'][r] - arr[ch-'a'][l-1]).append('\n');
        }
        System.out.println(sb);
    }
}
