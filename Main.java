import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.sql.Array;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        ArrayList<Integer> array = new ArrayList<Integer>();
        for (int i = 0; i < 20; i++) {
            array.add(new Random().nextInt(20));
        }
        System.out.println(array.toString() + " origin list");
        System.out.println(minMaxAvgFromList(array).toString() + " <- min max avg");
        array.removeIf(i -> i % 2 == 0);
        System.out.println(array.toString() + " odd list");
    }

    private static ArrayList<Integer> minMaxAvgFromList(ArrayList<Integer> list) {
        int min = list.get(0);
        int max = min;
        int avg = 0;
        for (int i = 0; i < list.size(); i++) {
            int current = list.get(i);
            if (min > current) {
                min = current;
            }
            if (max < current) {
                max = current;
            }
            avg += current;
        }
        return new ArrayList<>(List.of(min, max, avg));
    }

}