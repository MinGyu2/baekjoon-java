package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1991 {
    static int[] preorder;
    static int preorderIndex = 0;

    static int[] inorder;
    static int inorderIndex = 0;

    static int[] postorder;
    static int postorderIndex = 0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] graph = new int[n][2];
        for(int i = 0;i<n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int node = st.nextToken().toCharArray()[0] - 'A';
            int leftNode = st.nextToken().toCharArray()[0] - 'A';
            int rightNode = st.nextToken().toCharArray()[0] - 'A';
            graph[node][0] = leftNode;
            graph[node][1] = rightNode;
        }
        preorder = new int[n];
        preorderIndex = 0;

        inorder = new int[n];
        inorderIndex = 0;

        postorder = new int[n];
        postorderIndex = 0;
        
        dfs(graph, 0);
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i<n;i++){
            sb.append((char)(preorder[i]+'A'));
        }
        sb.append('\n');
        for(int i = 0;i<n;i++){
            sb.append((char)(inorder[i]+'A'));
        }
        sb.append('\n');
        for(int i = 0;i<n;i++){
            sb.append((char)(postorder[i]+'A'));
        }
        System.out.println(sb);
        // System.out.println(Arrays.toString(preorder));
        // System.out.println(Arrays.toString(inorder));
        // System.out.println(Arrays.toString(postorder));
        // for(int[] g:graph){
        //     System.out.println(Arrays.toString(g));
        // }
    }
    static void dfs(int[][] graph, int node){
        int left = graph[node][0];
        int right = graph[node][1];

        // 부모 노드 부터 방문 후 자식 노드 방문
        preorder[preorderIndex++] = node; // 전위 순회
        // Left
        if(left >= 0){
            dfs(graph, left);
        }
        // 왼쪽 자식 노드 방문후 부모 노드 방문
        inorder[inorderIndex++] = node; // 중위 순회
        // Right
        if(right >= 0){
            dfs(graph, right);
        }
        // 자식 노드 모두 방문후 부모 노드 방문
        postorder[postorderIndex++] = node; // 후위 순회
    }
}
