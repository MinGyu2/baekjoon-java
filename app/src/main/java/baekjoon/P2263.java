package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P2263 {
    static int[] inorder;
    static int[] postorder;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        inorder = Arrays.stream(br.readLine().split(" ")).mapToInt((i)->Integer.parseInt(i)).toArray();
        postorder = Arrays.stream(br.readLine().split(" ")).mapToInt((i)->Integer.parseInt(i)).toArray();
        int l = n;
        // System.out.println(Arrays.toString(inorder));
        // System.out.println(Arrays.toString(postorder));
        divdeAndConquer(0, 0, l);
        System.out.println(sb);
    }
    static void divdeAndConquer(int inS, int postS, int len){
        if(len == 0){
            return;
        }
        // 1. 부모 노드 찾기
        int v = postorder[postS + len - 1];
        sb.append(v).append(' ');
        int temp = 0;
        for(int i = inS + len - 1; i >= inS;i--){
            if(inorder[i] == v){
                temp = i;
                break;
            }
        }
        // 2. 쪼개기
        // 2-1. left 부터
        int leftLen = temp - inS;
        // inorder 
        int newInS = inS;
        // postorder
        int newPostS = postS;
        divdeAndConquer(newInS, newPostS, leftLen);


        // 2-2. right
        int rightLen = len - leftLen - 1;
        // inorde
        newInS = temp+1;
        // postorder
        newPostS = postS + leftLen;
        divdeAndConquer(newInS, newPostS, rightLen);
    }
}
