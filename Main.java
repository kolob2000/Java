import java.sql.Array;


public class Main {

    public static void main(String[] args) throws InterruptedException {
        /**
         * Создать класс Player с полями id (long),
         * name (String), damage (double) healthPoint (hp) (double)
         * У класса должен быть конструктор, который принимает только name.
         * Идентификатор присваивается автоматически из последовательности (1, 2, ...)
         * Каждый класс должен уметь "бить" другого Player'а void attack(Player player)
         * -> player1.attack(player2) Внутри метода игрок,
         * на котором вызван метод уменьшает здоровье игрока,
         * который передан в метод Придумать несколько классов с
         * разными параметрами жизней и атаки по-умолчанию Player player = new Tank("name");
         * *2 Придумать, все, что захочется и обогатить проект
         * 3Понасоздавать объектов и стравить их друг с другом
         *
         *
         * */
        Player tank = new Tank("T-90");
        Player batman = new Batman("Batman");
        Player robin = new Batman("Robin");
        Player spiderMan = new SpiderMan("Peter");
        Player alesha = new Warrior("Alesha");
        Player max = new Warrior("Max");

        System.out.println(tank);
        System.out.println(batman);
        batman.attack(tank);
        tank.attack(batman);
        System.out.println(tank);
        System.out.println(batman);
        System.out.println();
/////////////////////////////////////////////////////////
        System.out.println(robin);
        System.out.println(alesha);
        robin.attack(alesha);
        alesha.attack(robin);
        System.out.println(robin);
        System.out.println(alesha);
        System.out.println();
/////////////////////////////////////////////////////////
        System.out.println(spiderMan);
        System.out.println(max);
        spiderMan.attack(max);
        max.attack(spiderMan);
        System.out.println(spiderMan);
        System.out.println(max);

    }
}