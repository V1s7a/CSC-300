import java.util.NoSuchElementException;

public class Queue<T> implements IQueue<T>{
    T[] dataArray;
    int front;
    int back;
    int usedSlots;
    int slots;

    public Queue(){
        dataArray = (T[]) new Object[1];
        front = 0;
        back = 0;
        usedSlots = 0;
        slots = 1;
    }

    public void push(T data){
        resize();
        dataArray[back] = data;
        back = (back + 1) % slots;
        usedSlots++;
    }

    public T pop() throws NoSuchElementException {
        // exception throwing checks have already been added
        if(isEmpty()){
            throw new NoSuchElementException("Queue is empty");
        }
        T item = dataArray[front];
        dataArray[front] = null;
        front = (front + 1) % slots;
        usedSlots--;
        resize();
        return item;
    }

    public T peek() throws NoSuchElementException {
        // exception throwing checks have already been added
        if(isEmpty()){
            throw new NoSuchElementException("Queue is empty");
        }
        return dataArray[front];
    }

    private void resize(){ //check if array needs resizing and resize if necessary
        int quarter = slots / 4;
        int newSize = 0;
        if(usedSlots == slots){
            newSize = slots*2;
            T[] copy = (T[]) new Object[newSize];
            for (int i = 0; i < newSize; i++){
                copy[i] = dataArray[(front + i) % dataArray.length];
            }
            dataArray = copy;
            front = 0;
            back = usedSlots % newSize;
            slots = newSize;
        } else if (usedSlots <= quarter && slots > 2) {
            newSize = slots / 2;
            T[] copy = (T[]) new Object[newSize];
            for (int i = 0; i < newSize; i++){
                copy[i] = dataArray[(front + i) % dataArray.length];
            }
            dataArray = copy;
            front = 0;
            back = usedSlots % newSize;
            slots = newSize;
        }
    }

    public int size(){
        return usedSlots;
    }

    public boolean isEmpty(){
        if(usedSlots == 0){
            return true;
        }
        return false;
    }

    /* do not modify this function, call this to check the current size of your array */
    public int totalCapactiy(){
        return dataArray.length;
    }
}
