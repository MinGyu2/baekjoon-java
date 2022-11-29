package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1629 {
    public static void main(String[] args) throws IOException{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        long c = Integer.parseInt(st.nextToken());

        int[] cp = new int[31];
        cp[0] = 1;
        for(int i = 1;i<31;i++){
            cp[i] = cp[i-1]*2;
        }
        long[] squ = new long[31];
        squ[0] = a%c;
        for(int i = 1;i<31;i++){
            squ[i] = (squ[i-1]*squ[i-1])%c;
        }
        long answer = 1;
        // 정수 n = 2**a + 2**b+ .. 이런 형태로 표현 가능
        for(int i = 30;i>-1;i--){
            if(cp[i] <= b){
                b -= cp[i];
                answer = (squ[i]*answer)%c;
            }
        }
        System.out.println(answer);
    }
}
