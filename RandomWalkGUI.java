import java.util.Random;
import java.util.Scanner;

/* 
 * Gustav Walker Petersen.
 * 02100 Indledende Programmering E23.
 * This program simulates a random walk in a n-sized 2D grid.
 * And displays it using a GUI. 
 */

public class RandomWalkGUI {
    public static void main(String[] args) {
        int gridSize = getPosInt(new Scanner(System.in), "Enter size of grid: ");
        drawGUI(gridSize);
        doPath(gridSize);
    }

    // This method reads input from the console.
    // Then it evaluates whether the input is an positive Integer or not.
    // The method returns the input if it is, else an error will be thrown.
    public static int getPosInt(Scanner console, String prompt) {
        System.out.print(prompt);
        if (!console.hasNextInt()) {
            throw new IllegalArgumentException("Please enter an integer");
        }
        int temp = console.nextInt();
        if (temp < 0) {
            throw new IllegalArgumentException("Please enter a positive integer");
        }
        return temp;
    }

    // This method is used to generate the path our entity makes.
    // The method takes the grid size as an integer then it
    // prints the entity position to the console, draws it to the
    // GUI and makes the entity take a random step until the entity
    // is outside the grid. Then it prints the illegal position and
    // the total number of steps to the console.
    public static void doPath(int gridSize) {
        int x = 0, y = 0;
        int steps = 0;
        Random random = new Random();
        while ((x >= -gridSize && x <= gridSize) && (y >= -gridSize && y <= gridSize)) {
            StdDraw.point(x, y);
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

    // This method takes the grid size as an argument
    // and defines the borders of the grid and the point size.
    public static void drawGUI(int size) {
        StdDraw.setXscale(-size, size);
        StdDraw.setYscale(-size, size);
        StdDraw.setPenRadius(0.6 / size);
    }
}
