import java.util.*;

public class BuffonsNeedle {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        Random rand = new Random();
        int iterations = getPosInt(console, "Enter number of iterations: ");
        int count = 0;

        for (int i = 0; i < iterations; i++) {
            //Defines the distance between the lower needle to the nearest line. Right now the needle is pointing straight "up", parallel to the lines on the paper
            double distLowerNeedle = rand.nextDouble()*2;

            //The needle gets an orientation, and the horizontal distance the needle covers is calculated
            double orientation = rand.nextDouble()*2*Math.PI;
            double distTopNeedle = Math.cos(orientation);

            //If the summed distance is over 2 or under 0, the needle has crossed a line, and it's counted.
            if (distTopNeedle + distLowerNeedle > 2 || distTopNeedle + distLowerNeedle < 0){
                count++;
            }
        }
        System.out.println("Number of iterations was " + iterations + " and the number of successes was " + count);
        System.out.println(iterations + " / " + count + " = " + iterations / (double) (count));
        console.close();
    }

    // Sorts away everything but non-negative integers.
    public static int getPosInt(Scanner console, String prompt) {
        System.out.println(prompt);
        while (!console.hasNextInt()) {
            console.nextLine();
            System.out.println("Not an integer; try again.");
            System.out.println(prompt);
        }
        int temp = console.nextInt();
        while (temp < 0){
            console.nextLine();
            System.out.println("Enter a positive integer.");
            temp = getPosInt(console, prompt);
        }
        
        return temp;
    }
}
