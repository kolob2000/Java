public class Main {
    public static void main(String[] args) {


        Box<Apple> boxApple = new Box<>();
        Box<GoldenApple> boxGoldenApple = new Box<>();
        Box<Orange> boxOrange = new Box<>();


        boxApple.add(new Apple(1));
        boxApple.add(new Apple(2));
        boxApple.add(new Apple(3));
        boxApple.add(new Apple(4));

        boxGoldenApple.add(new GoldenApple(5));
        boxGoldenApple.add(new GoldenApple(6));
        boxGoldenApple.add(new GoldenApple(7));
        boxGoldenApple.add(new GoldenApple(8));

        boxOrange.add(new Orange(9));
        boxOrange.add(new Orange(10));
        boxOrange.add(new Orange(11));
        boxOrange.add(new Orange(12));

        System.out.println(boxApple);
        System.out.println(boxGoldenApple);
        System.out.println(boxOrange);

        boxApple.addToBox(boxGoldenApple, 3);
        boxGoldenApple.moveToBox(boxApple, 3);
        // Error - boxApple.moveToBox(boxGoldenApple, 3);
        // Error - boxGoldenApple.moveToBox(boxOrange, 3);
        // Error - boxOrange.moveToBox( boxGoldenApple , 3);

        System.out.println(boxApple);
        System.out.println(boxGoldenApple);
        System.out.println(boxOrange);

        for (Object el : boxOrange
        ) {
            System.out.println(el);

        }


    }

}

