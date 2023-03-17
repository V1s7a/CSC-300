import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public class GenericList<T> implements Iterable<T>{
    public Iterator<T> iterator() {
        return new ListIterator<T>(head);
    }
    private static class ListIterator<T> implements Iterator{
        Node<T> curr;

        public ListIterator(Node<T> head){
            curr = head;
        }
        public boolean hasNext() {
            return curr.next != null;
        }

        public Object next() {
            T data = curr.data;
            curr = curr.next;
            return curr.data;
        }
    }
    private static class Node<T> {
        T data;
        Node<T> next;
        public Node(){
            this.data = null;
            this.next = null;
        }
    }

    Node<T> head; //Anchor for list
    Node<T> tail; //Tail of the list
    int size;

    public GenericList(){
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public void addToFront(T val){
        Node<T> n = new Node<>();
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
        if(!this.isEmpty()){
            Node<T> n = head;
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

    public T getFront(){
        if (!this.isEmpty()){
            return this.head.data;
        }else {
            throw new NoSuchElementException("list is empty");
        }
    }

    public void print(){ //check is not necessary
        Node<T> n = head;
        while(n != null){
            StdOut.printf("%s ->", n.data);
            n = n.next;
        }
        StdOut.println("null\n");
    }

    public void addToBack(T value){
        Node<T> n = new Node<T>();
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

    public T getBack(){
        if (!this.isEmpty()){
            return tail.data;
        }else {
            throw new NoSuchElementException("list is empty");
        }
    }
    public void removeBack(){
        if(!this.isEmpty()){
            Node<T> w = head;
            while(w.next != tail){
                w = w.next;
            }
            w.next = null;
            tail = w;

        }
        this.size--;
    }

    public void insertAt(int idx, T value){
        if (idx >= this.size()){
            throw new NoSuchElementException("idx is longer than the length of the list");
        }
        if(idx == 0){
            addToFront(value);
        } else if (idx == this.size -1) {
            addToBack(value);
        } else {
            Node<T> w = head;
            int i = 0;
            while (w != null && i < idx){
                w = w.next;
                i++;
            }
            Node<T> r = head;
            while(r.next != w){
                r = r.next;
            }
            Node<T> n = new Node<>();
            n.data = value;
            r.next = n;
            n.next = w;
            this.size++;
        }
    }

    public void removeAt(int ind, T value){

    }

    public T getAt(int idx){
        return null;
    }
    public boolean isEmpty(){
        return size == 0;
    }

    public int size(){
        return this.size;
    }
}
