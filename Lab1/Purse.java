package Lab1;

import java.util.HashMap;
import java.util.Map;


public class Purse {
    public static void main(String[] args)
    {

        // Create a Map using HasMap

        Map<Denomination, Integer> cash = new HashMap<>();

        cash.put((new Denomination("Ten", 10, "bill", "123123")), 1);

        //Displaying the Map

        for (Map.Entry<Denomination, Integer> me :
                cash.entrySet()) {

            // Printing keys
            System.out.print(me.getKey() + ":");
            System.out.println(me.getValue());
        }

    }

}
