import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Coleccion coleccion = new Coleccion();

        Videojuego juego1 = new Videojuego("The Legend of Zelda: Breath of the Wild", "Switch", "Aventura", 2017, "Nintendo");
        Videojuego juego2 = new Videojuego("God of War", "PS4", "Acción", 2018, "Santa Monica Studio");
        Videojuego juego3 = new Videojuego("Hades", "PC", "Roguelike", 2020, "Supergiant Games");

        coleccion.agregarJuego(juego1);
        coleccion.agregarJuego(juego2);
        coleccion.agregarJuego(juego3);

        coleccion.listarJuegos();

        System.out.println("\n--- Buscar por título ---");
        Videojuego encontrado = coleccion.buscarPorTitulo("Hades");
        System.out.println(encontrado);

        System.out.println("\n--- Filtrar por plataforma ---");
        ArrayList<Videojuego> porPlataforma = coleccion.filtrarPorPlataforma("PC");
        for (Videojuego juego : porPlataforma) {
            System.out.println(juego);
        }
    }
}
