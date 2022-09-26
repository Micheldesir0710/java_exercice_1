import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class Fibo implements Command {
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

    @Override
    public String name() {
        return "fibo";
    }

    @Override
    public boolean run(Scanner in) {
        try {
            System.out.println("Choissez un nombre n");
            String nombre = in.nextLine();
            int inombre = parseInt(nombre);
            System.out.println(fibo(inombre));
        }catch(StackOverflowError e)
        {
            System.out.println("Nombre trop grand");
        }
        return false;
    }
}
