import java.util.*;

public class CommandHandler {
    private final LinkedList<Handler> handlers = new LinkedList<>();
    private RobotMap map;

    public CommandHandler(RobotMap map) {
        this.map = map;
    }

    public void add(Handler handler) {
        handlers.add(handler);
    }

    public void executeCommand(String command, LinkedList<RobotMap.Robot> robots) {
        boolean isAbsent = true;
        for (Handler h : handlers
        ) {
            if (command.startsWith(h.commandTitle())) {
                String[] split = command.split(" "); // [create-map 3 5]
                String[] arguments = Arrays.copyOfRange(split, 1, split.length);
                h.handler(arguments, robots, map);
                isAbsent = false;
                break;
            }
        }
        if (isAbsent) System.out.println("Действие отсутствует");

    }
}
