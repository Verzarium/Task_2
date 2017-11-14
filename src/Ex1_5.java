import java.util.*;

public class Ex1_5 {

    public static void main(String[] args) {
        Scan scan = new Scan().invoke();
        int[] a = scan.getA();
        longestAndShortest(a);
        sortByLongestAndShortest(a);
        average(a);
        unDifDigit(a);
        evenOdd(a);
    }

    static class Scan {

        private int size;
        private int[] a;

        int[] getA() {
            return a;
        }

        Scan invoke() {
            Scanner in = new Scanner(System.in);
            System.out.print("Введите длину массива: ");
            size = in.nextInt();
            a = new int[size];
            System.out.println();
            System.out.print("Введите элементы массива: ");
            for (int i = 0; i < size; i++) {
                a[i] = in.nextInt();
            }
            return this;
        }
    }

    //1. Найти самое короткое и самое длинное число. Вывести найденные числа и их длину.
    private static void longestAndShortest(int[] a) {
        int max = a[0], min = a[0];
        for (int anA : a) {
            if (String.valueOf(anA).length() > String.valueOf(max).length()) {
                max = anA;
            } else if (String.valueOf(anA).length() < String.valueOf(min).length()) {
                min = anA;
            }
        }
        System.out.println();
        System.out.println("Самое короткое число: " + min + " Длина: " + String.valueOf(min).length());
        System.out.println("Самое длинное число: " + max + " Длина: " + String.valueOf(max).length());
    }

    //2. Упорядочить и вывести числа в порядке возрастания (убывания) значений их длины.
    private static void sortByLongestAndShortest(int[] a) {
        sortByLongest(a);
    }

    private static void sortByLongest(int[] a) {
        Arrays.sort(a);
        System.out.println("числа в порядке возрастания: " + Arrays.toString(a));
        sortByShortest(a);
    }

    private static void sortByShortest(int[] a) {
        for (int i = 0; a.length/2 > i; i++) {
            int tmp = a[i];
            a[i]= a[a.length-i-1];
            a[a.length-i-1]=tmp;
        }
        System.out.println("числа в порядке убывания: " + Arrays.toString(a));
    }

    //3. Вывести на консоль те числа, длина которых меньше (больше) средней, а также длину.
    private static void average(int[] a) {
        int average = 0;
        for (int anA : a) {
            average += String.valueOf(anA).length();
        }
        average = average / a.length;
        System.out.println("Числа, длина которых меньше средней: ");
        for (int anA : a) {
            if (String.valueOf(anA).length() < average) {
                System.out.println(anA + ", длина - " + String.valueOf(anA).length());
            }
        }
        System.out.println("Числа, длина которых больше средней: ");
        for (int anA : a) {
            if (String.valueOf(anA).length() > average) {
                System.out.println(anA + ", длина - " + String.valueOf(anA).length());
            }
        }
    }

    //4. Найти число, в котором число различных цифр минимально. Если таких чисел несколько, найти первое из них.
    private static void unDifDigit(int[] a) {
        ArrayList<String> result = new ArrayList<>();
        String winner = "";
        for (int i : a) {
            if (Integer.toString(i).length() < 11) {
                result.add(Integer.toString(i));
            }
        }
        int min = 11;
        for (String st : result) {
            if (uniqueNum(st) < min) {
                min = uniqueNum(st);
                winner = st;
            }
        }
        System.out.println("Number with minimal count of unique digit: " + winner);
    }

    private static int uniqueNum(String st) {
        int[] nums = new int[10];
        int count = 0;
        for (int i = 0; i < st.length(); i++) {
            nums[Character.getNumericValue(st.charAt(i))]++;
        }
        for (int i = 0; i < 10; i++) {
            if (nums[i] == 1) count++;
        }
        return count;
    }

    //5. Найти количество чисел, содержащих только четные цифры, а среди них количество чисел с равным числом четных и нечетных цифр.
    private static boolean countEvenAndOdd(String st) {
        int even = 0, odd = 0;
        for (int i = 0; i < st.length(); i++) {
            if (Character.getNumericValue(st.charAt(i)) % 2 == 0)
                even++;
            else odd++;
        }
        return even == odd;

    }

    private static void evenOdd(int[] args) {
        ArrayList<String> result = new ArrayList<>();
        for (int i : args) {
            if (i % 2 == 0) {
                result.add(Integer.toString(i));
            }
        }
        int count = 0;
        for (String st : result) {
            if (countEvenAndOdd(st)) {
                count++;
            }
        }
        System.out.println("count of numbers with equal number of even and odd: " + count);
    }
}
