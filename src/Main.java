public class Main {

    static void main(String[] args) {
        String[][] arr = new String[4][4];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (j % 2 == 0) {
                    arr[i][j] = "1";
                } else {
                    arr[i][j] = "8";
                }
            }
        }
        try {
            int sum = sumTwoDimensionsArray(arr);
            System.out.println(sum);
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println(e.getMessage());
        }

        generateAndCatchOob(arr);
    }

    public static int sumTwoDimensionsArray(String[][] args) {
        int rows = args.length;
        int columns = args[0].length;
        int sum = 0;
        if (rows != 4 || columns != 4) {
            throw new MyArraySizeException("Массив не формата 4х4");
        }
        for (int i = 0; i < args.length; i++) {
            for (int j = 0; j < args[0].length; j++) {
                try {
                    sum += Integer.parseInt(args[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(
                            "В ячейке с индексом " + i
                            + " " + j
                            + " лежит символ или текст вместо числа"
                    );
                }
            }
        }
        return sum;
    }

    public static void generateAndCatchOob(String[][] arr) {
        try {
            System.out.println(arr[arr.length][arr[0].length]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("exception e was caught");
        }
    }
}