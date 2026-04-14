import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.concurrent.SynchronousQueue;

public class Main {
    public static void main(String[] args) {
        Servidor servidor = new Servidor();
        servidor.iniciar();
    }
}
