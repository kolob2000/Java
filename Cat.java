import java.util.Random;

public class Cat {

    private final String name;
    private final int appetite;
    int satiety = 10;

    public Cat(String name) {
        this(name, 10);
//        this.name = name;
//        this.appetite = 10;
//        satiety = false;
    }

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;

        Thread backgroundSatietyManagement = new Thread(() -> {
            while (true) {
                satiety--;
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        backgroundSatietyManagement.setDaemon(true);
        backgroundSatietyManagement.start();
    }

    public void eat(Plate plate) {
        if (satiety < 10) {
            int difference = appetite - satiety;
            if (plate.getFood() >= difference) {
                plate.decreaseFood(difference);
                satiety += difference;

            }
        }
    }

    public void makeHungry() {
        Random rand = new Random();

        satiety -= rand.nextInt(1, 10);
    }

    @Override
    public String toString() {
        return name + "{appetite=" + appetite + ", satiety=" + satiety + "}";
    }
}
