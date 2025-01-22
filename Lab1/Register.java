package Lab1;

import java.util.Objects;
import java.util.Scanner;

public class Register {
    public Purse makeChange(double amt)
    {
        int integerPart = (int) amt; // Extracts the whole dollar part
        int fractionalPart = (int) Math.round((amt - integerPart) * 100); // Extracts the coin part
        Purse purse = new Purse();

        //arrays meant for looping through each value of a bill//
        double[] billAmt = {100, 50, 20, 10, 5, 1, 25, 10, 5, 1};
        String[] billString = {"One-Hundred-Dollar Note", "Fifty-Dollar Note",
                "Twenty-Dollar Note", "Ten-Dollar Note", "Five-Dollar Note",
                "One-Dollar Note", "Quarter", "Dime", "Nickel", "Penny"};
        String[] billType = {"bill", "bill", "bill", "bill", "bill", "bill", "coin", "coin", "coin", "coin"};
        String[] billImg = {"images/100dollar.png", "images/50dollar.png", "images/20dollar.png", "images/10dollar.png", "images/5dollar.png",
                "images/1dollar.png", "images/quarter.png", "images/dime.png", "images/nickel.png", "images/penny.png"};
        //******************************************************//


        int billCount;
        //loop through the bills portion of the array
        for (int i = 0; i < 6; i++) {
            //if the amt in whole dollars can be divided by the current bill in billAmt[i]
            //then add that number of bills to the purse
            billCount = (int) (integerPart / billAmt[i]);
            if (billCount > 0) {
                purse.add(new Denomination(billString[i], billAmt[i], billType[i], billImg[i]), billCount);
                integerPart -= (int) (billAmt[i] * billCount);//subtract the total amount just added to the purse
            }
        }
        //loop through the coins portion of the array
        for(int i = 6; i < 10; i++) {
            //if the amt in coin value can be divided by the current coin in billAmt[i]
            //then add that number of coins to the purse
            billCount = (int) (fractionalPart / billAmt[i]);
            if (billCount > 0) {
                purse.add(new Denomination(billString[i], billAmt[i]/100, billType[i], billImg[i]), billCount);
                fractionalPart -= (int) (billAmt[i] * billCount);//subtract the total amount just added to the purse
            }
        }
        //when you've gotten hear the integerPart and fractionalPart should both be zero
        //this means the correct amount of change was given back
        return purse;
    }



    public static void main(String[] args) {
        Register r = new Register();

        Purse purse;
        //input handling
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        double checkValue = scanner.nextDouble();
        scanner.close();

        //make change with the given input value
        purse = r.makeChange(checkValue);
        String purseTotal = purse.toString(); //gets the string representation of the entire purse
        //if the previous line returns nothing, tell the user empty purse
        if (Objects.equals(purseTotal, "")) {
            System.out.println("\nEmpty Purse\n");
        } else {
            System.out.println(purseTotal);
        }



    }
}
