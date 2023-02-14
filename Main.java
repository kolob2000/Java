import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.sql.Array;
import java.util.Arrays;
import java.util.Objects;

public class Main {

    public static void main(String[] args) {

        writeTest100Times();
        System.out.println(isPalindrome("шалаш"));
        System.out.println(isPalindrome("алкаш"));
    }

    private static void writeTest100Times() {
        Path file = Path.of("file.txt");
        if (!Files.exists(file)) {
            try {
                Files.createFile(file);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        try {
            Files.writeString(file, "TEST\n");
            for (int i = 0; i < 99; i++) {
                Files.writeString(file, "TEST\n", StandardOpenOption.APPEND);

            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static boolean isPalindrome(String str) {
        boolean isP = true;
        for (int i = 0; i < str.length() / 2; i++) {
            if (!Objects.equals(str.charAt(i), str.charAt(str.length() - i - 1))) {
                isP = false;
                break;
            }
        }

        return isP;
    }
}