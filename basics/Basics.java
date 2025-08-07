import java.util.Scanner;

class Basics {
    public static void main(String args[]) {
        System.out.println("Hello World");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter You name: ");
        String name = scanner.nextLine();
        System.out.println("Your name is: " + name);
        scanner.close();
    }
}