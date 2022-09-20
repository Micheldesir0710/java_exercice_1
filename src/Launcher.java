import java.util.Scanner;

public class Launcher {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bienvenu: ");
        String mot = scanner.nextLine();
        if(mot.equals("quit"))
        {
            scanner.close();
        }
        else {
            System.out.println("Unknown command");
            scanner.close();
        }
    }
}
