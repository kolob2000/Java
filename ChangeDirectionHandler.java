import java.util.LinkedList;

public class ChangeDirectionHandler implements Handler {
    private final String title;

    public ChangeDirectionHandler(String title) {
        this.title = title;
    }

    @Override
    public String commandTitle() {
        return this.title;
    }

    @Override
    public void handler(String[] arg, LinkedList<RobotMap.Robot> robots, RobotMap map) {
        long id = Integer.parseInt(arg[0]);
        boolean robotExist = false;
        for (RobotMap.Robot r : robots
        ) {
            if (r.getId() == id) {
                r.changeDirection(RobotMap.Direction.valueOf(arg[1].toUpperCase()));
                robotExist = true;
                System.out.printf("Теперь я смотрю в(на) %s\n", arg[1]);
                break;
            }

        }
        if (!robotExist) System.out.println("Робот не существует!");

    }
}
