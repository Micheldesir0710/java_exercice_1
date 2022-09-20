import java.util.Scanner;

public class Launcher {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bienvenu: ");
        String mot = scanner.nextLine();
        while(!mot.equals("quit"))
        {
            System.out.println("Unknown command");
            System.out.println("Bienvenu: ");
            mot = scanner.nextLine();
        }
        scanner.close();
    }
}
