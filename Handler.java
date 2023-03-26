import java.util.Arrays;
import java.util.LinkedList;

public interface Handler {
    String commandTitle();

    void handler(String[] arguments, LinkedList<RobotMap.Robot> robots, RobotMap map);
}
