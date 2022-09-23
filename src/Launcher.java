import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.nio.file.*;
import java.util.function.Function;
import java.util.stream.Collectors;


import static java.lang.Integer.parseInt;
import static java.nio.file.Files.readString;

public class Launcher {
    private static long fibo(int nombre)
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
    public static void freq(String string) {
        FileSystem fs = FileSystems.getDefault();
        Path path = fs.getPath(string);
        try {
            String spath = readString(path);
            spath = spath.replaceAll("\\p{Punct}", " ");
            spath = spath.toLowerCase();
            if (!spath.isBlank()) {
                String[] str = spath.split(" ");
                Map<String, Long> tream = Arrays.stream(str).collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
                Map<String, Long> finalt = new LinkedHashMap<>();
                tream.entrySet().stream().sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                        .forEachOrdered(e -> finalt.put(e.getKey(), e.getValue()));
                if(finalt.size()<3)
                {
                    System.out.println("Erreur : il n'a pas assez de mots dans la phrase");
                }
                else {
                    int n=0;
                    for (Map.Entry<String,Long> finalts : finalt.entrySet())
                    {
                        if(n==3) {
                            break;
                        }
                        else{
                            System.out.println(finalts.getKey());
                            n+=1;
                        }
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Unreadable file:groupingBy " + e + " " + e.getMessage());
        }

    }

        public static void main (String[] args){
            Scanner scanner = new Scanner(System.in);
            System.out.println("Bienvenu:");
            String mot = scanner.nextLine();
            while (!mot.equals("quit")) {
                if (mot.equals("fibo")) {
                    System.out.println("Choissez un nombre n");
                    String nombre = scanner.nextLine();
                    int inombre = parseInt(nombre);
                    System.out.println(fibo(inombre));
                } else if (mot.equals("freq")) {
                    System.out.println("Tapez le chemin du fichier que vous voulez analyser:");
                    String chemin = scanner.nextLine();
                    freq(chemin);
                }
             else{
                System.out.println("Unknown command");
            }
            mot = scanner.nextLine();
        }
        scanner.close();
        }
    }

