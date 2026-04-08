import java.util.ArrayList;

public class Coleccion {
    private ArrayList<Videojuego> juegos;

    public Coleccion() {
        this.juegos = new ArrayList<>();
    }

    // METODOS

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

    //busqueda por titulo

    public Videojuego buscarPorTitulo(String titulo) {
        for (Videojuego juego : juegos) {
            if (juego.getTitulo().equalsIgnoreCase(titulo)) {
                return juego;
            }
        }
        return null;
    }

    // metodo para devolver lista con busqueda por plataforma

    public ArrayList<Videojuego> filtrarPorPlataforma(String plataforma) {
        ArrayList<Videojuego> resultado = new ArrayList<>();
        for (Videojuego juego : juegos) {
            if (juego.getPlataforma().equalsIgnoreCase(plataforma)) {
                resultado.add(juego);
            }
        }
        return resultado;
    }

    // busqueda por genero + lista

    public ArrayList<Videojuego> filtrarPorGenero(String genero) {
        ArrayList<Videojuego> resultado = new ArrayList<>();
        for (Videojuego juego : juegos) {
            if (juego.getGenero().equalsIgnoreCase(genero)) {
                resultado.add(juego);
            }
        }
        return resultado;
    }

    // busqueda por estado + lista

    public ArrayList<Videojuego> filtrarPorEstado(String estado) {
        ArrayList<Videojuego> resultado = new ArrayList<>();
        for (Videojuego juego : juegos) {
            if (juego.getEstado().equalsIgnoreCase(estado)) {
                resultado.add(juego);
            }
        }
        return resultado;
    }

}
