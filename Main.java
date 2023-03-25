import java.lang.reflect.InvocationHandler;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {

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
        while (true) {
            if (map == null) {
                System.out.println("Введите команду для создания карты: create-map x y  или exit");
            } else {
                System.out.println(menu);
            }
            String command = sc.nextLine();
            if (command.startsWith("create-map")) {
                String[] split = command.split(" "); // [create-map 3 5]
                String[] arguments = Arrays.copyOfRange(split, 1, split.length); // [3 5]

                try {
                    map = new RobotMap(Integer.parseInt(arguments[0]), Integer.parseInt(arguments[1]));
                    System.out.println("ИГРАЕМ...");
                } catch (IllegalArgumentException e) {
                    System.out.println("При создании карты возникло исключение: " + e.getMessage() + "." +
                            " Попробуйте еще раз");
                }
            } else if (command.toLowerCase().startsWith("create-robot")) {
                if (map != null) {
                    String[] split = command.split(" "); // [create-map 3 5]
                    String[] arg = Arrays.copyOfRange(split, 1, split.length);
                    try {
                        robots.add(map.createRobot(new Point(Integer.parseInt(arg[0]), Integer.parseInt(arg[1]))));
                        System.out.println("Робот создан!");
                    } catch (PositionException e) {
                        System.out.println("Ошибка в данной  точке уже находится роброт");
                    }

                } else {
                    System.out.println("Карта не создана");
                }
            } else if (command.toLowerCase().startsWith("change-direction")) {
                if (map != null) {
                    String[] split = command.split(" "); // [create-map 3 5]
                    String[] arg = Arrays.copyOfRange(split, 1, split.length);
                    long id = Integer.parseInt(arg[0]);
                    boolean robotExist = false;
                    for (RobotMap.Robot r : robots
                    ) {
                        if (r.getId() == id) {
                            r.changeDirection(RobotMap.Direction.valueOf(arg[1].toUpperCase()));
                            robotExist = true;
                            System.out.printf("Теперь я смотрю в(на) %s", arg[1]);
                            break;
                        }

                    }
                    if (!robotExist) System.out.println("Робот не существует!");


                } else {
                    System.out.println("Карта не создана");
                }

            } else if (command.toLowerCase().startsWith("move-robot")) {
                if (map != null) {
                    String[] split = command.split(" "); // [create-map 3 5]
                    String[] arg = Arrays.copyOfRange(split, 1, split.length);
                    long id = Integer.parseInt(arg[0]);
                    boolean robotExist = false;
                    for (RobotMap.Robot r : robots
                    ) {
                        if (r.getId() == id) {
                            try {
                                r.move();
                                robotExist = true;
                                System.out.printf("Шагнул..");
                                break;
                            } catch (PositionException e) {
                                System.out.println("Не могу, там другой робот!");
                            }

                        }

                    }
                    if (!robotExist) System.out.println("Робот не существует!");


                } else {
                    System.out.println("Карта не создана");
                }

            } else if (command.equalsIgnoreCase("exit")) {
                break;
            } else if (command.equalsIgnoreCase("print")) {
                if (map != null) {
                    for (RobotMap.Robot r : robots
                    ) {
                        System.out.printf("id - %d coords: %s%n", r.getId(), r.getPosition());
                    }
                } else {
                    System.out.println("Карта не создана");
                }
            } else {
                System.out.println("Команда не найдена. Попробуйте еще раз");
            }
            System.out.println();
        }


    }

}
