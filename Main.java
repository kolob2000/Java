import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.sql.Array;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        System.out.println(correctParenthesis("(([]))<>()"));
        System.out.println(correctParenthesis(">(([]))<>()"));
        System.out.println(correctParenthesis("(([]))<>>(()"));
    }

    public static boolean isClosed(Character ch) {
        List<Character> closed = Arrays.asList(')', ']', '}', '>');
        return closed.contains(ch);
    }

    public static boolean correctParenthesis(String s) {
        HashMap<Character, Character> brackets = new HashMap<>();
        brackets.put(')', '(');
        brackets.put(']', '[');
        brackets.put('}', '{');
        brackets.put('>', '<');
        Stack<Character> stack = new Stack<>();
        for (Character ch : s.toCharArray()) {
            if (isClosed(ch)) {
                if (stack.size() == 0) return false;
                if (brackets.get(ch) == stack.lastElement()) {
                    stack.pop();
                } else {
                    return false;
                }

            } else {
                stack.push(ch);
            }
        }
        return stack.size() == 0;

    }
}