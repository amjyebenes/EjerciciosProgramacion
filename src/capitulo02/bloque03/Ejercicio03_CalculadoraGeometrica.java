package capitulo02.bloque03;

import java.util.Scanner;

public class Ejercicio03_CalculadoraGeometrica {
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        int op;
        do {
            System.out.println("BIENVENIDO A LA CALCULADORA GEOMETRICA");
            System.out.println(".-------------------------------------.");
            System.out.println(
                    """
                            1. Cálculo de la hipotenusa de un triángulo.
                            2. Cálculo de la superficie de una circunferencia.
                            3. Cálculo del perímetro de una circunferencia.
                            4. Cálculo del área de un rectángulo.
                            5. Cálculo del área de un triángulo.
                            0. Salir de la aplicación.""");
            System.out.println(".-------------------------------------.");
            System.out.println("Elige la operacion a realizar, 0 para salir: ");
            op = sc.nextInt();

            if(op>-1 && op<6) {

                switch (op) {
                    case 1 -> System.out.println("La hipotenusa es " + hipTriangulo());

                    case 2 -> System.out.println("La superficie de la cincurferencia es: " + supCircunferencia());

                    case 3 -> System.out.println("El perimetro de la circunferencia es: " + perimCircunferencia());

                    case 4 -> System.out.println("El area del rectangulo es: " + areaRect());

                    case 5 -> System.out.println("El area del triangulo es: " + areaTriang());
                }
            }else{
                System.out.println("\nOpcion incorrecta\n");
            }
        }while(op!=0);
    }

    public static double hipTriangulo(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce el cateto a: ");
        int a = sc.nextInt();
        System.out.println("Introduce el cateto b: ");
        int b = sc.nextInt();

        return Math.pow(a,2) + Math.pow(b,2);
    }
    public static double supCircunferencia(){
        Scanner sc = new Scanner(System.in);

        System.out.println("Introduce el radio de la circunferencia: ");
        double r = sc.nextDouble();

        return Math.pow(r,2) * Math.PI;

    }
    public static double perimCircunferencia(){
        Scanner sc = new Scanner(System.in);

        System.out.println("Introduce el radio de la circunferencia: ");
        int r = sc.nextInt();

        return 2*Math.PI*r;
    }
    public static int areaRect(){
        Scanner sc = new Scanner(System.in);

        System.out.println("Introduce la base del rectangulo: ");
        int b = sc.nextInt();
        System.out.println("Introduce la altura del rectangulo: ");
        int h = sc.nextInt();

        return b*h;
    }
    public static int areaTriang(){
        Scanner sc = new Scanner(System.in);

        System.out.println("Introduce la base del triangulo: ");
        int b = sc.nextInt();
        System.out.println("Introduce la altura del triangulo: ");
        int h = sc.nextInt();

        return (b*h)/2;
    }
}
