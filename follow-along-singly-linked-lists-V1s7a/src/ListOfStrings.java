import edu.princeton.cs.algs4.StdOut;
import java.util.NoSuchElementException;

public class ListOfStrings {

    private static class Node {
        String data;
        Node next;
        public Node(){
            this.data = null;
            this.next = null;
        }
    }

    Node head; //Anchor for list
    Node tail; //Tail of the list
    int size;

    public ListOfStrings(){
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public void addToFront(String val){
        Node n = new Node();
        n.data = val;
        if(this.isEmpty()) {
            this.head = n;
            this.tail = n;
        }else{
            n.next = head;
            head = n;
        }
        this.size++;
    }

    public void removeFront(){
        if(this.isEmpty()){
            Node n = head;
            head = head.next;
            n.next = null;
            if (head == null){
                tail = null;
            }
        }else {
            throw new NoSuchElementException("list is empty");
        }
        this.size--;
    }

    public String getFront(){
        if (!this.isEmpty()){
            return this.head.data;
        }else {
            throw new NoSuchElementException("list is empty");
        }
    }

    public void print(){ //check is not necessary
        Node n = head;
        while(n != null){
            StdOut.printf("%s ->", n.data);
            n = n.next;
        }
        StdOut.println("null\n");
    }

    public void addToBack(String value){
        Node n = new Node();
        n.data = value;
        if(this.isEmpty()) {
            this.head = n;
            this.tail = n;
        }else{
            this.tail.next = n;
            tail = n;
        }
        this.size++;
    }

    public String getBack(){
        if (!this.isEmpty()){
            return tail.data;
        }else {
            throw new NoSuchElementException("list is empty");
        }
    }
    public void removeBack(){
        if(!this.isEmpty()){
            Node w = head;
            while(w.next != tail){
                w = w.next;
            }
            w.next = null;
            tail = w;

        }
        this.size--;
    }

    public void insertAt(int idx, String value){
        if (idx >= this.size()){
            throw new NoSuchElementException("idx is longer than the length of the list");
        }
        if(idx == 0){
            addToFront(value);
        } else if (idx == this.size -1) {
            addToBack(value);
        } else {
            Node w = head;
            int i = 0;
            while (w != null && i < idx){
                w = w.next;
                i++;
            }
            Node r = head;
            while(r.next != w){
                r = r.next;
            }
            Node n = new Node();
            n.data = value;
            r.next = n;
            n.next = w;
            this.size++;
        }
    }
    public boolean isEmpty(){
        return size == 0;
    }

    public int size(){
        return this.size;
    }
}
