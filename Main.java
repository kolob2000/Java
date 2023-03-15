import java.util.*;
import java.util.stream.IntStream;

public class Main {


    public static void main(String[] args) {
        List<Notebook> notebooks = new LinkedList<>();
        IntStream.range(0, 10)
                .map(i -> i)
                .forEach(i -> notebooks.add(new Notebook(genName(), genMemory(), genPrice())));

        separator();
        printNotebooks(notebooks);
        separator();
        Collections.sort(notebooks);
        printNotebooks(notebooks);
        separator();

        notebooks.sort((Notebook a, Notebook b) -> a.price - b.price);
        printNotebooks(notebooks);
        separator();
        notebooks.sort((Notebook a, Notebook b) -> b.price - a.price);
        printNotebooks(notebooks);
        separator();

        notebooks.sort((Notebook a, Notebook b) -> a.memory - b.memory);
        printNotebooks(notebooks);
        separator();

    }

    static class Notebook implements Comparable<Notebook> {
        private final String name;
        int memory;
        int price;

        public Notebook(String name, int memory, int price) {

            this.name = name;
            this.memory = memory;
            this.price = price;
        }

        @Override
        public String toString() {
            return String.format("| %-10s | %-5s | %-8s |", name, memory, price);
        }

        @Override
        public int compareTo(Notebook o) {
            return Integer.compare(this.name.compareTo(o.name), 0);
        }
    }

    public static String genName() {
        LinkedList<String> name = new LinkedList<>(List.of(
                "MSI", "LENOVO", "SONY", "HP", "TOSHIBA", "HUAWEI", "XIAOMI",
                "DELL", "APPLE", "SAMSUNG", "ASUS", "ACER"
        ));
        int index = new Random().nextInt(0, name.size());
        return name.get(index);
    }

    public static int genPrice() {
        return new Random().nextInt(40000, 150000);
    }

    public static int genMemory() {
        return new Random().nextInt(2, 128);
    }

    public static void separator() {
        for (int i = 0; i < 33; i++) {
            System.out.print("#");
        }
        System.out.println();

    }

    public static <T extends Notebook> void printNotebooks(List<T> list) {

        for (Notebook n : list
        ) {
            System.out.println(n);
        }
    }
}

