package Lab1;

import java.util.LinkedHashMap;
import java.util.Map;


public class Purse {

    public Map<Denomination, Integer> cash;

    public Purse() {
        cash = new LinkedHashMap<>();
    } //linked hash map keeps the order of the objects that they were added in

    public void add(Denomination d, int numBills) {
        cash.put(d, numBills);
    }

    public double remove(Denomination d, int numBills) {
        double total = d.amt() * numBills;
        cash.remove(d);

        return total;
    }

    public double getValue(){
        double total = 0;
        //for each map in the cash var - find the total of the bills in that mapping
        for (Map.Entry<Denomination, Integer> bills : cash.entrySet()) {
            //    amount attached to the bill   count of that bill
            total += bills.getKey().amt() * bills.getValue();
        }
        return total;
    }

    public String toString(){
        String rep = "";
        //for each map in the cash var - create a string representation of bills in each map
        for (Map.Entry<Denomination, Integer> bills : cash.entrySet()) {
            //   human-readable name of bill      count of that bill
            rep += bills.getKey().name() + ": " + bills.getValue() + "\n";
        }
        return rep;
    }


}
