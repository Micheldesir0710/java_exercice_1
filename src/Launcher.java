
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Launcher {
    public static void main (String[] args){
            System.out.println("Bienvenu:");
            Scanner scanner = new Scanner(System.in);
            List<Command> command = new ArrayList<>();
            command.add(new Fibo());
            command.add(new Freq());
            command.add(new Quit());
            String mot;
            boolean verif;
            while (true) {
                 mot = scanner.nextLine().toLowerCase().trim();
                 verif=false;
                 for (Command exec : command){
                     if(exec.name().equalsIgnoreCase(mot)){
                         if(exec.run(scanner)){
                             return;
                         }
                         verif = true;
                 }
        }
                 if(!verif){
                    System.out.println("Unknown command");
                }
        }
        }
    }

