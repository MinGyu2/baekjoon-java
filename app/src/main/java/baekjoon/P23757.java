package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class P23757 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        final int n = Integer.parseInt(st.nextToken()); // 선물 상자의 수
        final int m = Integer.parseInt(st.nextToken()); // 아이들의 수
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        st = new StringTokenizer(br.readLine());
        for(int i = 0;i<n;i++){
            queue.add(Integer.parseInt(st.nextToken()));
        }
        st = new StringTokenizer(br.readLine());
        int i, temp;
        int ans = 1;
        while(st.hasMoreTokens()){
            i = Integer.parseInt(st.nextToken());
            temp = queue.poll(); // logN
            temp -= i;
            if(temp < 0){
                ans = 0;
            }
            queue.add(temp); // logN
        }
        System.out.println(ans);
    }
}
