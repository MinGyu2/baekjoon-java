package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P14888 {
    static int max = -1000000001;
    static int min = 1000000001;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int[] arithmeticOperation = new int[4]; // 0:+ , 1:-, 2:*, 3:
        int[] arOpRemember = new int[n-1];
        st = new StringTokenizer(br.readLine()," ");
        for(int i=0;i<4;i++){
            arithmeticOperation[i] = Integer.parseInt(st.nextToken());
        }

        backTracking(arr, arithmeticOperation, arOpRemember, 0, n);
        System.out.println(max);
        System.out.println(min);
    }
    static void backTracking(final int[] arr, final int[] arithmeticOperation,final int[] arOpRemember, int n, final int finalN){
        if(n == finalN - 1){
            int[] aClone = arr.clone();
            int[] aOp = arOpRemember.clone(); 
            arithmeticOperation(aClone,aOp);
            int temp = aClone[aClone.length-1];
            if(max < temp) {
                max = temp;
            }
            if(min > temp){
                min = temp;
            }
            return;
        }
        for(int i=0;i<4;i++){
            if(arithmeticOperation[i] > 0){
                arithmeticOperation[i]--;
                arOpRemember[n] = i;
                backTracking(arr, arithmeticOperation, arOpRemember, n+1, finalN);
                arithmeticOperation[i]++;
                arOpRemember[n] = -1;
            }
        }
    }
    static void arithmeticOperation(final int[] arr,final int[] arOpRemember){
        for(int i = 0; i < arOpRemember.length; i++){
            if(arOpRemember[i] == 0){
                arr[i+1] = arr[i]+arr[i+1];
                arOpRemember[i] = 0;
                arr[i] = 0;
            }else if(arOpRemember[i] == 1){
                arr[i+1] = arr[i]-arr[i+1];
                arOpRemember[i] = 0;
                arr[i] = 0;
            }else if(arOpRemember[i] == 2){
                arr[i+1] = arr[i]*arr[i+1];
                arOpRemember[i] = 0;
                arr[i] = 0;
            }else if(arOpRemember[i] == 3){
                arr[i+1] = arr[i]/arr[i+1];
                arOpRemember[i] = 0;
                arr[i] = 0;
            }
        }
    }
}
