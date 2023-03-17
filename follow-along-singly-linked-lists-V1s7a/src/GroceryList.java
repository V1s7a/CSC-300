import edu.princeton.cs.algs4.StdOut;

public class GroceryList {
    private static class Item {
        String name;
        boolean purchased;
        public Item(String name){
            this.name = name;
            this.purchased = false;
        }
    }
    GenericList<Item> list;

    public GroceryList(){
        list = new GenericList<>();
    }
    public void add(String name){
        Item n = new Item(name);
        list.addToFront(n);
    }

    public void bought(String name){
        for (Item i : list){
            if(i.name.equals(name)){
                i.purchased = true;
                break;
            }
        }
    }

    public void print(){
        StdOut.println("List\n-------\n");
        for(Item item : list){
            StdOut.print("[");
            if(item.purchased){
                StdOut.print("X");
            }else{
                StdOut.print(" ");
            }
            StdOut.printf("] %s\n", item.name);
        }
    }
}
