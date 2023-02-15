import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Ejercicio5 {
    public static void main(String[] args) throws IOException {
        if (args.length != 2) {
            System.out.println("Uso: QuitaComentarios PROGRAMA_ORIGINAL PROGRAMA_LIMPIO");
            System.exit(1);
        }

        File original = new File(args[0]);
        File limpio = new File(args[1]);

        try (BufferedReader reader = new BufferedReader(new FileReader(original));
             BufferedWriter writer = new BufferedWriter(new FileWriter(limpio))) {

            String linea;
            boolean comentario = false;
            while ((linea = reader.readLine()) != null) {
                int i = 0;
                while (i < linea.length()) {
                    char c = linea.charAt(i);
                    if (c == '/' && i + 1 < linea.length() && linea.charAt(i + 1) == '/') {
                        break;
                    } else if (c == '/' && i + 1 < linea.length() && linea.charAt(i + 1) == '*') {
                        comentario = true;
                        i++;
                    } else if (c == '*' && i + 1 < linea.length() && linea.charAt(i + 1) == '/') {
                        comentario = false;
                        i++;
                    } else if (!comentario) {
                        writer.write(c);
                    }
                    i++;
                }
                if (!comentario) {
                    writer.newLine();
                }
            }
            reader.close();
            writer.close();
        }catch(IOException e){
            System.out.println("e");
        }
    }
}

//:)