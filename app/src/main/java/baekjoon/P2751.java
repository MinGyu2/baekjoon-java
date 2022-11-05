package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P2751 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        final int[] arr = new int[n];

        while(--n>-1){
            arr[n] = Integer.parseInt(br.readLine());
        }
        // mergeSort(arr);
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr).replaceAll("\\[|\\]|,", "").replaceAll(" ","\n"));
    }
    static void mergeSort(int[] arr){
        partition(arr, 0, arr.length-1);
    }
    static void merge(final int[] arr,final int start ,final int end){
        final int[] tempArr = new int[end-start +1];
        final int mid = (start + end)/2;
        // start ~ mid , mid+1 ~ end
        int f = start; // start ~ mid
        int t = mid+1; // mid+1 ~ end

        // 임시 저장 배열에 넣기
        for(int i = 0;i < end - start + 1; i++){
            if(f > mid){ // start ~ mid 범위 배열은 tempArr 에 모두 들어감. 따라서 나머지 mid+1 ~ end 범위 배열을 모두 tempArr에 넣어준다.
                tempArr[i] = arr[t++];
            }else if(t > end){ // mid+1 ~ end 범위 배열은 tempArr 에 모두 들어감. 따라서 나머지 start ~ mid 범위 배열을 모두 tempArr에 넣어준다.
                tempArr[i] = arr[f++];
            }else{
                tempArr[i] = (arr[f] < arr[t])? arr[f++]: arr[t++];
            }
        }
        
        // 실제 배열에 적용
        for(int i=0; i< tempArr.length;i++){
            arr[i+start] = tempArr[i];
        }
    }
    static void partition(final int[] arr ,final int start ,final int end){ // end 는 arr에 포함
        if(start < end){ // start 와 end 가 같으면 한 개가 남을 때 까지 쪼개진 것 이다.
            int mid = (start + end)/2;
            partition(arr ,start, mid); // 쪼개기
            partition(arr, mid+1, end); // 쪼개기
            merge(arr, start, end); // 합치기
        }
    }
}
