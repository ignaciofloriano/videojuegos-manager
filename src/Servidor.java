import io.javalin.Javalin;
import io.javalin.http.staticfiles.Location;

public class Servidor {
    public void iniciar() {
        GestorArchivo gestor = new GestorArchivo();
        Coleccion coleccion = new Coleccion();
        coleccion.setJuegos(gestor.cargar("coleccion.json"));

        Javalin app = Javalin.create(config -> {
            config.staticFiles.add("web", Location.EXTERNAL);
        }).start(7000);

        // endpoints para añadir, eliminar y editar juegos

        app.get("/api/juegos", ctx -> {
            ctx.json(coleccion.getJuegos());
        });

        app.post("/api/juegos", ctx -> {
            Videojuego juego = ctx.bodyAsClass(Videojuego.class);
            coleccion.agregarJuego(juego);
            gestor.guardar(coleccion.getJuegos(), "coleccion.json");
            ctx.status(201).json(juego);
        });

        app.put("/api/juegos/{titulo}", ctx -> {
            String titulo = ctx.pathParam("titulo");
            Videojuego actualizado = ctx.bodyAsClass(Videojuego.class);
            Videojuego existente = coleccion.buscarPorTitulo(titulo);
            if (existente != null) {
                existente.setEstado(actualizado.getEstado());
                existente.setPuntuacion(actualizado.getPuntuacion());
                existente.setNotas(actualizado.getNotas());
                gestor.guardar(coleccion.getJuegos(), "coleccion.json");
                ctx.json(existente);
            } else {
                ctx.status(404);
            }
        });

        app.delete("/api/juegos/{titulo}", ctx -> {
            String titulo = ctx.pathParam("titulo");
            coleccion.eliminarJuego(titulo);
            gestor.guardar(coleccion.getJuegos(), "coleccion.json");
            ctx.status(204);
        });
    }


}
