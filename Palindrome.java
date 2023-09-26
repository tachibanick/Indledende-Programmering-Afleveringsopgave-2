import java.util.Scanner;

public class Palindrome {
    public static void main(String[] args) {
        // Initialize Scanner and is called to define input.
        Scanner console = new Scanner(System.in);

        String input = getWord(console,
                "Please write a word or a sentence, and I'll check whether it's a palindrome or not: ");

        // method to ignore special characters is called.

        // The state of the boolean method prints if evaluated true.
        if (palindromeVerifier(input)) {
            System.out.print("Your input: " + '"' + input + '"' + " is a palindrome!");
        } else {
            System.out.print("Your input: " + '"' + input + '"' + " is unfortunately not a palindrome.");
        }
    }

    // Boolean method checking whether input is palindrome or not.
    public static boolean palindromeVerifier(String input) {
        // User input converted to all lower case letters, as to not give false
        // negatives.
        input = input.toLowerCase();
        // Code forced to ignore special characters.
        input.replaceAll("[^a-zA-Z]", "");

        int i = 0, j = input.length() - 1;

        while (i < j) {
            if (input.charAt(i) != input.charAt(j))
                return false;
            // If the above never evaluates to false, the while-loop keeps going with
            // increments.
            i++;
            j--;
        }

        // Given while loop completes without interruption, the boolean method will
        // return true instead of false.
        return true;
    }

    // Collects input from user, stores it as String
    public static String getWord(Scanner console, String input) {
        System.out.print(input);
        return console.nextLine();
    }

}
