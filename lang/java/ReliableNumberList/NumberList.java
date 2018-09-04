import java.util.*;

public class NumberList
{

    public static void main(String[] args)
    {
        List<Double> list = new ArrayList<>();
        list.add(2.5);
        list.add(7.9);
        list.add(12.6);
        
        for (Double d : list) {
            System.out.print(d + " ");
        }
        System.out.println();
    }
    
}
