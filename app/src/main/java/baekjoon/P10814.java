package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P10814 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        Object[][] obArr = new Object[n][2];
        for(int i = 0;i<n;i++){
            st = new StringTokenizer(br.readLine()," ");
            obArr[i][0] = Integer.parseInt(st.nextToken());
            obArr[i][1] = st.nextToken();
        }

        // 정렬
        Arrays.sort(obArr,(o1, o2) -> {
            if((int)o1[0] == (int)o2[0]){
                return 0;
            }
            return (int)o1[0] - (int)o2[0];
        });
        StringBuilder sb = new StringBuilder();
        for(Object[] o:obArr){
            sb.append((int)o[0]).append(" ").append((String)o[1]).append("\n");
        }
        System.out.println(sb);
    }
}
