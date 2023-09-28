import java.util.Random;
import java.util.Scanner;

public class RandomWalk {
    public static void main(String[] args) {
        int gridSize = getInt(new Scanner(System.in), "Enter size of grid: ");
        doPath(gridSize);
    }

    public static int getPosInt(Scanner console, String prompt) {
        System.out.println(prompt);
        if (!console.hasNextInt()) {
            throw new IllegalArgumentException("Please enter an integer");
        }
        int temp = console.nextInt();
        if (temp < 0){
            throw new IllegalArgumentException("Please enter a positive integer");
        }       
        return temp;
    }

    public static void doPath(int gridSize) {
        int x = 0, y = 0;
        int steps = 0;
        Random random = new Random();
        while ((x >= -gridSize && x <= gridSize) && (y >= -gridSize && y <= gridSize)) {
            System.out.println("Position = (" + x + "," + y + ")");
            if (random.nextBoolean()) {
                x += random.nextBoolean() ? 1 : -1;
            } else {
                y += random.nextBoolean() ? 1 : -1;
            }
            steps++;
        }
        System.out.println("ILLEGAL Position = (" + x + "," + y + ")");
        System.out.println("Total number of steps = " + steps);
    }
}
