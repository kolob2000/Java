import java.lang.reflect.InvocationHandler;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

class Main {

    // Client <-> API <-> Model
    // Client_2

    public static void main(String[] args) {

        String menu = """
                Введите команду -
                create-robot x y | move-robot id | change-direction id LEFT | print | exit
                """;
        Scanner sc = new Scanner(System.in);
        RobotMap map = null;
        LinkedList<RobotMap.Robot> robots = new LinkedList<>();
        CommandHandler commandHandler = null;

        while (true) {
            if (map == null) {
                System.out.println("Введите команду для создания карты: create-map w h  или exit");
                String command = sc.nextLine();
                if (command.equalsIgnoreCase("exit")) break;
                if (command.startsWith("create-map")) {
                    String[] split = command.split(" "); // [create-map 3 5]
                    String[] arguments = Arrays.copyOfRange(split, 1, split.length); // [3 5]

                    try {
                        map = new RobotMap(Integer.parseInt(arguments[0]), Integer.parseInt(arguments[1]));
                        commandHandler = new CommandHandler(map);
                        commandHandler.add(new CreateRobotHandler("create-robot"));
                        commandHandler.add(new ChangeDirectionHandler("change-direction"));
                        commandHandler.add(new MoveRobotHandler("move-robot"));
                        commandHandler.add(new PrintHandler("print"));
                        System.out.println("ИГРАЕМ...");
                    } catch (IllegalArgumentException e) {
                        System.out.println("При создании карты возникло исключение: " + e.getMessage() + "." +
                                " Попробуйте еще раз");
                    }
                }
            } else {
                System.out.println(menu);

                String command = sc.nextLine();
                if (command.equalsIgnoreCase("exit")) break;
                if (commandHandler != null) {
                    commandHandler.executeCommand(command, robots);
                }

            }


        }

    }
}
