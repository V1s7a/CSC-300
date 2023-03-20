import edu.princeton.cs.algs4.StdOut;

import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;

public class BST <Key extends Comparable<Key>, Value>{

    private class Node {
        public Key  key;
        public Value value;
        public Node left;
        public Node right;

        public Node(Key key, Value value){
            this.key = key;
            this.value = value;
        }
    }

    Node root;

    public BST(){
        root = null;
    }

    public void put(Key key, Value val){
        root = put(key, val, root);
    }

    private Node put(Key key, Value val, Node n){
        if (n == null){
            return new Node(key, val);
        }
        int cmp = key.compareTo(n.key);
        if(cmp < 0){
            n.left = put(key, val, n.left);
        } else if (cmp > 0) {
            n.right = put(key, val, n.right);
        }else {
            n.value = val;
        }
        return n;
    }

    public void inorder(){
        inorder(root);
    }

    private void inorder(Node n){
        if (n == null){
            return;
        }
        inorder(n.left);
        StdOut.println(n.key); //changed from StdOut.print(n.key + " "); to make easier to read on output
        inorder(n.right);
    }


    public boolean contains(Key k){
        return contains(k, root);
    }

    private boolean contains (Key k, Node n){
        if (n == null){
            return false;
        }
        int cmp = k.compareTo(n.key);
        if(cmp < 0){
            return contains(k, n.left);
        } else if (cmp > 0) {
            return contains(k, n.right);
        }
        return true;
    }

    public Value get(Key k){
        return get(k, root);
    }

    private Value get(Key k, Node n){
        if (n == null){
            throw new NoSuchElementException("Tree is empty");
        }

        int cmp = k.compareTo(n.key);
        if(cmp < 0){
            return get(k, n.left);
        } else if (cmp > 0) {
            return get(k, n.right);
        }
        return n.value;
    }

    public Queue<Key> keys(){
        Queue<Key> keys = new LinkedList();
        keys(root, keys);
        return keys;
    }

    private void keys(Node n, Queue<Key> kq){
        if (n == null){
            return;
        }
        keys(n.left, kq);
        kq.add(n.key);
        keys(n.right, kq);
    }

    public void del(Key k){
        root = del(root, k);
    }

    private Node del(Node n, Key k){
        if (n == null){
            return null;
        }
        int cmp = k.compareTo(n.key);
        if (cmp < 0){
            n.left = del(n.left, k);
        } else if (cmp > 0) {
            n.right = del(n.right, k);
        }else {
            if (n.left == null){
                return n.right;
            } else if (n.right == null) {
                return n.left;
            }else {
                Node temp = min(n.right);
                n.key = temp.key;
                n.value = temp.value;
                n.right = delMin(n.right);
            }
        }
        return n;
    }

    private Node min(Node n){
        if (n.left == null){
            return n;
        }else{
            return min(n.left);
        }
    }

    private Node delMin(Node n){
        if (n.left == null){
            return n.right;
        }
        n.left = delMin(n.left);
        return n;
    }

    public static void main(String[] args){
        BST<String, Integer> tree = new BST();
        tree.put("C",10);
        tree.put("B", 20);
        tree.put("A", 5);
        tree.inorder();

        if(tree.contains("A")){
            int val = tree.get("A");
            tree.del("A");
        }

        for (String k : tree.keys()){
            StdOut.println(k);
        }


    }
}
