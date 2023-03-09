public class Player {
    private static long count = 1;

    private static long getID() {
        return count++;
    }


    /**
     * * У класса должен быть конструктор, который принимает только name.
     * * Идентификатор присваивается автоматически из последовательности (1, 2, ...)
     * * Каждый класс должен уметь "бить" другого Player'а void attack(Player player)
     * * -> player1.attack(player2) Внутри метода игрок,
     * * на котором вызван метод уменьшает здоровье игрока,
     * * который передан в метод Придумать несколько классов с
     * * разными параметрами жизней и атаки по-умолчанию Player player = new Tank("name");
     */
    long id;
    String name;
    double damage;
    double hp;

    double startHp;

    Player(String name) {
        this.id = getID();
        this.name = name;
    }

    public void attack(Player o) {
        if (hp != 0)
            o.hp -= (damage * (hp / startHp));
    }

    @Override
    public String toString() {
        return String.format("id:%d name:%s hp:%.2f damage:%.2f", id, name, hp, damage);
    }
}
