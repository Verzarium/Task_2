import java.util.Scanner;

public class Ex8 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter matrix-side value: ");
        int side = in.nextInt();
        int[][] arr = new int[side][side];
        int k = 1;
        System.out.println();
        for (int i = 0; i < side; i++) {
            for (int j = 0; j < side; j++) {
                arr[i][j] = k++;
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
