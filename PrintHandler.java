import java.util.LinkedList;

public class PrintHandler implements Handler {
    private final String title;

    public PrintHandler(String title) {
        this.title = title;
    }

    @Override
    public String commandTitle() {
        return this.title;
    }

    @Override
    public void handler(String[] arg, LinkedList<RobotMap.Robot> robots, RobotMap map) {
        for (RobotMap.Robot r : robots
        ) {
            System.out.printf("id - %d coords: %s%n", r.getId(), r.getPosition());
        }

    }
}
