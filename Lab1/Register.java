package Lab1;

import java.util.Objects;
import java.util.Scanner;

public class Register {
    public Purse makeChange(double amt)
    {
        int integerPart = (int) amt; // Extracts the integer part
        int fractionalPart = (int) Math.round((amt - integerPart) * 100); // Extracts
        Purse purse = new Purse();
        double[] billAmt = {100, 50, 20, 10, 5, 1, 25, 10, 5, 1};
        String[] billString = {"One-Hundred-Dollar Note", "Fifty-Dollar Note",
                "Twenty-Dollar Note", "Ten-Dollar Note", "Five-Dollar Note",
                "One-Dollar Note", "Quarter", "Dime", "Nickel", "Penny"};
        String[] billType = {"bill", "bill", "bill", "bill", "bill", "bill", "coin", "coin", "coin", "coin"};
        String[] billImg = {"images/100dollar.png", "images/50dollar.png", "images/20dollar.png", "images/10dollar.png", "images/5dollar.png",
                "images/1dollar.png", "images/quarter.png", "images/dime.png", "images/nickel.png", "images/penny.png"};
        int billCount;
        for (int i = 0; i < 6; i++) {
            billCount = (int) (integerPart / billAmt[i]);
            if (billCount > 0) {
                purse.add(new Denomination(billString[i], billAmt[i], billType[i], billImg[i]), billCount);
                integerPart -= (int) (billAmt[i] * billCount);
            }
        }

        for(int i = 6; i < 10; i++) {
            billCount = (int) (fractionalPart / billAmt[i]);
            if (billCount > 0) {
                purse.add(new Denomination(billString[i], billAmt[i]/100, billType[i], billImg[i]), billCount);
                fractionalPart -= (int) (billAmt[i] * billCount);
            }
        }
        return purse;
    }



    public static void main(String[] args) {
        Register r = new Register();

        Purse purse;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        double checkValue = scanner.nextDouble();
        purse = r.makeChange(checkValue);
        String purseTotal = purse.toString();
        if (Objects.equals(purseTotal, "")) {
            System.out.println("\nEmpty Purse\n");
        } else {
            System.out.println(purseTotal);
        }



    }
}
