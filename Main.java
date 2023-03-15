

public class Main {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_BLACK = "\u001B[30m";

    public static void main(String[] args) {
        // Представьте, что вы пишете класс Reder, который отвечает за вывод на экран текущего уровня жизней и усталости какого-то объекта.
        // (Подразумеваем, что вывод на экран - это просто печать в консоль)
        // У класса есть 1 метод, который принимает тип Object и делает следующее:
        // 1. Если object типа HasHealthPoint, то выводим его уровень жизни
        // 2. Если object типа Tiredness, то выводим его уровень усталости
        // При этом текст значения должен иметь цвет в соответствии с правилом:
        // BLACK(0, 24), RED(25, 50), GREEN(51-100)
        // 3. Создать несколько классов:
        // 3.1 Здание. Имеет только жизни.
        // 3.2 Персноаж. Имеет и жизни, и усталость


        Building building = new Building(100, 90);
        Person person = new Person(100, 73, 100, 55);

        Render render = new Render();
        render.render(building); // 40 - написано красным цветом
        render.render(person);
    }

    static class Render {

        public void render(Object object) {
            // TODO: 06.03.2023 Добавить реализацию
            System.out.println(object.getClass());
            if (object instanceof HasHealthPoint hasHealthPoint) {
                int count = 0;
                int health = ((HasHealthPoint) object).getCurrentHealthPoint();
                int maxHealth = ((HasHealthPoint) object).getMaxHealthPoint();
                System.out.print("Health: [ ");
                while (count <= health) {
                    if (count < 25) {
                        System.out.print(ANSI_BLACK + "#" + ANSI_RESET);
                    } else if (count < 51) {
                        System.out.print(ANSI_RED + "#" + ANSI_RESET);
                    } else {
                        System.out.print(ANSI_GREEN + "#" + ANSI_RESET);
                    }

                    count++;
                }
                while (count < maxHealth) {
                    System.out.print(" ");
                    count++;
                }
                System.out.println(" ]");


            }
            if (object instanceof Tiredness tiredness) {
                int count = 0;
                int energy = ((Tiredness) object).getCurrentEnergy();
                int maxEnergy = ((Tiredness) object).getMaxEnergy();
                System.out.print("Energy: [ ");
                while (count <= energy) {
                    if (count < 25) {
                        System.out.print(ANSI_BLACK + "*" + ANSI_RESET);
                    } else if (count < 51) {
                        System.out.print(ANSI_RED + "*" + ANSI_RESET);
                    } else {
                        System.out.print(ANSI_GREEN + "*" + ANSI_RESET);
                    }

                    count++;
                }
                while (count < maxEnergy) {
                    System.out.print(" ");
                    count++;
                }
                System.out.println(" ]");


            }
        }

    }

    interface HasHealthPoint {

        int getMaxHealthPoint();

        int getCurrentHealthPoint();

    }

    interface Tiredness {

        // Максимальное значение уровеня бодрости объекта
        int getMaxEnergy();

        // Текущее значение уровеня бодрости объекта
        int getCurrentEnergy();

    }

    static class Person implements HasHealthPoint, Tiredness {

        private final int maxHealthPoint;
        private final int currentHealthPoint;

        private final int maxEnergy;
        private final int currentEnergy;

        public Person(int maxHealthPoint, int currentHealthPoint,
                      int maxEnergy, int currentEnergy) {
            this.maxHealthPoint = maxHealthPoint;
            this.currentHealthPoint = currentHealthPoint;
            this.currentEnergy = currentEnergy;
            this.maxEnergy = maxEnergy;
        }

        @Override
        public int getMaxHealthPoint() {
            return maxHealthPoint;
        }

        @Override
        public int getCurrentHealthPoint() {
            return currentHealthPoint;
        }

        @Override
        public int getMaxEnergy() {
            return maxEnergy;
        }

        @Override
        public int getCurrentEnergy() {
            return currentEnergy;
        }
    }

    static class Building implements HasHealthPoint {

        private final int maxHealthPoint;
        private final int currentHealthPoint;

        public Building(int maxHealthPoint, int currentHealthPoint) {
            this.maxHealthPoint = maxHealthPoint;
            this.currentHealthPoint = currentHealthPoint;
        }

        @Override
        public int getMaxHealthPoint() {
            return maxHealthPoint;
        }

        @Override
        public int getCurrentHealthPoint() {
            return currentHealthPoint;
        }
    }

}
