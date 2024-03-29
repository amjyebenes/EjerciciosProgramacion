package capitulo05.bloque08;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ejercicio02_EditorTextos {
    private static ArrayList<String> lineasCortadas;

    /**
     * En el main se muestra un menu con opciones, y se llama al metodo correspondiente
     *
     * @param args default
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String> texto = new ArrayList<>();
        int num;

        do {
            System.out.println("------- EDITOR DE TEXTOS -------\n" +
                               "0 : Finalizar programa\n" +
                               "1 : Añadir linea al texto\n" +
                               "2 : Insertar una linea en una posicion\n" +
                               "3 : Editar una linea\n" +
                               "4 : Borrar una linea\n" +
                               "5 : Cortar un conjunto de lineas\n" +
                               "6 : Pegar un conjunto de líneas cortadas en una determinada posición\n" +
                               "7 : Imprimir el fichero\n" +
                                "Introduce la accion deseada: ");

            num = sc.nextInt();

            switch (num) {
                case 1 : anadirLinea(texto); break;
                case 2 : anadirLineaenPos(texto); break;
                case 3 : editarLinea(texto); break;
                case 4 : borrarLinea(texto); break;
                case 5 : cortarParteDeTexto(texto); break;
                case 6 : pegarParteDeTexto(texto); break;
                case 7 : System.out.println("\n" + imprimirTexto(texto) + "\n"); break;
                default : System.out.println("******* FIN DEL PROGRAMA *******"); break;
            }

        } while (num != 0);

    }

    /**
     * Annadir linea al texto
     *
     * @param texto arraylist texto
     */
    public static void anadirLinea(List<String> texto) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce la linea: ");
        texto.add(sc.nextLine());
    }

    /**
     * Annadir linea en x posicion
     *
     * @param texto arraylist texto
     */
    public static void anadirLineaenPos(List<String> texto) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce el indice en el cual quieres introducir una linea: ");
        int pos = sc.nextInt();
        System.out.println("Introduce la linea: ");
        sc.nextLine();
        String linea  = sc.nextLine();
        texto.add(pos,linea);
    }

    /**
     * Editar linea del texto
     *
     * @param texto arraylist texto
     */
    public static void editarLinea(List<String> texto) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce el indice de la linea a modificar: ");
        int pos = sc.nextInt();
        String linea  = JOptionPane.showInputDialog("Introduce la linea modificada: ",texto.get(pos));
        texto.set(pos,linea);
    }

    /**
     * Borrar linea del texto
     *
     * @param texto arraylist texto
     */
    public static void borrarLinea(List<String> texto) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce el indice de la linea que quieres borrar: ");
        texto.remove(sc.nextInt());
    }

    /**
     * Metodo auxiliar para borrar x linea
     *
     * @param texto  arraylist texto
     * @param indice indice de la linea a borrar
     */
    public static void borrarLinea(List<String> texto, int indice) {
        texto.remove(indice);
    }

    /**
     * Cortar x lineas del texto en un intervalo
     *
     * @param texto arraylist texto
     */
    public static void cortarParteDeTexto(List<String> texto) {
        Scanner sc = new Scanner(System.in);
        int limInf, limSup;
        do {
            System.out.println("Introduce el indice inferior para cortar: ");
            limInf = sc.nextInt();
            System.out.println("Introduce el indice superior para cortar: ");
            limSup = sc.nextInt();
        } while (limInf > limSup || limInf < 0);

        lineasCortadas = new ArrayList<>();
        for (int i = 0; i <= limSup - limInf; i++) {
            lineasCortadas.add(texto.get(limInf));
            borrarLinea(texto, limInf);
        }
    }

    /**
     * Pegar el texto anteriormente cortado
     *
     * @param texto arraylist texto
     */
    public static void pegarParteDeTexto(List<String> texto) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce la posicion en la cual insertar el texto cortado: ");
        int posicion = sc.nextInt();
        texto.addAll(posicion, lineasCortadas);
        lineasCortadas.clear();
    }

    /**
     * Imprime el texto entero
     *
     * @param texto arraylist texto
     * @return StrinBuilder del texto to String
     */
    public static String imprimirTexto(List<String> texto) {
        StringBuilder sb = new StringBuilder();
        int cont = 0;
        for (String i : texto) {
            sb.append(cont).append(": ").append(i);
            sb.append("\n");
            cont++;
        }
        return sb.toString();
    }
}
