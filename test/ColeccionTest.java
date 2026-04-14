import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;

public class ColeccionTest {
    private Coleccion coleccion;

    //prerarar coleccion para no repetir codigo

    @BeforeEach
    void setUp() {
        coleccion = new Coleccion();
        coleccion.agregarJuego(new Videojuego("Hades", "PC", "Roguelike", 2020, "Supergiant Games"));
        coleccion.agregarJuego(new Videojuego("Celeste", "PC", "Plataformas", 2018, "Maddy Thorson"));
        coleccion.agregarJuego(new Videojuego("Zelda", "Switch", "Aventura", 2017, "Nintendo"));
    }

    // tests de metodos con posibles fallos

    @Test
    void testTotalJuegos() {
        assertEquals(3, coleccion.totalJuegos());
    }

    @Test
    void testAgregarJuego() {
        coleccion.agregarJuego(new Videojuego("Hollow Knight", "PC", "Metroidvania", 2017, "Team Cherry"));
        assertEquals(4, coleccion.totalJuegos());
    }

    @Test
    void testEliminarJuego() {
        coleccion.eliminarJuego("Hades");
        assertEquals(2, coleccion.totalJuegos());
    }

    @Test
    void testBuscarPorTitulo() {
        Videojuego encontrado = coleccion.buscarPorTitulo("Hades");
        assertNotNull(encontrado);
        assertEquals("Hades", encontrado.getTitulo());

        Videojuego noExiste = coleccion.buscarPorTitulo("Mario");
        assertNull(noExiste);
    }

    @Test
    void testFiltrarPorPlataforma() {
        ArrayList<Videojuego> resultado = coleccion.filtrarPorPlataforma("PC");
        assertEquals(2, resultado.size());
    }

    @Test
    void testNotaMedia() {
        coleccion.buscarPorTitulo("Hades").setPuntuacion(8);
        coleccion.buscarPorTitulo("Celeste").setPuntuacion(10);
        coleccion.buscarPorTitulo("Zelda").setPuntuacion(9);
        assertEquals(9.0, coleccion.notaMedia());
    }
}
