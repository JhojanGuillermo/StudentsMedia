package studentsmedia.app.tecsup.com.studentsmedia.models;

/**
 * Created by JShanksX13 on 2/04/2017.
 */

public class Event {

    private Integer id;

    private String fullname;

    private String fecha;

    private String lugar;

    private String picture;

    public Event(Integer id, String fullname, String fecha, String lugar, String picture){
        this.id = id;
        this.fullname = fullname;
        this.fecha = fecha;
        this.lugar = lugar;
        this.picture = picture;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id){
        this.id = id;
    }

    public String getFullname(){
        return fullname;
    }
    public void setFullname(String fullname) {
        this.fullname = fullname;
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

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", fullname='" + fullname + '\'' +
                ", fecha='" + fecha + '\'' +
                ", lugar='" + lugar + '\'' +
                ", picture='" + picture + '\'' +
                '}';
    }

}
