import java.util.*;

class ReliableNumberList {

    public static void displayList(List l)
    {
        for (Object o : l) {
            System.out.print(o + " ");
        }
    }

    public static void main(String[] args)
    {
        List<Integer> squareList = new ArrayList<>();
        List<Integer> cubeList = new LinkedList<>();
        
        for (int k = 1; k <= 5; k++) {
            squareList.add(k * k);
            cubeList.add(k * k * k);
        }
        
        List<Integer> otherList = new LinkedList<>(squareList);
        System.out.print("Result of the copy constructor is: ");
        displayList(otherList);
        System.out.println();
        
        otherList = cubeList;
        System.out.print("Result of assignment is: ");
        displayList(otherList);
        System.out.println();   
    }
    
}
