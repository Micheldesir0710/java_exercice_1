import java.io.IOException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.nio.file.Files.readString;

public class Freq implements Command {
    public static void freq(String string) {
        FileSystem fs = FileSystems.getDefault();
        Path path = fs.getPath(string);
        try {
            String spath = readString(path);
            spath = spath.replaceAll("\\p{Punct}", " ");
            spath = spath.toLowerCase();
            if (!spath.isBlank()) {
                String[] str = spath.split(" ");
                Map<String, Long> tream = Arrays.stream(str).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
                Map<String, Long> finalt = new LinkedHashMap<>();
                tream.entrySet().stream().sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                        .forEachOrdered(e -> finalt.put(e.getKey(), e.getValue()));
                if (finalt.size() < 3) {
                    System.out.println("Erreur : il n'a pas assez de mots dans la phrase");
                } else {
                    int n = 0;
                    for (Map.Entry<String, Long> finalts : finalt.entrySet()) {
                        if (n == 3) {
                            break;
                        } else {
                            System.out.println(finalts.getKey());
                            n += 1;
                        }
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Unreadable file:groupingBy " + e + " " + e.getMessage());
        }
    }

    @Override
    public String name() {
        return "freq";
    }

    @Override
    public boolean run(Scanner in) {
        System.out.println("Tapez le chemin du fichier que vous voulez analyser:");
        String chemin = in.nextLine();
        freq(chemin);
        return false;
    }
}
