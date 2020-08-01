import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        char prefix = input.nextLine().charAt(0);
        if (prefix == 'j' || prefix == 'J') {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }
}