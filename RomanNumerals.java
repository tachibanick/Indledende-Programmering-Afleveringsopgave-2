import java.util.Scanner;

public class RomanNumerals {
    public static void main(String[] args) {
        // Scanner is called and prompt is presented
        Scanner console = new Scanner(System.in);
        int intPrompt = retrieveInt(console, "Please write a positive integer between 1 and 3999: ");
        if (intPrompt > 3999 || intPrompt < 1) {
            throw new IllegalArgumentException("Invalid input. Please type an integer between 1 and 3999.");
        }
        System.out.println("Your input \"" + intPrompt + "\" is " + conIntToRoman(intPrompt)
                + " in roman numerals. Have a great day.");
    }

    // While-loop active while the temporary integer is above 0. At every increment
    // correspending to a roman numeral, the corresponding letter is added to the
    // string via the StringBuilder.
    public static String conIntToRoman(int userInput) {
        StringBuilder romanNum = new StringBuilder();
        int tempInt = userInput;
        while (tempInt > 0) {
            if (tempInt >= 1000) {
                tempInt -= 1000;
                romanNum.append("M");
            } else if (tempInt >= 900) {
                tempInt -= 900;
                romanNum.append("CM");
            } else if (tempInt >= 500) {
                tempInt -= 500;
                romanNum.append("D");
            } else if (tempInt >= 400) {
                tempInt -= 400;
                romanNum.append("CD");
            } else if (tempInt >= 100) {
                tempInt -= 100;
                romanNum.append("C");
            } else if (tempInt >= 90) {
                tempInt -= 90;
                romanNum.append("XC");
            } else if (tempInt >= 50) {
                tempInt -= 50;
                romanNum.append("L");
            } else if (tempInt >= 40) {
                tempInt -= 40;
                romanNum.append("XL");
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

    // Sorts away non-integers
    public static int retrieveInt(Scanner console, String prompt) {
        System.out.print(prompt);
        while (!console.hasNextInt()) {
            console.nextLine();
            System.out.print("Invalid input. " + prompt);
        }
        return console.nextInt();
    }

}
