import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] commands = {"do not move", "move up", "move down", "move left", "move right", "error!"};
        int cmd = scanner.nextInt();

        if (cmd > 4 || cmd < 0) {
            cmd = 5;
        }
        System.out.println(commands[cmd]);
    }
}