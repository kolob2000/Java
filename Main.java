import java.sql.Array;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        // Кот (имя, аппетит, сытность)
        // Тарелка (содержит какое-то количество еды)
        // Кот ест из тарлеки. Если в тарелке недостаточно еды - кот ее не трогает

        // ДЗ:
        // while (true) -> while (!plate.isEmpty())
        // 1. Создать массив котов. Пусть все коты из массива по очереди едят из одной тарелки.
        // В конце каждого цикла мы досыпаем в тарелку еду.
        // Для досыпания еды сделать метод increaseFood в классе Plate.
        // 2. Поменять поле satiety у кота с boolean на int.
        // Допустим у кота апптит 10, сытность 3. Значит кот захочет поесть 7 единиц.
        // 3. * Доработать поток thread в классе Cat, чтобы он каждую секунду уменьшал сытость кота на 1.

        Cat[] Cats = new Cat[5];
        Cats[0] = new Cat("Murzik");
        Cats[1] = new Cat("Barsik");
        Cats[2] = new Cat("Vaska");
        Cats[3] = new Cat("Pushok");
        Cats[4] = new Cat("Chaka");


        Plate plate = new Plate(200);
        System.out.printf(plate.toString());
        while (!plate.isEmpty()) {
            for (Cat cat : Cats
            ) {
                cat.eat(plate);
                cat.makeHungry();
            }
            plate.increaseFood();
            System.out.println(plate);
            Thread.sleep(1000);

        }


    }

}