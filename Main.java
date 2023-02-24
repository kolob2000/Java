import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.sql.Array;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        strParser();

    }

    public static void strParser() {
        Scanner sc = new Scanner(System.in);
        LinkedList<String> strList = new LinkedList<>();
        while (true) {
            String str = sc.nextLine();
            if (str.trim().equalsIgnoreCase("exit")) return;
            String[] splitStrArray = str.split("~");
            if (splitStrArray[0].equals("print") && strList.size() >= Integer.parseInt(splitStrArray[1])) {
                System.out.println(strList.get(Integer.parseInt(splitStrArray[1])));
                strList.add(Integer.parseInt(splitStrArray[1]), null);
            } else {
                int size = strList.size();
                while (strList.size() < Integer.parseInt(splitStrArray[1])) {
                    strList.add(size, null);
                    size++;
                }
                strList.add(Integer.parseInt(splitStrArray[1]), splitStrArray[0]);
            }

        }
    }

}