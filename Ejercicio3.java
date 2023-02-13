public class Ejercicio3 {
    public static void main(String[] args) {
        if(args.length!=3){
            return;
        }
        LineMixer.mixFiles(args[0], args[1], args[2]);
    }
}
