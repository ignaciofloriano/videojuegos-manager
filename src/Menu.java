import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    private Coleccion coleccion;
    private GestorArchivo gestor;
    private Scanner scanner;
    private static final String RUTA = "coleccion.json";

    // constructor

    public Menu() {
        this.coleccion = new Coleccion();
        this.gestor = new GestorArchivo();
        this.scanner = new Scanner(System.in);
        this.coleccion.setJuegos(gestor.cargar(RUTA));
    }

    // metodo para mostrar opciones en menu

    private void mostrarMenu() {
        System.out.println("\n=== GESTOR DE VIDEOJUEGOS ===");
        System.out.println("1. Añadir juego");
        System.out.println("2. Eliminar juego");
        System.out.println("3. Listar juegos");
        System.out.println("4. Buscar por título");
        System.out.println("5. Filtrar por plataforma");
        System.out.println("6. Filtrar por género");
        System.out.println("7. Filtrar por estado");
        System.out.println("8. Ver estadísticas");
        System.out.println("9. Editar juego");
        System.out.println("0. Salir");
        System.out.print("Elige una opción: ");
    }

    // metodo para arrancar menu

    public void iniciar() {
        boolean ejecutando = true;
        while (ejecutando) {
            mostrarMenu();
            int opcion = -1;
            try {
                opcion = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Por favor, introduce un número de opción en el menú.");
                continue;
            }
            switch (opcion) {
                case 1 -> añadirJuego();
                case 2 -> eliminarJuego();
                case 3 -> coleccion.listarJuegos();
                case 4 -> buscarJuego();
                case 5 -> filtrarPorPlataforma();
                case 6 -> filtrarPorGenero();
                case 7 -> filtrarPorEstado();
                case 8 -> verEstadisticas();
                case 9 -> editarJuego();
                case 0 -> ejecutando = false;
                default -> System.out.println("Opción no válida.");
            }
        }
        System.out.println("¡Hasta luego!");
    }

    // metodos para juegos en menu

    private void añadirJuego() {
        System.out.print("Título: ");
        String titulo = scanner.nextLine();
        System.out.print("Plataforma: ");
        String plataforma = scanner.nextLine();
        System.out.print("Género: ");
        String genero = scanner.nextLine();
        System.out.print("Año: ");
        int año = Integer.parseInt(scanner.nextLine());
        System.out.print("Desarrolladora: ");
        String desarrolladora = scanner.nextLine();

        Videojuego juego = new Videojuego(titulo, plataforma, genero, año, desarrolladora);
        coleccion.agregarJuego(juego);
        gestor.guardar(coleccion.getJuegos(), RUTA);
        System.out.println("Juego añadido correctamente.");
    }

    private void eliminarJuego() {
        System.out.print("Título del juego a eliminar: ");
        String titulo = scanner.nextLine();
        coleccion.eliminarJuego(titulo);
        gestor.guardar(coleccion.getJuegos(), RUTA);
        System.out.println("Juego eliminado correctamente.");
    }

    private void buscarJuego() {
        System.out.print("Título a buscar: ");
        String titulo = scanner.nextLine();
        Videojuego juego = coleccion.buscarPorTitulo(titulo);
        if (juego != null) {
            System.out.println(juego);
        } else {
            System.out.println("No se encontró ningún juego con ese título.");
        }
    }

    private void filtrarPorPlataforma() {
        System.out.print("Plataforma: ");
        String plataforma = scanner.nextLine();
        ArrayList<Videojuego> resultado = coleccion.filtrarPorPlataforma(plataforma);
        if (resultado.isEmpty()) {
            System.out.println("No se encontraron juegos para esa plataforma.");
        } else {
            for (Videojuego juego : resultado) {
                System.out.println(juego);
            }
        }
    }

    private void filtrarPorGenero() {
        System.out.print("Género: ");
        String genero = scanner.nextLine();
        ArrayList<Videojuego> resultado = coleccion.filtrarPorGenero(genero);
        if (resultado.isEmpty()) {
            System.out.println("No se encontraron juegos para ese género.");
        } else {
            for (Videojuego juego : resultado) {
                System.out.println(juego);
            }
        }
    }

    private void filtrarPorEstado() {
        System.out.print("Estado: ");
        String estado = scanner.nextLine();
        ArrayList<Videojuego> resultado = coleccion.filtrarPorEstado(estado);
        if (resultado.isEmpty()) {
            System.out.println("No se encontraron juegos para ese estado.");
        } else {
            for (Videojuego juego : resultado) {
                System.out.println(juego);
            }
        }
    }

    private void verEstadisticas() {
        System.out.println("\n=== ESTADÍSTICAS ===");
        System.out.println("Total de juegos: " + coleccion.totalJuegos());
        System.out.println("Nota media: " + coleccion.notaMedia());
        Videojuego mejor = coleccion.mejorValorado();
        if (mejor != null) {
            System.out.println("Mejor valorado: " + mejor.getTitulo());
        } else {
            System.out.println("Mejor valorado: No hay juegos en la colección.");
        }
    }

    // metodo para modificar datos de un juego

    private void editarJuego() {
        System.out.print("¿Qué juego quieres editar?: ");
        String titulo = scanner.nextLine();
        Videojuego juego = coleccion.buscarPorTitulo(titulo);
        if (juego == null) {
            System.out.println("No se encontró ningún juego con ese título.");
            return;
        }
        System.out.println("Estado actual: " + juego.getEstado());
        System.out.println("¿En qué estado se encuentra el juego? (Pendiente / Jugando / Completado / Abandonado)");
        String estado = scanner.nextLine();
        if (!estado.isEmpty()) {
            juego.setEstado(estado);
        }
        System.out.println("Puntuación actual: " + juego.getPuntuacion());
        System.out.print("Escribe la puntuación del 1 al 10. (Pulsa enter para no cambiar nada): ");
        String puntuacion = scanner.nextLine();
        if (!puntuacion.isEmpty()) {
            juego.setPuntuacion(Double.parseDouble(puntuacion.replace(",", ".")));
        }
        System.out.println("Notas actuales: " + juego.getNotas());
        System.out.print("¿Nuevas notas? (Pulsa enter para no cambiar nada): ");
        String notas = scanner.nextLine();
        if (!notas.isEmpty()) {
            juego.setNotas(notas);
        }
        gestor.guardar(coleccion.getJuegos(), RUTA);
        System.out.println("Juego actualizado correctamente.");
    }

}
