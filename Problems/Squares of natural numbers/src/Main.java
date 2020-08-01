import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        for (int nextSquare = 1; nextSquare * nextSquare <= n; nextSquare++) {
            System.out.println(nextSquare * nextSquare);
        }
    }
}