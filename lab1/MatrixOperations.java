import java.util.InputMismatchException;
import java.util.Scanner;

public class MatrixOperations {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            // Введення розмірів матриць
            System.out.println("Enter the number of rows and columns for matrix A:");
            int rowsA = scanner.nextInt();
            int colsA = scanner.nextInt();

            System.out.println("Enter the number of rows and columns for matrix B:");
            int rowsB = scanner.nextInt();
            int colsB = scanner.nextInt();

            // Перевірка на можливість множення матриць
            if (colsA != rowsB) {
                throw new IllegalArgumentException(
                        "Multiplication is not possible. The number of columns in matrix A must match the number of rows in matrix B.");
            }

            // Ініціалізація і заповнення матриць
            long[][] matrixA = readMatrix(scanner, rowsA, colsA, "A");
            long[][] matrixB = readMatrix(scanner, rowsB, colsB, "B");

            // Множення матриць
            long[][] matrixC = multiplyMatrices(matrixA, matrixB, rowsA, colsA, colsB);

            // Виведення результату множення
            System.out.println("Result of matrix multiplication (C = A x B):");
            printMatrix(matrixC);

            // Обчислення суми найбільших елементів рядків
            long sumMaxElements = calculateSumOfMaxElements(matrixC);
            System.out.println("Sum of the largest elements in each row of matrix C: " + sumMaxElements);

        } catch (InputMismatchException e) {
            System.out.println("Error: Invalid input. Please enter integers only.");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("An unexpected error occurred: " + e.getMessage());
        }
    }

    /**
     * Reads a matrix from user input.
     *
     * @param scanner    Scanner object for reading input.
     * @param rows       Number of rows in the matrix.
     * @param cols       Number of columns in the matrix.
     * @param matrixName Name of the matrix (for display purposes).
     * @return A 2D array representing the matrix.
     */
    private static long[][] readMatrix(Scanner scanner, int rows, int cols, String matrixName) {
        // Введення елементів матриці
        System.out.println("Enter the elements of matrix " + matrixName + ":");
        long[][] matrix = new long[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = scanner.nextLong();
            }
        }
        return matrix;
    }

    /**
     * Multiplies two matrices.
     *
     * @param matrixA The first matrix.
     * @param matrixB The second matrix.
     * @param rowsA   Number of rows in matrix A.
     * @param colsA   Number of columns in matrix A.
     * @param colsB   Number of columns in matrix B.
     * @return A 2D array representing the product of matrixA and matrixB.
     */
    private static long[][] multiplyMatrices(long[][] matrixA, long[][] matrixB, int rowsA, int colsA, int colsB) {
        // Множення матриць
        long[][] matrixC = new long[rowsA][colsB];
        for (int i = 0; i < rowsA; i++) {
            for (int j = 0; j < colsB; j++) {
                for (int k = 0; k < colsA; k++) {
                    matrixC[i][j] += matrixA[i][k] * matrixB[k][j];
                }
            }
        }
        return matrixC;
    }

    /**
     * Prints a matrix to the console.
     *
     * @param matrix The matrix to print.
     */
    private static void printMatrix(long[][] matrix) {
        // Виведення матриці
        for (long[] row : matrix) {
            for (long value : row) {
                System.out.print(value + "\t");
            }
            System.out.println();
        }
    }

    /**
     * Calculates the sum of the largest elements in each row of a matrix.
     *
     * @param matrix The matrix to analyze.
     * @return The sum of the largest elements in each row.
     */
    private static long calculateSumOfMaxElements(long[][] matrix) {
        // Обчислення суми найбільших елементів рядків
        long sum = 0;
        for (long[] row : matrix) {
            long maxElement = row[0];
            for (long value : row) {
                if (value > maxElement) {
                    maxElement = value;
                }
            }
            sum += maxElement;
        }
        return sum;
    }
}
