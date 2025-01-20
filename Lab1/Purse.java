package Lab1;

import java.util.HashMap;
import java.util.Map;


public class Purse {

    private Map<Denomination, Integer> cash;

    public Purse() {
        cash = new HashMap<>();
    }

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
        for (Map.Entry<Denomination, Integer> bills : cash.entrySet()) {
            total += bills.getKey().amt() * bills.getValue();
        }
        return total;
    }

    public String toString(){
        String rep = "";
        for (Map.Entry<Denomination, Integer> bills : cash.entrySet()) {
            rep += bills.getKey().name() + ": " + bills.getValue() + "\n";
        }
        return rep;
    }


}
