package capitulo04.bloque0.batalla;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;

import javax.swing.*;

public class Ventana extends JFrame {

    public static int ANCHO = 800;
    public static int ALTO = 450;
    public static String TITULO_APLICACION = "BATALLA ALIENÍGENA";

    private CacheImagenes cacheImagenes;
    public static BufferedImage iconoApp;

    // Establecer la apariencia típica de Windows
    static {
        Apariencia.setApariencia(Apariencia.WINDOWS);
    }


    public Ventana () {
        super (TITULO_APLICACION);

        cacheImagenes = new CacheImagenes();
        iconoApp = cacheImagenes.getImagen("nave.gif");
        setIconImage(iconoApp);

        // Tamaño por defecto, basado en los valores estáticos de esta misma clase
        setDimensionesBasicas();

        // Una posibilidad es iniciar el JFrame en un estado determinado, las opciones son:
        // JFrame.NORMAL: Inicializa el JFrame en estado Normal
        // JFrame.ICONIFIED: Inicializa el JFrame en estado Minimizado.
        // JFrame.MAXIMIZED_HORIZ: Inicializa el JFrame en estado Maximizado Horizontalmente
        // JFrame.MAXIMIZED_VERT: Inicializa el JFrame en estado Maximizado Verticalmente
        // JFrame.MAXIMIZED_BOTH: Inicializa el JFrame en estado Maximizado en ambos sentidos
        //this.setExtendedState(JFrame.MAXIMIZED_BOTH);

        // Configuración del evento de cerrado
        // Para más información debes estudiar Javadoc WindowListener y WindowAdapter
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                String posiblesRespuestas[] = {"Sí","No"};
                // En esta opción se utiliza un showOptionDialog en el que personalizo el icono mostrado
                int opcionElegida = JOptionPane.showOptionDialog(null, "¿Realmente desea cerrar la aplicación?", TITULO_APLICACION,
                        JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, cacheImagenes.getIcono("confirm.png"), posiblesRespuestas, posiblesRespuestas[1]);
                if(opcionElegida == 0) {
                    System.exit(0);
                }
            }
        });

        // Inclusión de los eventos de teclado
        // Para más información debes estudiar Javadoc KeyListener y KeyAdapter
        this.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                // En esta ocasión he decidido no personalizar el icono mostrado, para obtener el icono por defecto
                JOptionPane.showMessageDialog(null, "Deja de pulsar teclas ya", TITULO_APLICACION, JOptionPane.INFORMATION_MESSAGE, null);
            }
        });

        // incluimos y estudiamos los eventos del ratón
 //       inclusionEventosRaton();

        // Construcción elementos básicos sobre el ContentPanel
        this.setContentPane(getElementosBasicosPanel());
    }



    /**
     *
     */
    private void setDimensionesBasicas () {
        this.setExtendedState(JFrame.NORMAL);
        this.setBounds(0, 0, ANCHO, ALTO);
        this.setMinimumSize(new Dimension(ANCHO, ALTO));
    }




    /**
     *
     */
//    private void inclusionEventosRaton () {
//        // MouseListener permite controlar eventos de ratón simples
//        this.addMouseListener(new MouseListener () {
//
//            @Override
//            public void mouseClicked(MouseEvent e) {
//                System.out.println("Botón de ratón pulsado: " + e.getButton() + " - " + e.getClickCount() + " veces");
//                System.out.println("\tX: " + e.getX() + " Y: " + e.getY() + " X en pantalla: " + e.getXOnScreen() + " Y en pantalla: " + e.getYOnScreen());
//            }
//
//            @Override
//            public void mousePressed(MouseEvent e) {
//                System.out.println("Botón de ratón presionado: " + e.getButton());
//            }
//
//            @Override
//            public void mouseReleased(MouseEvent e) {
//                System.out.println("Botón de ratón liberado: " + e.getButton());
//            }
//
//            @Override
//            public void mouseEntered(MouseEvent e) {
//                System.out.println("Ratón entra en la ventana");
//            }
//
//            @Override
//            public void mouseExited(MouseEvent e) {
//                System.out.println("Ratón sale de la ventana");
//            }
//
//        });
//
//
//        // Los eventos del MouseMotionListener nos permiten detectar movimiento del ratón y arrastre, a bajo nivel
//        this.addMouseMotionListener(new MouseMotionListener() {
//
//            @Override
//            public void mouseMoved(MouseEvent e) {
//                System.out.println("Ratón se ha desplazado a las coordenadas x: " + e.getX() + " y: " + e.getY());
//            }
//
//            @Override
//            public void mouseDragged(MouseEvent e) {
//                System.out.println("Ratón arrastrando a las coordenadas x: " + e.getX() + " y: " + e.getY());
//            }
//        });
//
//
//        // Por último, algo muy habitual
//        this.addMouseWheelListener(new MouseWheelListener() {
//
//            @Override
//            public void mouseWheelMoved(MouseWheelEvent e) {
//                if (e.getWheelRotation() > 0) {
//                    System.out.println("Movimiento de reducción - Rueda hacía atrás - Pasos: " + e.getWheelRotation());
//                }
//                else {
//                    System.out.println("Movimiento de amplitud - Rueda hacía adelante - Pasos: " + e.getWheelRotation());
//                }
//            }
//        });
//    }



    /**
     *
     */
    // Una web muy interesante para obtener un showcase de los componentes SWING es http://web.mit.edu/6.005/www/sp14/psets/ps4/java-6-tutorial/components.html
    private JPanel getElementosBasicosPanel () {
        JPanel muestrario = new JPanel();

//        // JLabel
//        JLabel lb = new JLabel ("Ejemplo de JTextField: ");
//        muestrario.add(lb);

        // JTextField
        JTextField tf = new JTextField("asdf");
        tf.setText("Texto en el interior");
        tf.setColumns(4);
        tf.setToolTipText("ToolTip para el componente JTextField");
        muestrario.add(tf);

        // JButton
        JButton bt = new JButton("Que comience la batalla!!!");
        JButton bt2 = new JButton("Finalizar batalla");
        bt.addActionListener(new ActionListener () {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Personalización del icono, otra vez
                JOptionPane.showMessageDialog(null, "¡Acción!", TITULO_APLICACION, JOptionPane.INFORMATION_MESSAGE, cacheImagenes.getIcono("goku.png"));
            }
        });
        bt2.addActionListener(new ActionListener () {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Personalización del icono, otra vez
                JOptionPane.showMessageDialog(null, "Batalla finalizada", TITULO_APLICACION, JOptionPane.INFORMATION_MESSAGE);
            }
        });

        JLabel lbnave = new JLabel();


        muestrario.add(bt);
        muestrario.add(bt2);

        return muestrario;
    }

}
