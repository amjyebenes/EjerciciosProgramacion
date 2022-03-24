package capitulo07.gestionVentaCoches;
import capitulo07.gestionVentaCoches.modelo.controladores.ControladorFabricante;
import capitulo07.gestionVentaCoches.modelo.controladores.ErrorBBDDException;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VisorFabricante {

    private JFrame frame;
    private JTextField idField;
    private JTextField cifField;
    private JTextField nombreField;

    private String id, cif, nombre;

    private int accion = 0; // 0 primer elemento, 1 elemento atras, 2 elemento siguiente, 3 ultimo elemento // otherwise ignorar

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    VisorFabricante window = new VisorFabricante();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public VisorFabricante() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 568, 355);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel lblNewLabel = new JLabel("CRUD Fabricantes");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 23));
        lblNewLabel.setBounds(172, 11, 222, 28);
        frame.getContentPane().add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("ID");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblNewLabel_1.setBounds(139, 69, 46, 14);
        frame.getContentPane().add(lblNewLabel_1);

        JLabel lblNewLabel_1_1 = new JLabel("CIF");
        lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblNewLabel_1_1.setBounds(139, 112, 46, 14);
        frame.getContentPane().add(lblNewLabel_1_1);

        JLabel lblNewLabel_1_2 = new JLabel("Nombre");
        lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblNewLabel_1_2.setBounds(139, 160, 71, 14);
        frame.getContentPane().add(lblNewLabel_1_2);

        idField = new JTextField();
        idField.setEnabled(false);
        idField.setBounds(220, 68, 138, 20);
        frame.getContentPane().add(idField);
        idField.setColumns(10);

        cifField = new JTextField();
        cifField.setColumns(10);
        cifField.setBounds(220, 111, 138, 20);
        frame.getContentPane().add(cifField);

        nombreField = new JTextField();
        nombreField.setColumns(10);
        nombreField.setBounds(220, 159, 138, 20);
        frame.getContentPane().add(nombreField);

        JButton btnPrimerElemento = new JButton("<<");
        btnPrimerElemento.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setAccion(0);
                try {
                    idField.setText(String.valueOf(ControladorFabricante.getFabricante(comprobarBoton()).getId()));
                    cifField.setText(ControladorFabricante.getFabricante(comprobarBoton()).getCif());
                    nombreField.setText(ControladorFabricante.getFabricante(comprobarBoton()).getNombre());
                } catch (ErrorBBDDException ex) {
                    ex.printStackTrace();
                }
            }
        });
        btnPrimerElemento.setBounds(43, 251, 89, 23);
        frame.getContentPane().add(btnPrimerElemento);

        JButton btnAtras = new JButton("<");
        btnAtras.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setAccion(1);
                try {
                    idField.setText(String.valueOf(ControladorFabricante.getFabricante(comprobarBoton()).getId()));
                    cifField.setText(ControladorFabricante.getFabricante(comprobarBoton()).getCif());
                    nombreField.setText(ControladorFabricante.getFabricante(comprobarBoton()).getNombre());
                    setId(String.valueOf(ControladorFabricante.getFabricante(comprobarBoton()).getId()));
                } catch (ErrorBBDDException ex) {
                    ex.printStackTrace();
                }
            }
        });
        btnAtras.setBounds(176, 251, 89, 23);
        frame.getContentPane().add(btnAtras);

        JButton btnSiguiente = new JButton(">");
        btnSiguiente.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setAccion(2);
                try {
                    idField.setText(String.valueOf(ControladorFabricante.getFabricante(comprobarBoton()).getId()));
                    cifField.setText(ControladorFabricante.getFabricante(comprobarBoton()).getCif());
                    nombreField.setText(ControladorFabricante.getFabricante(comprobarBoton()).getNombre());
                    setId(String.valueOf(ControladorFabricante.getFabricante(comprobarBoton()).getId()));
                } catch (ErrorBBDDException ex) {
                    ex.printStackTrace();
                }
            }
        });
        btnSiguiente.setBounds(296, 251, 89, 23);
        frame.getContentPane().add(btnSiguiente);

        JButton btnUltimoElemento = new JButton(">>");
        btnUltimoElemento.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btnUltimoElemento.setEnabled(true);
                try {
                    if(ControladorFabricante.getFabricante(comprobarBoton()).getId() < ControladorFabricante.getAll().size()) {
                        setAccion(3);
                        idField.setText(String.valueOf(ControladorFabricante.getFabricante(comprobarBoton()).getId()));
                        cifField.setText(ControladorFabricante.getFabricante(comprobarBoton()).getCif());
                        nombreField.setText(ControladorFabricante.getFabricante(comprobarBoton()).getNombre());
                        setId(String.valueOf(ControladorFabricante.getFabricante(comprobarBoton()).getId()));
                    }else btnUltimoElemento.setEnabled(false);
                } catch (ErrorBBDDException ex) {
                    ex.printStackTrace();
                }
            }
        });
        btnUltimoElemento.setBounds(416, 251, 89, 23);
        frame.getContentPane().add(btnUltimoElemento);
    }
    public int getAccion(){
        return this.accion;
    }
    public void setAccion(int accion){
        this.accion = accion;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCif() {
        return cif;
    }

    public void setCif(String cif) {
        this.cif = cif;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String comprobarBoton(){
        String consulta = null;
        switch (getAccion()){
            case 0: consulta = "select * from fabricante order by id asc limit 1"; break;
            case 1:{
                consulta = "select * from fabricante where id <" + getId() + " order by id asc limit 1";
                System.out.println(getId());
            } break;
            case 2: consulta = "select * from fabricante where id >" + getId() + " order by id asc limit 1"; break;
            case 3: consulta = "select * from fabricante order by id desc limit 1"; break;
            default:break;
        }
        return consulta;
    }
}



