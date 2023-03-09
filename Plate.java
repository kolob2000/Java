import java.util.Random;

public class Plate {

    private int food;

    public int getFood() {
        return this.food;
    }

    public Plate(int food) {
        this.food = food;
    }

    public boolean decreaseFood(int foodToDecrease) {
        if (food >= foodToDecrease) {
            food = food - foodToDecrease;
            return true;
        }

        return false;
    }

    public void increaseFood() {
        Random rand = new Random();
        int doze = rand.nextInt(0, 200 - food);
        food += doze;
    }

    @Override
    public String toString() {
        return "Plate[" + food + "]";
    }

    public boolean isEmpty() {
        return this.food < 0;
    }
}
