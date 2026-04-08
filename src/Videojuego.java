public class Videojuego {
    private String titulo;
    private String plataforma;
    private String genero;
    private int año;
    private String desarrolladora;
    private String estado;
    private int puntuacion;
    private String notas;

    public Videojuego(String titulo, String plataforma, String genero, int anio, String desarrolladora) {
        this.titulo = titulo;
        this.plataforma = plataforma;
        this.genero = genero;
        this.año = año;
        this.desarrolladora = desarrolladora;
        this.estado = "pendiente";
        this.puntuacion = 0;
        this.notas = "";
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getPlataforma() {
        return plataforma;
    }

    public void setPlataforma(String plataforma) {
        this.plataforma = plataforma;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getAño() {
        return año;
    }

    public void setAño(int año) {
        this.año = año;
    }

    public String getDesarrolladora() {
        return desarrolladora;
    }

    public void setDesarrolladora(String desarrolladora) {
        this.desarrolladora = desarrolladora;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }

    public String getNotas() {
        return notas;
    }

    public void setNotas(String notas) {
        this.notas = notas;
    }

    @Override
    public String toString() {
        return "Videojuego{" +
                "titulo='" + titulo + '\'' +
                ", plataforma='" + plataforma + '\'' +
                ", genero='" + genero + '\'' +
                ", año=" + año +
                ", desarrolladora='" + desarrolladora + '\'' +
                ", estado='" + estado + '\'' +
                ", puntuacion=" + puntuacion +
                ", notas='" + notas + '\'' +
                '}';
    }
}
