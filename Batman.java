class Batman extends Player {
    Batman(String name) {
        super(name);
        this.hp = 200;
        this.startHp = 200;
        this.damage = 18;
    }

    Batman(String name, double hp, double damage) {
        super(name);
        this.damage = damage;
        this.hp = hp;
        this.startHp = hp;
    }
}