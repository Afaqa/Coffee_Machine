import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int max = 0;
        int next = scanner.nextInt();

        while (next != 0) {
            if (max < next) {
                max = next;
            }
            next = scanner.nextInt();
        }
        System.out.println(max);
    }
}