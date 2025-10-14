//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args) {
        Utils.printThreeWords();
        Utils.checkSumSign();
        Utils.printColour();
        Utils.compareNumbers();
        System.out.println(Utils.checkSum());
        Utils.printIsPositive(-30);
        System.out.println(Utils.isPositive(-50));
        Utils.printString(20, "хело ворд");
        System.out.println(Utils.isLeapYear(1300));
        Utils.integerArray();
        Utils.nullArray();
        Utils.multiply();
        Utils.doubleArray();
        Utils.createArray(2, 20);
    }
}

class Utils {
    public static void printThreeWords() {
        System.out.println("Orange");
        System.out.println("Banana");
        System.out.println("Apple");

    }

    public static void checkSumSign() {
        int a = 2;
        int b = 10;

        if ( (a + b) >= 0 ) {
            System.out.println("Сумма положительная");
        } else {
            System.out.println("Сумма отрицательная");
        }
    }

    public static void printColour() {
        int value = 50;
        if ( value <= 0 ) {
            System.out.println("Красный");
        } else if ( (0 < value) &&  (value <= 100) ) {
            System.out.println("Желтый");
        } else if ( value > 100 ) {
            System.out.println("Зеленый");
        }
    }

    public static void compareNumbers() {
        int a = 5;
        int b = 10;
        if ( a >= b ) {
            System.out.println("a >= b");
        } else {
            System.out.println("a < b");
        }
    }

    public static boolean checkSum() {
        int a = 7;
        int b = 8;
        int c = a + b;
        if ( (c >= 10) && (c <= 20)) {
            return true;
        } else {
            return false;
        }
    }

    public static void printIsPositive(int a) {
        if ( a >= 0 ) {
            System.out.println("Положительное");
        } else {
            System.out.println("Отрицательное");

        }
    }

    public static boolean isPositive(int a) {
        if ( a >= 0 ) {
            return true;
        } else {
            return false;

        }
    }

    public static void printString(int a, String b) {
            for ( int i = 0; i < a; i++ ) {
                System.out.println(b);
            }
    }

    public static boolean isLeapYear(int year) {
        if (year % 400 == 0) {
            return true;
        } else if (year % 100 == 0) {
            return false;
        } else {
            return year % 4 == 0;
        }
    }

    public static void integerArray() {
        int[] arr = new int [] {0, 1, 0, 1, 0, 0, 0};

        for(int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) {
                arr[i] = 0;
            } else if (arr[i] == 0) {
                arr[i] = 1;
            }
            System.out.println(arr[i]);
        }
    }

    public static void nullArray() {
        int[] arrs = new int[100];
        for (int i = 0; i < arrs.length; i++) {
            arrs[i] = i+1;
            System.out.println(arrs[i]);

        }
    }

    public static void multiply() {
        int[] arr = new int[]{1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 6) {
                arr[i] = 2 * arr[i];
            }
            System.out.println(arr[i]);
        }
    }

    public static void doubleArray() {
        int[][] nums = new int[2][2];
        for (int i = 0; i < nums.length; i++) {
            nums[i][i] = 1;
        }
    }

    public static int[] createArray(int len, int initialValue) {
        int[] result = new int[len];
        for (int i = 0; i < result.length; i++) {
            result[i] = initialValue;
        }
        return result;
    }

}

