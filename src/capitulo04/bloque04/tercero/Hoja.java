package capitulo04.bloque04.tercero;

public class Hoja {
    private String nombre;

    public Hoja(String nombre){
        this.nombre = nombre;
    }

    public String getNombre(){
        return this.nombre;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public String toString(){
        return ("Hoja: " + this.nombre + "\n");
    }
}
