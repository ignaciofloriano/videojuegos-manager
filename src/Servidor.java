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

        app.get("/api/juegos", ctx -> {
            ctx.json(coleccion.getJuegos());
        });
    }
}
