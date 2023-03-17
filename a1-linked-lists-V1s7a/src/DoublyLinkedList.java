import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;
import java.util.NoSuchElementException;

// NOTE: All required exceptions have already been added to the code

public class DoublyLinkedList<T> implements ILinkedList<T>, Iterable<T>{
    private Node<T> front;
    private Node<T> back;
    private int len;


    private Node<T> getNodeAtPosition(int pos) throws NoSuchElementException {
        if (pos >= len()) {
            throw new NoSuchElementException("requested position greater then length of list");
        }
        return null;
    }

    public void insertFront(T item) {
        Node<T> n = new Node<>();
        n.data = item;
        if(this.isEmpty()){
            this.front = n;
            this.back = n;
            n.prev = null;
            n.next = null;
            this.len++;
        }else{
            n.prev = null;
            n.next = this.front;
            this.front.prev = n;
            this.front = n;
            this.len++;
        }
    }

    public void insertBack(T item) {
        if(this.isEmpty()){
            insertFront(item);
        }else{
            Node<T> n = new Node<>();
            n.data = item;
            n.prev = this.back;
            n.next = null;
            this.back.next = n;
            this.back = n;
            this.len++;
        }
    }

    public void insertAt(T item, int position) throws NoSuchElementException {
        if(position == 0){
            insertFront(item);
        } else if (position >= this.len) {
            insertBack(item);
        }else {
            if(this.isEmpty()){
                insertFront(item);
            }else{
                Node<T> n = new Node<>();
                n.data = item;
                Node<T> current = this.front;
                int i = 0;
                while (i < position -1){
                    current = current.next;
                    i++;
                }
                n.prev = current;
                n.next = current.next;
                current.next.prev = n;
                current.next = n;
                this.len++;
            }
        }
    }

    public T getFront() throws NoSuchElementException {
        if(isEmpty()){ throw new NoSuchElementException("List is empty");}
        return front.data;
    }

    public T getBack() throws NoSuchElementException {
        if(isEmpty()){ throw new NoSuchElementException("List is empty");}
        return back.data;
    }

    public T getAt(int position) throws NoSuchElementException {
        if(isEmpty()){ throw new NoSuchElementException("List is empty");}
        if(position >= len){
            throw new NoSuchElementException("position " + Integer.toString(position) + " does not exist in the list");
        }
        Node<T> current = this.front;
        int i = 0;
        while   (i < position){
            current = current.next;
            i++;
        }
        return current.data;
    }

    public void removeFront() throws NoSuchElementException {
        if(isEmpty()){ throw new NoSuchElementException("List is empty");}
        if(this.len == 1){
            this.front = null;
            this.back = null;
        }else {
            Node<T> current = this.front;
            current.next.prev = null;
            this.front = current.next;
        }
        this.len--;
    }

    public void removeBack() throws NoSuchElementException {
        if(isEmpty()){ throw new NoSuchElementException("List is empty");}
        if(this.len == 1){
            this.front = null;
            this.back = null;
        }else {
            Node<T> current = back;
            current.prev.next = null;
            this.back = current.prev;
        }
        this.len--;
    }

    public void removeAt(int position) throws NoSuchElementException {
        if(isEmpty()){ throw new NoSuchElementException("List is empty");}
        else if(position >= len()){ throw new NoSuchElementException("Position greater then list length");}
        else{
            if (len == 1){
                front = null;
                back = null;
                this.len--;
            } else {
                Node<T> current = front;
                int i = 0;
                while (i < position -1){
                    current = current.next;
                    i++;
                }
                current.prev.next = current.next; //set prior node next address to the current node's next address
                current.next.prev = current.prev; // set next node's previous address to current node's previous address
                this.len--;
            }
        }
    }

    public int len() {
        return len;
    }

    public boolean isEmpty() {
        if(this.len == 0){
            return true;
        }
        return false;
    }

    public void print() {
        StdOut.print("front -> ");
        Node<T> n = front;
        while( n != null){
            StdOut.print(n.data + " -> ");
            n = n.next;
        }
        StdOut.print("back\n");
    }

    public void printReverse() {
        StdOut.print("back -> ");
        Node<T> n = back;
        while( n != null){
            StdOut.print(n.data + " -> ");
            n = n.prev;
        }
        StdOut.print("front\n");
    }

    public void printDataAt(int position) {
        if(position >= len()){
            throw new NoSuchElementException();
        }
        Node<T> current = front;
        int i = 0;
        while (i < position){
            current = current.next;
            i++;
        }
        StdOut.println(current.data);
    }

    /* The iterator has already been completed for you, do not modify this function */
    public Iterator<T> iterator() {
        return new LinkedIterator(front);
    }

    /* The iterator has already been completed for you, do not modify this class or any functions inside of it */
    private class LinkedIterator implements Iterator<T> {
        private Node<T> current;

        public LinkedIterator(Node<T> first) {
            current = first;
        }

        public boolean hasNext()  { return current != null; }

        public T next() {
            if (!hasNext()) throw new NoSuchElementException();
            T item = current.getData();
            current = current.getNext();
            return item;
        }
    }

    // if you wish to write specific test code without running Main.java and using StdIn you can use this file's main
    // method to write test code. After you have written your test code you can run it by hilighting this file in the
    // project explorer on the left hand side of your screen, right clicking on it, and selecting `Rebuild`. Once it has
    // built you can run it by right clicking on the file again selecting `Run with arguments`
    public static void main(String[] args){

    }
}
