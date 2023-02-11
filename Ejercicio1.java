/*
 *  Escribe un programa que guarde en un fichero con nombre primos.dat los
    números primos que hay entre 1 y 500.
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
public class Ejercicio1{
    public static void main(String[] args) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("./primos.dat"));
            for(int i=1;i<=500;i++){
                if(isPrime(i)){
                    int num=i;
                    bw.write(num+"\n");
                }
            }

            
            bw.close();
        } catch (IOException e) {
            System.out.println("ERROR");
        }
    }
    public static boolean isPrime(int n) {
        if(n<2){
            return false;
        }
        for(int i=2;i<n/2+1;i++){
            if(n%i==0){
                return false;
            }
        }
        return true;
    }
}