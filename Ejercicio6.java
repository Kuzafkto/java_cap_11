/*Realiza un programa que diga cuántas ocurrencias de una palabra hay en un
fichero. Tanto el nombre del fichero como la palabra se deben pasar como
argumentos en la línea de comandos. */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
public class Ejercicio6 {
    public static void main(String[] args) {
        if(args.length!=2){
            System.out.println("Error en el paso de argumentos");
            return;
        }
        try {
            String archivo=args[0];
            String palabra=args[1];
            BufferedReader br=new BufferedReader(new FileReader(archivo));
            String linea="";
            int contador=0;
            while((linea=br.readLine())!=null){
                int i=0;
                while ((i=linea.indexOf(palabra))!=-1) {
                    linea=linea.substring(i+palabra.length(),linea.length());
                    contador++;
                }
                System.out.println(".");
            }
            br.close();
            if (contador>0){
                String resultado="La palabra %s aparece %d"+((contador>1)?" veces":"vez");
                System.out.printf(resultado,palabra,contador);
            }else{
                System.out.printf("La palabra %s no aparece en el archivo",palabra);
            }
        } catch (IOException e) {

        }
    }
}
