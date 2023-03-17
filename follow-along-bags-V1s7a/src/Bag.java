import java.lang.reflect.Array;
import java.util.Iterator;

public class Bag<T> implements IBag<T>{
    T[] data;
    int idx;

    public Bag(){
        data = (T[]) new Object[100];
        idx = 0;
    }

    @Override
    public void add(T item) {
        data[idx++] = item;
    }

    @Override
    public boolean isEmpty() {
        if(idx == 0){
            return true;
        }
        return false;
    }

    @Override
    public int size() {
        return idx -1;
    }

    @Override
    public Iterator<T> iterator() {
        return new ArrayIterator();
    }

    private class ArrayIterator implements Iterator<T>{
        int current;
        public ArrayIterator(){
            current = 0;
        }
        @Override
        public boolean hasNext() {
            if(current < idx){
                return true;
            }
            return false;
        }

        @Override
        public T next() {
            return data[current++];
        }
    }

    /*GenericList<T> list;

    public Bag(){
        list = new GenericList<>();
    }
    @Override
    public void add(T item) {
        list.addToBack(item);
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public Iterator<T> iterator() {
        return list.iterator();
    }*/
}
