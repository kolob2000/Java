class Warrior extends Player {
    Warrior(String name) {
        super(name);
        this.hp = 100;
        this.startHp = 100;
        this.damage = 10;
    }

    Warrior(String name, double hp, double damage) {
        super(name);
        this.damage = damage;
        this.hp = hp;
        this.startHp = hp;
    }
}