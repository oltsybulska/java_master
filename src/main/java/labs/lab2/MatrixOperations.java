package labs.lab2;

import java.util.Random;
import java.util.Scanner;

public class MatrixOperations {
    private static final int MAX_SIZE = 20;
    private static final int MIN_RANDOM = 1;
    private static final int MAX_RANDOM = 100;

    private int[][] matrix;
    private int width;
    private int height;

    public static void main(String[] args) {
        MatrixOperations matrixOps = new MatrixOperations();
        matrixOps.run();
    }

    public void run() {
        readMatrixSize();
        createMatrix();
        printMatrix();
        findMinMaxAverage();
    }

    private void readMatrixSize() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введіть ширину матриці (не більше 20): ");
        width = scanner.nextInt();

        System.out.print("Введіть висоту матриці (не більше 20): ");
        height = scanner.nextInt();

        if (width > MAX_SIZE || height > MAX_SIZE) {
            System.out.println("Розмір матриці перевищує максимально допустимий розмір.");
            System.exit(1);
        }
    }

    private void createMatrix() {
        matrix = new int[height][width];
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.print("Обрати ручне заповнення матриці? (так/ні): ");
        String choice = scanner.nextLine();

        if (choice.equalsIgnoreCase("так")) {
            manualFillMatrix(scanner);
        } else {
            randomFillMatrix(random);
        }
    }

    private void manualFillMatrix(Scanner scanner) {
        System.out.println("Введіть елементи матриці:");

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                System.out.printf("Елемент [%d][%d]: ", i, j);
                matrix[i][j] = scanner.nextInt();
            }
        }
    }

    private void randomFillMatrix(Random random) {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                matrix[i][j] = random.nextInt(MAX_RANDOM - MIN_RANDOM + 1) + MIN_RANDOM;
            }
        }
    }

    private void printMatrix() {
        System.out.println("Матриця:");

        for (int[] row : matrix) {
            for (int num : row) {
                System.out.printf("%5d", num);
            }
            System.out.println();
        }
    }

    private void findMinMaxAverage() {
        int min = matrix[0][0];
        int max = matrix[0][0];
        double sum = 0;
        int count = 0;

        for (int[] row : matrix) {
            for (int num : row) {
                if (num < min) {
                    min = num;
                }
                if (num > max) {
                    max = num;
                }
                sum += num;
                count++;
            }
        }

        double average = sum / count;

        System.out.println("Мінімальний елемент: " + min);
        System.out.println("Максимальний елемент: " + max);
        System.out.println("Середнє арифметичне: " + average);
    }
}