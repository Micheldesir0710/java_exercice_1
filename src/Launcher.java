import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class Launcher {
    public static long fibo(int nombre)
    {
        if(nombre ==0)
        {
            return 0;
        } else if (nombre==1) {
            return 1;
        }
        else {
            return fibo(nombre-1) + fibo(nombre-2);
        }
    }
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bienvenu: ");
        String mot = scanner.nextLine();
        while(!mot.equals("quit"))
        {
            if (mot.equals("fibo"))
            {
                System.out.println("Choissez un nombre n");
                String nombre = scanner.nextLine();
                int inombre = parseInt(nombre);
                System.out.println(fibo(inombre));
            }
            else {
                System.out.println("Unknown command");
            }
            System.out.println("Bienvenu: ");
            mot = scanner.nextLine();
        }
        scanner.close();
    }
}
