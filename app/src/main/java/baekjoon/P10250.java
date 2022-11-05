package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P10250 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int h = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            
            int d = n / h;
            int r = n % h;
            // System.out.println((r == 0)?d:d+1);
            // System.out.println((r == 0)?h:r);
            System.out.println(String.format("%d%02d", (r == 0)?h:r,(r == 0)?d:d+1));
            
        }
    }
}
