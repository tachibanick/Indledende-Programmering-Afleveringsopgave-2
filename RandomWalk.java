import java.util.Random;
import java.util.Scanner;

public class RandomWalk {
    public static void main(String[] args) {
        int gridSize = getInt(new Scanner(System.in), "Enter size of grid: ");
        doPath(gridSize);
    }

    public static int getInt(Scanner console, String prompt) {
        System.out.print(prompt);
        while (!console.hasNextInt()) {
            console.next();
            System.out.println("Not an integer; try again.");
            System.out.print(prompt);
        }
        return console.nextInt();
    }

    public static void doPath(int gridSize) {
        int x = 0, y = 0;
        int steps = 0;
        Random random = new Random();
        do {
            System.out.println("Position = (" + x + "," + y + ")");
            if (random.nextBoolean()) {
                x += random.nextBoolean() ? 1 : -1;
            } else {
                y += random.nextBoolean() ? 1 : -1;
            }
            steps++;
        } while ((x >= -gridSize && x <= gridSize) && (y >= -gridSize && y <= gridSize));
        System.out.println("ILLEGAL Position = (" + x + "," + y + ")");
        System.out.println("Total number of steps = " + steps);
    }
}