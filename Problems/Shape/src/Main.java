import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] shapes = {"square", "circle", "triangle", "rhombus"};
        int shapeId = scanner.nextInt();

        if (shapeId < 1 || shapeId > 4) {
            System.out.println("There is no such shape!");
        } else {
            System.out.println("You have chosen a " + shapes[shapeId - 1]);
        }
    }
}