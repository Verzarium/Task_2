import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Ex9 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter value of matrix-side: ");
        int side = in.nextInt();
        int[][] arr = new int[side][side];
        System.out.println("Enter value of interval: ");
        int k = in.nextInt();
        matrixConstruction(arr, k);
        System.out.println("Your array:");
        matrixOutput(arr);
        //matrixSort(arr);
        shiftOfMatrix(arr);
    }

    /*9.Ввести с консоли n-размерность матрицы a [n] [n].
    Задать значения элементов матрицы в интервале значений от -n до n
    с помощью датчика случайных чисел.*/
    private static void matrixConstruction(int[][] arr, int k) {
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                arr[i][j] = random.nextInt(k * 2 + 1) - k;
            }
        }
    }

    private static void matrixOutput(int[][] arr) {
        System.out.println();
        for (int[] anArr : arr) {
            for (int j = 0; j < arr.length; j++) {
                System.out.print(anArr[j] + " ");
            }
            System.out.println();
        }
    }

    //9.1. Упорядочить строки (столбцы) матрицы в порядке возрастания значений.
    private static void matrixSort(int[][] arrSort) {
        int[][] arrSortString = arrSort;
        int[][] arrSortRow = arrSort;
        sortStringOfArray(arrSortString);
        System.out.println();
        System.out.println("Sort by string:");
        matrixOutput(arrSortString);

        rowToString(arrSortRow);
        sortStringOfArray(arrSortRow);
        rowToString(arrSortRow);
        System.out.println();
        System.out.println("Sort by row:");
        matrixOutput(arrSortRow);
    }

    private static void sortStringOfArray(int[][] arrSortString) {
        for (int[] anArrSortString : arrSortString) {
            Arrays.sort(anArrSortString);
        }
    }

    private static void rowToString(int[][] arrSortRow) {
        for (int i = 0; i < arrSortRow.length; i++) {
            for (int j = i + 1; j < arrSortRow.length; j++) {
                int temp = arrSortRow[i][j];
                arrSortRow[i][j] = arrSortRow[j][i];
                arrSortRow[j][i] = temp;
            }
        }
    }

    //9.2. Выполнить циклический сдвиг заданной матрицы на k позиций вправо (влево, вверх, вниз).
    private static void shiftOfMatrix(int[][] arr) {
        Scanner in = new Scanner(System.in);
        System.out.println("Where do you want to move the matrix? (enter: \"left\", \"right\", \"up\" or \"down\"): ");
        String shift = in.next();
        System.out.println("How many positions to make a shift?: ");
        int k = in.nextInt();
        switch (shift) {
            case "left":
                shiftToLeft(arr, k);
                matrixOutput(arr);
                break;
            case "right":
                leftToRight(arr);
                shiftToLeft(arr, k);
                leftToRight(arr);
                matrixOutput(arr);
                break;
            case "down":
                rowToString(arr);
                leftToRight(arr);
                shiftToLeft(arr, k);
                leftToRight(arr);
                rowToString(arr);
                matrixOutput(arr);
                break;
            case "up":
                rowToString(arr);
                shiftToLeft(arr, k);
                rowToString(arr);
                matrixOutput(arr);
                break;
        }
    }

    private static void shiftToLeft(int[][] arr, int k) {
        for (int i = 0; i < arr.length; i++) {
            int step = k % arr.length;
            while (step-- > 0) {
                int temp = arr[i][0];
                for (int j = arr.length - 1; j >= 0; j--) {
                    int tmp = arr[i][j];
                    arr[i][j] = temp;
                    temp = tmp;
                }
            }
        }
    }

    private static void leftToRight(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length / 2; j++) {
                int temp = arr[i][j];
                arr[i][j] = arr[i][arr.length - j - 1];
                arr[i][arr.length - j - 1] = temp;
            }
        }
    }

    //9.5. Повернуть матрицу на 90 (180, 270) градусов против часовой стрелки.
    private static void rotateOfMatrix(int[][] arr) {

    }
}