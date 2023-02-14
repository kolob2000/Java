import org.jetbrains.annotations.NotNull;

import java.sql.Array;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        System.out.println(isSumBetween10And20(5, 15)); // true
        System.out.println(isSumBetween10And20(7, 15)); // false

        System.out.println(isPositive(5));

        printString("abcd", 5); //
        System.out.println(isLeapYear(2003));
        System.out.println(Arrays.toString(createArray(10, 15)));


        int[][] array = new int[4][4]; // [[1, 0, 0, 0], [0, 1, 0, 0], [0, 0, 1, x], [0, 0, 0, 1]]
        int x = array[2][3];

        String[] stringArray = {"aaa", "aab", "aa"};
        System.out.println(findCommonPrefix(stringArray)); // aa
        String[] stringArray2 = {"abc", "bca", "cda"};
        System.out.println(findCommonPrefix(stringArray2)); // ""

        int[] bitArray = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        System.out.println(Arrays.toString(bitArray));
        System.out.println(Arrays.toString(invertBitArray(bitArray)));

        int[] sixArray = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.println(Arrays.toString(multiplyElementBySixInArray(sixArray)));

        int[][] matrix = new int[5][5];
        for (int[] elem :
                fillMatrixDiagonalByOne(matrix)) {
            System.out.println(Arrays.toString(elem));

        }

        System.out.println(Arrays.toString(minMax(sixArray)));
    }

    private static @NotNull String findCommonPrefix(String[] source) {
        int sh = 0;
        for (int i = 1; i < source.length; i++) {
            if (source[sh].length() > source[i].length()) sh = i;
        }
        int count = 0;
        for (int i = 1; i <= source[sh].length(); i++) {
            boolean flag = true;
            for (String st : source) {
                if (!source[sh].regionMatches(0, st, 0, i)) {
                    flag = false;
                    break;
                }

            }
            if (flag) count++;

        }

        /** Найти общий префикс среди слов из одного массива.
         * ["aaa", "aab", "aa"] -> "aa", ["abc", "bca", "cda"] -> ""
         */
        return count != 0 ? source[sh].substring(0, count) : "";
    }


    /**
     * 1. Написать метод, принимающий на вход два целых числа и проверяющий,
     * что их сумма лежит в пределах от 10 до 20 (включительно), если да – вернуть true, в противном случае – false.
     */
    private static boolean isSumBetween10And20(int a, int b) {
        if (10 <= a + b && a + b <= 20) {
            return true;
        }
        return false;
    }

    private static boolean isPositive(int x) {
        // проверить, что х положительное
        if (x >= 0) return true;
        return false;
    }

    private static void printString(String source, int repeat) {
        // напечатать строку source repeat раз
        for (int i = 0; i < repeat; i++) {
            System.out.print(source);
        }
        System.out.print('\n');

    }

    private static boolean isLeapYear(int year) {
        // проверить, является ли год високосным. если да - return true
        if (year % 4 == 0) {
            return true;
        }
        return false;
    }

    private static int @NotNull [] createArray(int len, int initialValue) {
        // должен вернуть массив длины len, каждое значение которого равно initialValue
        int[] array = new int[len];
        Arrays.fill(array, initialValue);
        return array;
    }

    private static int[] invertBitArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = array[i] == 1 ? 0 : 1;
        }
        // * 1. Задать целочисленный массив, состоящий из элементов 0 и 1.
        //* Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ]. С помощью цикла и условия заменить 0 на 1, 1 на 0;
        return array;
    }

    private static int[] multiplyElementBySixInArray(int[] array) {
        // * 2. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему циклом, и числа меньшие 6 умножить на 2;

        for (int i = 0; i < array.length; i++) {
            if (array[i] < 6) array[i] = array[i] * 2;

        }
        return array;
    }

    private static int[][] fillMatrixDiagonalByOne(int[][] array) {
        /**
         * 3. Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое),
         * и с помощью цикла(-ов) заполнить его диагональные элементы единицами (можно только одну из диагоналей, если обе сложно).
         * Определить элементы одной из диагоналей можно по следующему принципу: индексы таких элементов равны, то есть [0][0], [1][1], [2][2], …, [n][n];
         */
        for (int i = 0; i < array.length; i++) {
            array[i][i] = 1;
            array[i][array.length - i - 1] = 1;
        }
        return array;
    }


    private static int[] minMax(int[] array) {
        int min = array[0];
        int max = array[0];
        for (int i = 0; i < array.length; i++) {
            if (min > array[i]) min = array[i];
            if (max < array[i]) max = array[i];
        }
        return new int[]{min, max};

    }
}