import java.util.Scanner;

public class RomanNumerals {
    public static void main(String[] args) {
        // Scanner is called and prompt is presented and also hi here
        Scanner console = new Scanner(System.in);
        int intPrompt = retrieveInt(console, "Please write a positive integer between 1 and 3999: ");
        // String is printed
        if (intPrompt > 3999 || intPrompt < 1) {
            throw new IllegalArgumentException("Invalid input. Please type an integer between 1 and 3999.");
        }
        System.out.println("Your input " + "\"" + intPrompt + "\" " + "is " + conIntToRoman(intPrompt)
                + " in roman numerals. Have a great day.");
    }

    // While-loop active while dynamic input is above 0. At every increment
    // correspending to a roman numeral, the corresponding letter is added to the
    // string via the StringBuilder.
    public static String conIntToRoman(int console) {
        StringBuilder romanNum = new StringBuilder();
        int tempInt = console;
        while (tempInt > 0) {
            if (tempInt >= 1000) {
                tempInt -= 1000;
                romanNum.append("M");
            } else if (tempInt >= 999) {
                tempInt -= 999;
                romanNum.append("IM");
            } else if (tempInt >= 500) {
                tempInt -= 500;
                romanNum.append("D");
            } else if (tempInt >= 499) {
                tempInt -= 499;
                romanNum.append("ID");
            } else if (tempInt >= 100) {
                tempInt -= 100;
                romanNum.append("C");
            } else if (tempInt >= 99) {
                tempInt -= 99;
                romanNum.append("IC");
            } else if (tempInt >= 50) {
                tempInt -= 50;
                romanNum.append("L");
            } else if (tempInt >= 49) {
                tempInt -= 49;
                romanNum.append("IL");
            } else if (tempInt >= 10) {
                tempInt -= 10;
                romanNum.append("X");
            } else if (tempInt == 9) {
                tempInt -= 9;
                romanNum.append("IX");
            } else if (tempInt >= 5) {
                tempInt -= 5;
                romanNum.append("V");
            } else if (tempInt == 4) {
                tempInt -= 4;
                romanNum.append("IV");
            } else if (tempInt > 0) {
                tempInt -= 1;
                romanNum.append("I");
            }
        }
        return romanNum.toString();
    }

    // Scanner for accepting console input by user. Will reject non-integers and
    // only integers between 1 and 3999.
    public static int retrieveInt(Scanner console, String question) {
        System.out.print(question);
        while (!console.hasNextInt()) {
            console.next();
            System.out.print("Invalid input. " + question);
        }
        return console.nextInt();
    }

}
