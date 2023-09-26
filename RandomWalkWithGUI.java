import java.util.Random;
import java.util.Scanner;

public class RandomWalkWithGUI {
    public static void main(String[] args) {
        int gridSize = getInt(new Scanner(System.in), "Enter size of grid: ");
        drawGUI(gridSize);
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
        StdDraw.setPenColor(StdDraw.BLUE);
        int x = 0, y = 0;
        int steps = 0;
        do {
            System.out.println("Position = (" + x + "," + y + ")");
            if (new Random().nextInt(2) == 1) {
                x = doRandomMove(x);
            } else {
                y = doRandomMove(y);
            }
            steps++;
            StdDraw.point(x + gridSize * 0.05, y + gridSize * 0.05);
        } while ((x >= -gridSize && x <= gridSize) && (y >= -gridSize && y <= gridSize));
        System.out.println("ILLEGAL Position = (" + x + "," + y + ")");
        System.out.println("Total number of steps = " + steps);
        StdDraw.setPenColor(StdDraw.RED);
        StdDraw.point(x + gridSize * 0.05, y + gridSize * 0.05);
    }

    public static int doRandomMove(int position) {
        return new Random().nextInt(2) == 1 ? position + 1 : position - 1;
    }

    public static void drawGUI(int size) {
        StdDraw.setXscale(-size, size + 1);
        StdDraw.setYscale(-size, size + 1);
        StdDraw.setPenRadius(0.01); // Test 0.01 & 0.03 & 0.06 & 0.09
        for (int i = -size; i <= size; i++) {
            for (int j = -size; j <= size; j++) {
                StdDraw.point(i + size * 0.05, j + size * 0.05);
            }
        }

    }
}