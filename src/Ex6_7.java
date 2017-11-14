
import java.util.ArrayList;
import java.util.Scanner;

public class Ex6_7 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите элементы массива: ");
        String[] nums = in.nextLine().split("\\s+");
        ArrayList<Integer> a = new ArrayList<Integer>();
        for (int i = 0; i < nums.length; i++) {
            a.add(Integer.parseInt(nums[i]));
        }
        arithmeticProgression(a);
        onlyDifDigits(a);
    }
        //6. Найти число, цифры в котором идут в строгом порядке возрастания. Если таких чисел несколько, найти первое из них.
    private static boolean ascendingNum (String st) {
        for (int i = 0; i < st.length(); i++) {
            for (int j = i+1; j < st.length(); j++) {
                if (Character.getNumericValue(st.charAt(i)) > Character.getNumericValue(st.charAt(j))) {
                    return false;
                }
            }
        }
        return true;
    }
    private static void arithmeticProgression(ArrayList<Integer> args) {
        ArrayList<String> result = new ArrayList<String>();
        for (int i:args) {
            if (i > 9) {
                result.add(Integer.toString(i));
            }
        }
        for (String st:result) {
            if (ascendingNum(st)) {
                System.out.println("Number with digits in arithmetic progression: " + st);
                break;
            }
        }
    }

    //7. Найти число, состоящее только из различных цифр. Если таких чисел несколько, найти первое из них.
    private static void onlyDifDigits(ArrayList<Integer> args) {
        ArrayList<String> result = new ArrayList<String>();
        for (String st:result) {
            if (difDigits(st)) {
                System.out.println("Number with only different digits: " + st);
                break;
            }
        }
    }
    private static boolean difDigits(String st) {
        for (int i = 0; i < st.length(); i++) {
            for (int j = i+1; j < st.length(); j++) {
                if (Character.getNumericValue(st.charAt(i)) == Character.getNumericValue(st.charAt(j))) {
                    return false;
                }
            }
        }
        return true;
    }
}
