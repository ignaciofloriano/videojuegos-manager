import java.text.Normalizer;
import java.util.ArrayList;
import java.util.HashMap;

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
            if (normalizar(juego.getGenero()).equalsIgnoreCase(normalizar(genero))) {
                resultado.add(juego);
            }
        }
        return resultado;
    }

    // busqueda por estado + lista

    public ArrayList<Videojuego> filtrarPorEstado(String estado) {
        ArrayList<Videojuego> resultado = new ArrayList<>();
        for (Videojuego juego : juegos) {
            if (normalizar(juego.getGenero()).equalsIgnoreCase(normalizar(estado))) {
                resultado.add(juego);
            }
        }
        return resultado;
    }

    // METODOS PARA ESTADISTICAS

    public int totalJuegos() {
        return juegos.size();
    }

    public double notaMedia() {
        if (juegos.isEmpty()) {
            return 0;
        }
        double suma = 0.0;
        for (Videojuego juego : juegos) {
            suma += juego.getPuntuacion();
        }
        return Math.round((double) suma / juegos.size() * 100.0) / 100.0;
    }

    public Videojuego mejorValorado() {
        if (juegos.isEmpty()) {
            return null;
        }
        Videojuego mejor = juegos.getFirst();
        for (Videojuego juego : juegos) {
            if (juego.getPuntuacion() > mejor.getPuntuacion()) {
                mejor = juego;
            }
        }
        return mejor;
    }

    // metodo busca por estado -> convierte a cantidad por estado

    public HashMap<String, Integer> juegosPorEstado() {
        HashMap<String, Integer> resultado = new HashMap<>();
        for (Videojuego juego : juegos) {
            String estado = juego.getEstado();
            if (resultado.containsKey(estado)) {
                resultado.put(estado, resultado.get(estado) + 1);
            } else {
                resultado.put(estado, 1);
            }
        }
        return resultado;
    }

    // getter y setter guardar y cargar datos json

    public ArrayList<Videojuego> getJuegos() {
        return juegos;
    }

    public void setJuegos(ArrayList<Videojuego> juegos) {
        this.juegos = juegos;
    }

    // metodo para corregir bug con tildes al hacer busqueda

    private String normalizar(String texto) {
        return Normalizer.normalize(texto, Normalizer.Form.NFD)
                .replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");
    }

}
