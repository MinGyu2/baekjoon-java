package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P10809 {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        char[] s = reader.readLine().toCharArray();
        int[] alphabet = new int[26];
        Arrays.fill(alphabet, -1);

        for(int i = 0; i<s.length;i++){
            if(alphabet[s[i]-97] == -1){
                alphabet[s[i]-97] = i;
            }
        }
        System.out.println(Arrays.toString(alphabet).replaceAll("\\[|,|\\]", ""));
    }
}
