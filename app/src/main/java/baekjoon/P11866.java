package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P11866 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        final MLinkedList l = new MLinkedList();
        for(int i = 1; i<n+1;i++){
            l.push(i);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        while(true){
            sb.append(l.remove(k));
            if(l.isEmpty()){ 
                break;
            }else{
                sb.append(", ");
            }
        }
        sb.append(">");
        System.out.println(sb);
    }

}
class MLinkedList{
    private class Node{
        private int value;
        private Node nextNode;
        private Node preNode;
        public Node(int i){
            value = i;
        }
        public void setNextNode(Node node){
            nextNode = node;
        }
        public Node getNextNode(){
            return nextNode;
        }
        public void setPreNode(Node node){
            preNode = node;
        }
        public Node getPreNode(){
            return preNode;
        }
        public int getValue() {
            return value;
        }
    }
    private int size = 0;
    private Node firstNode = null;
    private Node currentNode = null;
    private Node lastNode = null;
    public MLinkedList(){}
    public boolean isEmpty(){
        return size == 0;
    }
    public void push(int i){
        if(isEmpty()){
            firstNode = new Node(i);
            lastNode= firstNode;
            currentNode = firstNode;
            firstNode.setNextNode(firstNode);
            firstNode.setPreNode(firstNode);
        }else{
            Node temp = new Node(i);
            temp.setNextNode(lastNode.getNextNode());
            lastNode.setNextNode(temp);
            temp.setPreNode(lastNode);
            firstNode.setPreNode(temp);
            lastNode = temp;
        }
        size++;
    }
    // 현재로 부터 k 번째 아이템 삭제
    public int remove(int k){
        if(isEmpty()){ return -1;}
        Node temp = currentNode;
        for(int i =1;i<k;i++){
            temp = temp.getNextNode();
        }
        int value = temp.getValue();
        Node pre = temp.getPreNode();
        Node next = temp.getNextNode();
        pre.setNextNode(next);
        next.setPreNode(pre);
        currentNode = next;
        size--;
        return value;
    }
}
