package baekjoon;

import java.io.IOException;

public class P11066 {
    public static void main(String[] args) throws IOException{
        // int[] arr = {40, 30, 30, 50};
        int[] arr = {1, 21, 3, 4, 5, 35, 5, 4, 3, 5, 98, 21, 14, 17, 32};
        int[] sum = new int[arr.length];
        sum[0] = arr[0];
        for(int i = 1;i<arr.length;i++){
            sum[i] = sum[i-1] + arr[i];
        }
        // PriorityQueue<Integer> queue = new PriorityQueue<>();
        // for(int a:arr){
        //     queue.add(a);
        // }
        // // queue.add(40);
        // // queue.add(30);
        // // queue.add(30);
        // // queue.add(50);

        // int sum = 0;
        // for(int i = 0;i<14;i++){
        //     int a = queue.poll();
        //     int b = queue.poll();
        //     int c = a + b;
        //     sum +=c;
        //     queue.add(c);
        // }
        // System.out.println(sum);
        // System.out.println(queue);
    }
}
