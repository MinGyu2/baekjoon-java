package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P1966 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        int[] arr = new int[10000];
        int[] order = new int[100];
        StringBuilder sb = new StringBuilder();
        while(t-->0){
            for(int i = 0;i<100;i++){
                order[i] = 0;
            }
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            for(int i = 0;i<n;i++){
                arr[i] = Integer.parseInt(st.nextToken());
                order[i] = arr[i];
            }
            Arrays.sort(order);
            // 마킹하기 몇번째로 출력 되는지 확인 하기 위한것
            // 중요도 1 이상 9 이하
            arr[m] += 10;
            
            int oI = 99; // 가장 큰게 뒤에 있음
            int s = 0;
            int l = n-1;
            int printCnt = 0;
            while(true){
                if(arr[s]%10 == order[oI]){ // poll (내보내기)
                    printCnt++;
                    if(arr[s] > 10){
                        sb.append(printCnt).append('\n');
                        break;
                    }
                    s++;
                    oI--;
                }else{ // 뒤로 보내기
                    arr[++l] = arr[s++];
                }
            }
        }
        System.out.print(sb);
    }
}
