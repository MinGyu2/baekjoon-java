package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P11401 {
    static long MOD = 1000000007;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        final int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        if(n-k < k){
            k = n-k;
        }
        long numerator = 1;
        long denominator = 1;
        for(long i = 1, j = n;i<k+1;i++,j--){
            numerator = (numerator * j)%MOD;
            denominator = (denominator * i)%MOD;
        }

        // while((numerator % denominator) != 0){
        //     numerator += MOD;
        // }
        // System.out.println(numerator/denominator);
        long inv = squareMod(denominator, MOD-2,MOD);
        System.out.println((numerator*inv)%MOD);
    }
    // denominator 값 곱셈 역원 구하기
    // 페르마 소정리 이용 
    // B 는 소수이다
    // a mod B  --> a*a^-1 mod B = 1 이 되는 
    // a^-1 = a^(B-2) mod B 이다
    // 곱셈의 역원 즉 a^(B-2) 를 구하면 된다.
    // ex) 4 / 5 는 4 * 0.2 와 같다. 여기서 5 * 0.2 = 1 임으로 0.2 는 5의 곱셈의 역원 이다.
    static long squareMod(long a,long s,long mod){ // a^s % mod 
        // 2**x 값 저장
        int[] cp = new int[30];
        cp[0] = 1;
        for(int i = 1;i<30;i++){
            cp[i] = cp[i-1]*2;
        }

        // a a**2 a**4 a**8 ... a**(2**29) 까지 mod c 한 값 저장
        long[] squ = new long[30];
        squ[0] = a%mod;
        for(int i = 1;i<30;i++){
            squ[i] = (squ[i-1] * squ[i-1])%mod;
        }

        // ex) 13 = 8 + 4 + 1 과 같은 원리로  b 를 2**x 승 식으로 풀어준다. 
        // a**13 = a**8 * a**4 * a**1 과 같다. 즉 squ 에서 3 번째 , 2번째 , 0 번째 값을 꺼내서 곱하면 된다.
        long b = s;
        long answer = 1;
        for(int i = 29;i>-1;i--){
            if(b >= cp[i]){
                b -=cp[i];
                answer = (answer * squ[i])%mod;
            }
        }
        return answer;
    }
}
