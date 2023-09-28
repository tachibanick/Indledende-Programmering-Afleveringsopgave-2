import java.util.Random;
import java.util.Scanner;

//This program simulates a random walk in a n-sized 2D grid and displays it using a GUI. 

public class RandomWalkGUI {
    public static void main(String[] args) {
        int gridSize = getPosInt(new Scanner(System.in), "Enter size of grid: ");
        drawGUI(gridSize);
        doPath(gridSize);
    }

    // This methods throws errors if the user doesnt input a non-negative integer
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

    // While x,y is inside of the bounds, it moves randomly up, down, left or right and draws its position with StdDraw
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

// Defines the bounds of StdDraw based on user inputted gridsize
    public static void drawGUI(int size) {
        StdDraw.setXscale(-size, size);
        StdDraw.setYscale(-size, size);
        StdDraw.setPenRadius(0.6 / size);
    }
}
