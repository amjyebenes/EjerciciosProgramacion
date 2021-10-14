package capitulo04.bloque03.Ejercicio06_Restaurante;

public class Menu {
    private Plato primero, segundo, tercero;

    public Menu() {
        primero = new Plato(1);
        segundo = new Plato(2);
        tercero = new Plato(3);
    }

    public Plato getPrimero() {
        return primero;
    }

    public void setPrimero(Plato primero) {
        this.primero = primero;
    }

    public Plato getSegundo() {
        return segundo;
    }

    public void setSegundo(Plato segundo) {
        this.segundo = segundo;
    }

    public Plato getTercero() {
        return tercero;
    }

    public void setTercero(Plato tercero) {
        this.tercero = tercero;
    }

    public String toString() {
        return ("El menu es: " + "\n" +
                primero.toString() + "\n" +
                segundo.toString() + "\n" +
                tercero.toString() + "\n" +
                "El precio del menu es: " +
                (primero.getPrecio() + segundo.getPrecio() + tercero.getPrecio()) + "\n\n");
    }

}