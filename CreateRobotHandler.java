import java.util.LinkedList;

public class CreateRobotHandler implements Handler {
    private String title;

    public CreateRobotHandler(String title) {
        this.title = title;
    }

    @Override
    public String commandTitle() {
        return this.title;
    }

    @Override
    public void handler(String[] arg, LinkedList<RobotMap.Robot> robots, RobotMap map) {
        try {
            robots.add(map.createRobot(new Point(Integer.parseInt(arg[0]), Integer.parseInt(arg[1]))));
            System.out.println("Робот создан!");
        } catch (PositionException e) {
            System.out.println("Ошибка в данной  точке уже находится роброт");
        }

    }
}
