package capitulo07.gestionVentaCoches;
import capitulo07.gestionVentaCoches.modelo.Fabricante;
import capitulo07.gestionVentaCoches.modelo.controladores.ControladorFabricante;
import capitulo07.gestionVentaCoches.modelo.controladores.ErrorBBDDException;

import java.awt.*;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VisorFabricante extends Panel{

	private static JTextField cifField;
	private static JTextField nombreField;
	private JButton btnPrimerElemento;
	private JButton btnAtras;
	private JButton btnSiguiente;
	private JButton btnUltimoElemento;
	private JButton btnNuevoRegistro;
	private JButton btnGuardarRegistro;
	private JButton btnEliminarRegistro;
	
	private static VisorFabricante instance = null;
    private int id = 1, primerId, ultimoId;

    private int accion = 0;

	/**
	 * Create the application.
	 */
    
    public static VisorFabricante getInstance() throws ErrorBBDDException {
        if(instance == null)
            instance = new VisorFabricante();
        return instance;
    }
    
	public VisorFabricante() {
		initialize();
	}
	
	public void buscarPrimeroYUltimo() throws ErrorBBDDException {
        this.primerId = ControladorFabricante.getAll().get(0).getId();
        this.ultimoId = ControladorFabricante.getAll().get(ControladorFabricante.getAll().size()-1).getId();
    }

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		this.setLayout(gridBagLayout);
		
		JLabel lblNewLabel_1 = new JLabel("Gesti�n de fabricantes");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.gridwidth = 2;
		gbc_lblNewLabel_1.insets = new Insets(15, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 0;
		this.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("CIF:");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 2;
		this.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		cifField = new JTextField();
		GridBagConstraints gbc_jtfCif = new GridBagConstraints();
		gbc_jtfCif.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfCif.insets = new Insets(0, 0, 5, 5);
		gbc_jtfCif.gridx = 1;
		gbc_jtfCif.gridy = 2;
		this.add(cifField, gbc_jtfCif);
		cifField.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Nombre:");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 3;
		this.add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		nombreField = new JTextField();
		GridBagConstraints gbc_jtfNombre = new GridBagConstraints();
		gbc_jtfNombre.insets = new Insets(0, 0, 5, 5);
		gbc_jtfNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfNombre.gridx = 1;
		gbc_jtfNombre.gridy = 3;
		this.add(nombreField, gbc_jtfNombre);
		nombreField.setColumns(10);
		
		btnPrimerElemento = new JButton("<<");
        btnPrimerElemento.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cargarRegistro(0);
            }
        });
        this.add(btnPrimerElemento);
		
		btnAtras = new JButton("<");
        btnAtras.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cargarRegistro(1);
            }
        });
        this.add(btnAtras);
		
		btnSiguiente = new JButton(">");
        btnSiguiente.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cargarRegistro(2);
            }
        });
        this.add(btnSiguiente);
		
		btnUltimoElemento = new JButton(">>");
        btnUltimoElemento.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cargarRegistro(3);
            }
        });
        this.add(btnUltimoElemento);
		
		btnNuevoRegistro = new JButton("Nuevo");
        btnNuevoRegistro.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setId(0);
                cifField.setText("");
                nombreField.setText("");
            }
        });
        this.add(btnNuevoRegistro);
		
		btnGuardarRegistro = new JButton("Guardar");
        btnGuardarRegistro.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                try {
                    if(getId()==0) {
                        ControladorFabricante.almacenarNuevo
                                (new Fabricante(getId(), cifField.getText(), nombreField.getText()));
                        JOptionPane.showMessageDialog(null, "Registro introducido correctamente");
                        buscarPrimeroYUltimo();
                    }else{
                        ControladorFabricante.almacenarModificado
                                (new Fabricante(getId(), cifField.getText(), nombreField.getText()));
                        JOptionPane.showMessageDialog(null, "Registro modificado correctamente");
                    }
                } catch (ErrorBBDDException ex) {
                    JOptionPane.showMessageDialog(null,"No se pudo guardar o modificar el registro", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        this.add(btnGuardarRegistro);
		
		btnEliminarRegistro = new JButton("Eliminar");
        btnEliminarRegistro.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    ControladorFabricante.eliminar(new Fabricante(getId(),null,null));
                    JOptionPane.showMessageDialog(null,"Registro eliminado correctamente");

                    if (getId() <= getUltimoId() && getId() > getPrimerId()) {
                        btnAtras.doClick();
                        btnSiguiente.setEnabled(false);
                        btnUltimoElemento.setEnabled(false);
                    }else btnSiguiente.doClick();
                    buscarPrimeroYUltimo();
                } catch (ErrorBBDDException ex) {
                    JOptionPane.showMessageDialog(null,"No se pudo eliminar el registro", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        this.add(btnEliminarRegistro);

        cargarRegistro(0);
        btnPrimerElemento.setEnabled(false);
        btnAtras.setEnabled(false);
		
	}
	private void cargarRegistro (int opcion) {
        setAccion(opcion);

        String consulta = comprobarBoton();
        try {
        	Fabricante f  = ControladorFabricante.getFabricante(consulta);
            setId(f.getId());
            cifField.setText(f.getCif());
            nombreField.setText(f.getNombre());
        } catch (ErrorBBDDException ex) {
            ex.printStackTrace();
        }
        comprobarEstadoBotones();
    }

    /**
     *
     */
    private void comprobarEstadoBotones() {
        if(getId() == getPrimerId()){
            btnAtras.setEnabled(false);
            btnPrimerElemento.setEnabled(false);
            btnSiguiente.setEnabled(true);
            btnUltimoElemento.setEnabled(true);
        }else if (getId() == getUltimoId()) {
            btnAtras.setEnabled(true);
            btnPrimerElemento.setEnabled(true);
            btnSiguiente.setEnabled(false);
            btnUltimoElemento.setEnabled(false);
        }else if(getAccion()==0 || getAccion()==1){
            btnSiguiente.setEnabled(true);
            btnUltimoElemento.setEnabled(true);
        }else if(getAccion()==2 || getAccion()==3){
            btnAtras.setEnabled(true);
            btnPrimerElemento.setEnabled(true);
        }
    }

    public String comprobarBoton(){
        String consulta = null;
        switch (getAccion()){
            case 0: consulta = "select * from fabricante order by id asc limit 1"; break;
            case 1: consulta = "select * from fabricante where id <" + getId() + " order by id desc limit 1"; break;
            case 2: consulta = "select * from fabricante where id >" + getId() + " order by id asc limit 1"; break;
            case 3: consulta = "select * from fabricante order by id desc limit 1"; break;
            default: break;
        }
        return consulta;
    }

    public int getAccion(){
        return this.accion;
    }
    public void setAccion(int accion){
        this.accion = accion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public int getPrimerId() {
        return primerId;
    }

    public void setPrimerId(int primerId) {
        this.primerId = primerId;
    }

    public int getUltimoId() {
        return ultimoId;
    }
}



