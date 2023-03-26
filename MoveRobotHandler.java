import java.util.LinkedList;

public class MoveRobotHandler implements Handler {
    private final String title;

    public MoveRobotHandler(String title) {
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
                            try {
                                r.move();
                                robotExist = true;
                                System.out.println("Шагнул..");
                                break;
                            } catch (PositionException e) {
                                System.out.println("Не могу, там другой робот!");
                            }

                        }

                    }
                    if (!robotExist) System.out.println("Робот не существует!");

    }
}
