package studentsmedia.app.tecsup.com.studentsmedia.models;

/**
 * Created by JShanksX13 on 2/04/2017.
 */

public class Event {

    private Integer id;

    private String titulo;

    private String fecha;

    private String lugar;

    private String descripcion;

    private String imagen;

    public Event(Integer id, String titulo, String fecha, String lugar,String descripcion, String imagen){
        this.id = id;
        this.titulo = titulo;
        this.fecha = fecha;
        this.lugar = lugar;
        this.descripcion = descripcion;
        this.imagen = imagen;
    }



    public Integer getId() {
        return id;
    }

    public void setId(Integer id){
        this.id = id;
    }

    public String getTitulo(){
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public String getDescripcion(){ return descripcion; }

    public void setDescripcion(String descripcion) { this.descripcion = descripcion;}

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", fecha='" + fecha + '\'' +
                ", lugar='" + lugar + '\'' +
                ", descripcion= '" + descripcion + '\'' +
                ", imagen='" + imagen + '\'' +
                '}';
    }

}
