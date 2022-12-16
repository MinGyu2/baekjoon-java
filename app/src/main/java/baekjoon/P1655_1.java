package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P1655_1 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueueMax2 pMax = new PriorityQueueMax2(n/2+1);// 4 3 2 1
        PriorityQueueMin2 pMin = new PriorityQueueMin2(n/2+1);// 4 5 6 7  이런식으로 저장한다.
        StringBuilder sb = new StringBuilder();
    }
}
class PriorityQueueMax3{
    private int index = 0;
    private int size = 0;
    private int[] arr;
    private final int min = Integer.MIN_VALUE;
    public PriorityQueueMax3(int size){
        this.size = size;
        arr = new int[size];
        for(int i = 0; i< size;i++){
            arr[i] = min;
        }
    }
    public int length(){
        return index;
    }
    public void insert(int value){
        // 1
        arr[index] = value;
        // 2
        int z = index;
        int temp;
        int chTemp;
        while(z != 0){
            temp = (z%2 == 1)?(z-1)/2:(z-2)/2;
            if(arr[temp] < arr[z]){
                chTemp = arr[z];
                arr[z] = arr[temp];
                arr[temp] = chTemp;
            }
            z = temp;
        }
        //3
        index++;
    }
    public int pull(){
        int ans = (index == 0)? min: getFirstValue();
        removeFirst();
        return ans;
    }
    public void removeFirst(){
        if(index == 0) return;
        index--;
        arr[0] = arr[index];
        arr[index] = min;
        int i = 0;
        int a1,a2;
        int b1,b2;
        while(true){
            a1 = 2*i+1;
            a2 = 2*i+2;
            b1 = (a1 > index)? min: arr[a1];
            b2 = (a2 > index)? min: arr[a2];
            if(b1 < b2 && arr[i] < b2){
                arr[a2] = arr[i];
                arr[i] = b2;
                i = a2;
            }else if(arr[i] < b1){
                arr[a1] = arr[i];
                arr[i] = b1;
                i = a1;
            }else{
                break;
            }
        }
    }
    public int getFirstValue(){
        return arr[0]; // 가장 큰값
    }
    @Override
    public String toString() {
        return Arrays.toString(arr);
    }
}

class PriorityQueueMin3{
    private int index = 0;
    private int size = 0;
    private int[] arr;
    public PriorityQueueMin3(int size){
        this.size = size;
        arr = new int[size];
        for(int i = 0; i< size;i++){
            arr[i] = Integer.MAX_VALUE;
        }
    }
    public int length(){
        return index;
    }
    public void insert(int value){
        // 1
        arr[index] = value;
        // 2
        int z = index;
        int temp;
        int chTemp;
        while(z != 0){
            temp = (z%2 == 1)?(z-1)/2:(z-2)/2;
            if(arr[temp] > arr[z]){
                chTemp = arr[z];
                arr[z] = arr[temp];
                arr[temp] = chTemp;
            }
            z = temp;
        }
        //3
        index++;
    }
    public int pull(){
        int ans = (index == 0)? 0: getFirstValue();
        removeFirst();
        return ans;
    }
    public void removeFirst(){
        if(index == 0) return;
        index--;
        arr[0] = arr[index];
        arr[index] = Integer.MAX_VALUE;
        int i = 0;
        int a1,a2;
        int b1,b2;
        while(true){
            a1 = 2*i+1;
            a2 = 2*i+2;
            b1 = (a1 > index)? Integer.MAX_VALUE: arr[a1];
            b2 = (a2 > index)? Integer.MAX_VALUE: arr[a2];
            if(b1 > b2 && arr[i] > b2){
                arr[a2] = arr[i];
                arr[i] = b2;
                i = a2;
            }else if(arr[i] > b1){
                arr[a1] = arr[i];
                arr[i] = b1;
                i = a1;
            }else{
                break;
            }
        }
    }
    public int getFirstValue(){
        return arr[0]; // 가장 작은값
    }
    @Override
    public String toString() {
        return Arrays.toString(arr);
    }
}
