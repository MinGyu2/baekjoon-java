package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P11729 {
    static int cnt = 0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        hanoi(sb, n, 1, 3);
        System.out.println(cnt);
        System.out.println(sb);
    }
    // 1 2 3
    // 3 0 0
    // 쌓인원판수 시작위치 도착위치
    // 1 <= start , reach <= 3
    public static void hanoi(StringBuilder sb,int n, int start, int reach){
        cnt++;
        if(n == 1){
            sb.append(start).append(' ').append(reach).append('\n');
        }else{
            // n reach 로 갈때 n-1은 start reach 아닌 나머지
            // n-1 탑이 도착해야하는곳
            int newR = restNumber(start, reach);

            // 0. 3 0 0  1->3
            hanoi(sb, n-1, start, newR); // 1. 맨 밑의 바로 위에 있는 것을 시작과 목적지가 아닌 다른곳으로 옮기기. 실행 결과 1 2 0
            sb.append(start).append(' ').append(reach).append('\n'); // 2. 맨 밑에 있는 것을 목적지로 옮기기. 실행 결과 0 2 1
            hanoi(sb, n-1, newR, reach); // 3. 1번에서 옮긴것을 다시 목적지 즉 다시 위로 쌓기.  실행 결과 0 0 3
        }
    }
    // a,b = 1 or 2 or 3 (a!=b)
    public static int restNumber(int a, int b){
        return 6-a-b;
    }
}
