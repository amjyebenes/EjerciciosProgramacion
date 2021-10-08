package capitulo04.bloque04.tercero;

import java.util.ArrayList;

public class PruebaArbol {
    public static void main(String[]args){
        Arbol raiz, izq, der, izqfinal, derfinal;
        Fruto f1 = new Fruto("naranja");
        Fruto f2 = new Fruto("piña");
        Fruto f3 = new Fruto("uva");
        Fruto f4 = new Fruto("manzana");
        Fruto f5 = new Fruto("pera");
        Fruto f6 = new Fruto("tomate");

        Hoja j1 = new Hoja("rosa");
        Hoja j2 = new Hoja("azul");
        Hoja j3 = new Hoja("amarillo");
        Hoja j4 = new Hoja("verde");
        Hoja j5 = new Hoja("morado");

        izq = new Arbol();
        der = new Arbol();
        der = new Arbol(izq,j1,f1,der);
        izq  = new Arbol(izq,j1,f1,der);
        raiz = new Arbol(izq,j1,f1,der);


        recorrerArbol()
    }

    public void recorrerArbol(Arbol arb){
        if(arb.getIzq()==null && arb.getDer()==null){
            System.out.println(arb);
        }else if(arb.getDer()==null) recorrerArbol(arb.getIzq());
            else recorrerArbol(arb.getDer());
    }
}
