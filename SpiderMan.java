class SpiderMan extends Player {
    SpiderMan(String name) {
        super(name);
        this.hp = 150;
        this.startHp = 150;
        this.damage = 15;
    }

    SpiderMan(String name, double hp, double damage) {
        super(name);
        this.damage = damage;
        this.hp = hp;
        this.startHp = hp;
    }
}