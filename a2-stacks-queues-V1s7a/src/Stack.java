import java.util.NoSuchElementException;

public class Stack<T> implements IStack<T>{
    Queue<T> q1;
    Queue<T> q2;

    public Stack(){
        q1 = new Queue<>();
        q2 = new Queue<>();

    }

    public void push(T data){
        q1.push(data);
    }

    public T pop() throws NoSuchElementException {
        // exception throwing checks have already been added
        if(isEmpty()){ throw new NoSuchElementException("queue is empty"); }
        while (q1.size() > 1){
            q2.push(q1.pop());
        }
        T poppedVal = q1.pop();
        Queue<T> temp = q1;
        q1 = q2;
        q2 = temp;
        return poppedVal;
    }

    public T peek(){
        // exception throwing checks have already been added
        if(isEmpty()){ throw new NoSuchElementException("queue is empty"); }

        while (q1.size() > 1){
            q2.push(q1.pop());
        }
        T poppedVal = q1.pop();
        q2.push(poppedVal);
        Queue<T> temp = q1;
        q1 = q2;
        q2 = temp;
        return poppedVal;
    }

    public int size(){
        return q1.size();
    }

    public boolean isEmpty(){
        if (q1.isEmpty() && q2.isEmpty()){
            return true;
        }
        return false;
    }
}
