package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P10757 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        char[] a = st.nextToken().toCharArray();
        char[] b = st.nextToken().toCharArray();

        int alen = a.length-1;
        int blen = b.length-1;

        char[] c = new char[Math.max(alen, blen) + 1];
        int clen = c.length-1;
        
        int up = 0;
        while(clen > -1){
            // a[alen]-48;
            int x = (alen < 0)? 0:a[alen]-48;
            int y = (blen < 0)? 0:b[blen]-48;

            int s = x+y+up;
            up = (s/10);
            c[clen--] = (char)((s%10)+48);
            alen--;
            blen--;
        }
        if(up != 0){
            System.out.print(up);
        }
        System.out.println(new String(c));
    }
}
