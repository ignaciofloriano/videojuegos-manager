import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class GestorArchivo {


    // metodos para la persistencia de datos

    public void guardar(ArrayList<Videojuego> juegos, String ruta) {
        Gson gson = new Gson();
        try {
            FileWriter writer = new FileWriter(ruta);
            gson.toJson(juegos, writer);
            writer.close();
        } catch (IOException e) {
            System.out.println("Error al guardar: " + e.getMessage());
        }
    }

    public ArrayList<Videojuego> cargar(String ruta) {
        Gson gson = new Gson();
        try {
            FileReader reader = new FileReader(ruta);
            Type tipo = new TypeToken<ArrayList<Videojuego>>(){}.getType();
            ArrayList<Videojuego> juegos = gson.fromJson(reader, tipo);
            reader.close();
            return juegos;
        } catch (IOException e) {
            System.out.println("No se encontró archivo de datos. Empezando colección vacía.");
            return new ArrayList<>();
        }
    }
}
