import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

//Update to this file
public class HelloWorld {
    public static void main(String[] args){
       In fileInput = new In(args[0]);
       while (!fileInput.isEmpty()){
           String data = fileInput.readString();
           StdOut.println(data);
       }

    }
}
