import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String str = input.nextLine();
        int start = input.nextInt();
        int end = input.nextInt();
        System.out.println(str.substring(start, end + 1));
    }
}
