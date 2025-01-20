package Lab1;

import java.util.Objects;

public class Register {
    public Purse makeChange(double amt)
    {
        Purse purse = new Purse();
        double[] billAmt = {100, 50, 20, 10, 5, 1, .25, .1, .05, .01};
        String[] billString = {"One-Hundred-Dollar Note", "Fifty-Dollar Note",
                "Twenty-Dollar Note", "Ten-Dollar Note", "Five-Dollar Note",
                "One-Dollar Note", "Quarter", "Dime", "Nickel", "Penny"};
        String[] billType = {"bill", "bill", "bill", "bill", "bill", "bill", "coin", "coin", "coin", "coin"};
        String[] billImg = {"images/100dollar.png", "images/50dollar.png", "images/20dollar.png", "images/10dollar.png", "images/5dollar.png",
                "images/1dollar.png", "images/quarter.png", "images/dime.png", "images/nickel.png", "images/penny.png"};
        int billCount;
        for (int i = 0; i < 10; i++) {
            if (amt >=.005 && amt < .01){
                purse.add(new Denomination(billString[9], billAmt[9], billType[9], billImg[9]), 1);
            }
            else {
                billCount = (int) (amt / billAmt[i]);
                if (billCount > 0) {
                    purse.add(new Denomination(billString[i], billAmt[i], billType[i], billImg[i]), billCount);
                    amt -= (billAmt[i] * billCount);
                }
            }
        }
        return purse;
    }



    public static void main(String[] args) {
        Register r = new Register();

        Purse purse;
        double[] checkValues = {111.1, 1.25, .00001, .005, -5.45, 69.89};
        for (double checkValue : checkValues) {
            purse = r.makeChange(checkValue);
            String purseTotal = purse.toString();
            if (Objects.equals(purseTotal, "")) {
                System.out.println("\nEmpty Purse\n");
            } else {
                System.out.println(purseTotal);
            }
        }


    }
}
