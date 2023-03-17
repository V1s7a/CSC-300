import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StopwatchCPU;
import java.util.NoSuchElementException;

public class Main {
    public static void main(String[] args) {
        GroceryList costcoList = new GroceryList();
        GroceryList wegmansList = new GroceryList();

        while (!StdIn.isEmpty()) {
            String list = StdIn.readString();
            String cmd = StdIn.readString();
            if (list.equals("costco")) {
                switch(cmd){
                    case "add":
                        costcoList.add(StdIn.readString());
                        break;
                    case "bought":
                        costcoList.bought(StdIn.readString());
                        break;
                    case "print":
                        costcoList.print();
                        break;
                    default:
                        StdOut.println("Unknown command " + cmd);
                }
            }
            else if (list.equals("wegmans")) {
                switch(cmd){
                    case "add":
                        wegmansList.add(StdIn.readString());
                        break;
                    case "bought":
                        wegmansList.bought(StdIn.readString());
                        break;
                    case "print":
                        wegmansList.print();
                        break;
                    default:
                        StdOut.println("Unkown Command " + cmd);
                }
            }
        }
    }
}
        /*GenericList<Integer> l = new GenericList<>();
        for(int i = 0; i < 25; i++){
            l.addToBack(i);
        }
        for(int val : l){
            StdOut.println(val);
        }
        while (!StdIn.isEmpty()){
            String cmd = StdIn.readString();
            switch (cmd){
                case "addToFront":
                    l.addToFront(StdIn.readInt());
                    break;
                case "addToBack":
                    l.addToBack(StdIn.readInt());
                    break;
                case "removeFront":
                    try {
                        l.removeFront();
                    }catch (NoSuchElementException e){
                        StdOut.println("List is empty");
                    }
                    break;
                case "removeBack":
                    try {
                        l.removeBack();
                    }catch (NoSuchElementException e){
                        StdOut.println("List is empty");
                    }
                    break;
                case "getFront":
                    StdOut.println(l.getFront());
                    break;
                case "getBack":
                    StdOut.println(l.getBack());
                    break;
                case "print":
                    l.print();
                    break;
                default:
                    StdOut.println("Unknown command " + cmd);
            }
        }
    }*/

