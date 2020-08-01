import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double money = scanner.nextInt();
        double percent = 1 + scanner.nextDouble() / 100d;
        double finalMoney = scanner.nextDouble();
        int years = 0;

        while (money < finalMoney) {
            money *= percent;
            years++;
        }
        System.out.println(years);
    }
}