class Tank extends Player {

    Tank(String name) {
        super(name);
        this.hp = 250;
        this.startHp = 250;
        this.damage = 30;
    }

    Tank(String name, double hp, double damage) {
        super(name);
        this.damage = damage;
        this.hp = hp;
        this.startHp = hp;
    }
    public void Attack(Player o) {
        if (hp != 0)
            o.hp -= damage;
    }
}