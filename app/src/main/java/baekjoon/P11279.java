package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P11279 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueueAbsolute p = new PriorityQueueAbsolute(n);
        StringBuilder sb = new StringBuilder();
        while(n-->0){
            int temp = Integer.parseInt(br.readLine());
            if(temp == 0){
                sb.append(p.pull()).append('\n');
            }else{
                p.insert(temp);
            }
        }
        System.out.print(sb);
    }
}

class PriorityQueueAbsolute{
    private int index = 0;
    private int size = 0;
    private int[] arr;
    public PriorityQueueAbsolute(int size){
        this.size = size;
        arr = new int[size];
        for(int i = 0; i< size;i++){
            arr[i] = Integer.MAX_VALUE;
        }
    }
    private boolean absCmp(int a, int b){ // a > b 면 트루 // 앞에 있는게 더 크면 트류 // 뒤에 있는게 작으면 트류
        int x = Math.abs(a);
        int y = Math.abs(b);
        return (x == y)? (a>b):(x>y);
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
            // if(arr[temp] > Math.abs(arr[z])){
            if(absCmp(arr[temp], arr[z])){
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
            if(absCmp(b1, b2) && absCmp(arr[i], b2)){ // 뒤에꺼가 작으면 true
                arr[a2] = arr[i];
                arr[i] = b2;
                i = a2;
            }else if(absCmp(arr[i], b1)){
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

class PriorityQueueMax{
    private int index = 0;
    private int size = 0;
    private int[] arr;
    public PriorityQueueMax(int size){
        this.size = size;
        arr = new int[size];
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
        int ans = (index == 0)? 0: getFirstValue();
        removeFirst();
        return ans;
    }
    public void removeFirst(){
        if(index == 0) return;
        index--;
        arr[0] = arr[index];
        arr[index] = 0;
        int i = 0;
        int a1,a2;
        int b1,b2;
        while(true){
            a1 = 2*i+1;
            a2 = 2*i+2;
            b1 = (a1 > index)? 0: arr[a1];
            b2 = (a2 > index)? 0: arr[a2];
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

class PriorityQueueMin{
    private int index = 0;
    private int size = 0;
    private int[] arr;
    public PriorityQueueMin(int size){
        this.size = size;
        arr = new int[size];
        for(int i = 0; i< size;i++){
            arr[i] = Integer.MAX_VALUE;
        }
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