import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;

/*Realiza un programa que sea capaz de ordenar alfabéticamente las palabras
contenidas en un fichero de texto. El nombre del fichero que contiene las
palabras se debe pasar como argumento en la línea de comandos. El nombre
del fichero resultado debe ser el mismo que el original añadiendo la coletilla
sort, por ejemplo palabras_sort.txt. Suponemos que cada palabra ocupa una
línea */
public class Ejercicio4 {
    public static void main(String[] args) {
         if(args.length<1){
            return;
         }
         try {
            ArrayList<String> palabras=new ArrayList<>();
            BufferedReader br=new BufferedReader(new FileReader(args[0]));
            String word;
            while((word=br.readLine())!=null){
                palabras.add(word);
            }
            br.close();
            Collections.sort(palabras);
            String filesorted=((args[0].lastIndexOf(".txt"))!=-1?args[0].substring(0,args[0].lastIndexOf(".txt")):args[0])+"_sorted.txt";
            BufferedWriter bw = new BufferedWriter(new FileWriter(filesorted));
            for(String w:palabras){
                bw.write(w+"\n");
            }
            bw.close();
         } catch (Exception e) {
            System.out.println("error");         
        }
    }
}
