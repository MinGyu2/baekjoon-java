package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P15828 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Router router = new Router(n);
        int temp;
        while((temp = Integer.parseInt(br.readLine())) != -1){
            if(temp == 0){
                router.poll();
            }else{
                router.push(temp);
            }
        }
        System.out.println(router);
    }
}
class Router{
    private class Node{
        private int value = 0;
        private Node nextNode = null;
        public Node(int i){
            this.value = i;
        }
        public void setNextNode(Node node){
            nextNode = node;
        }
        public int getValue(){
            return value;
        }
        public Node getNextNode(){
            return nextNode;
        }
    }
    private int size = 0;
    private int maxSize = 0;
    private Node firstNode = null;
    private Node lastNode = null;
    public Router(int maxSize){
        this.maxSize = maxSize;
    }
    public int poll(){
        int v = firstNode.getValue();
        firstNode = firstNode.getNextNode();
        size--;
        return v;
    }
    public boolean push(int i){
        if(isFull()){ return false; }
        if(isEmpty()){
            firstNode = new Node(i);
            lastNode = firstNode;
        }else{
            lastNode.setNextNode(new Node(i));
            lastNode = lastNode.getNextNode();
        }
        size++;
        return true;
    }
    public boolean isEmpty(){
        return size == 0;
    }
    public boolean isFull(){
        return size == maxSize;
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node s = firstNode;
        while(true){
            if(s == null){ break; }
            sb.append(s.getValue()).append(" ");
            s = s.nextNode;
        }
        if(isEmpty()) { sb.append("empty"); }
        return sb.toString();
    }
}
