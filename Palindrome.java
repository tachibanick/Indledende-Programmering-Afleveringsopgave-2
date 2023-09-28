import java.util.Scanner;

public class Palindrome {
    public static void main(String[] args) {
        // Initialize Scanner and is called to define input.
        Scanner console = new Scanner(System.in);
        System.out.println("Please write a word or a sentence, and I'll check whether it's a palindrome or not:");
        String input = console.nextLine();
        System.out.print("Your input \"" + input + "\" is ");

        if (palindromeVerifier(input)) {
            System.out.println("a palindrome!");
        } else {
            System.out.println("unfortunately not a palindrome.");
        }
        console.close();
    }

    public static boolean palindromeVerifier(String input) {
        // Makes string lowercase and everything but the letters [a-z], numbers 0-9 and æøå
        input = input.toLowerCase();
        input = input.replaceAll("[^a-z0-9æøå]", "");

        // Characters at i and j "move" toward each other, and only stop when they dont match

        for (int i = 0, j = input.length()-1; i < j; i++, j--) {
            if (input.charAt(i) != input.charAt(j))
                return false;
        }
        return true;
    }
}
