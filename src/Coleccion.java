import java.util.ArrayList;

public class Coleccion {
    private ArrayList<Videojuego> juegos;

    public Coleccion() {
        this.juegos = new ArrayList<>();
    }

    // metodos

    public void agregarJuego(Videojuego juego) {
        juegos.add(juego);
    }

    public void eliminarJuego(String titulo) {
        juegos.removeIf(juego -> juego.getTitulo().equalsIgnoreCase(titulo));
    }

    // listar todos los juegos de la coleccionn

    public void listarJuegos() {
        if (juegos.isEmpty()) {
            System.out.println("La colección está vacía.");
        } else {
            for (Videojuego juego : juegos) {
                System.out.println(juego);
            }
        }
    }
}
