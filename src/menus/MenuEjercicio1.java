package menus;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import clases.Ejercicio1;

public class MenuEjercicio1 extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtTelefono;
	private JTextField txtFechaNac;
	private JLabel lblLosDatosIngresados;
	private JLabel lblMensajeDatos;
	private JRadioButton rdbtnMasculino;
	private JRadioButton rdbtnFemenino;
	private JComboBox<?> CboxGenero;
	private JTextField txtDni;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuEjercicio1 frame = new MenuEjercicio1();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MenuEjercicio1() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(200, 100, 605, 331);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNombre = new JLabel("Nombre: ");
		lblNombre.setBounds(21, 21, 60, 14);
		contentPane.add(lblNombre);

		txtNombre = new JTextField();
		txtNombre.setBounds(150, 18, 174, 20);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);

		JLabel lblApellido = new JLabel("Apellido: ");
		lblApellido.setBounds(21, 48, 60, 14);
		contentPane.add(lblApellido);

		JLabel lblTelefono = new JLabel("Telefono: ");
		lblTelefono.setBounds(21, 75, 60, 14);
		contentPane.add(lblTelefono);

		JLabel lblDni = new JLabel("DNI:");
		lblDni.setBounds(21, 125, 100, 14);
		contentPane.add(lblDni);

		txtApellido = new JTextField();
		txtApellido.setBounds(150, 45, 174, 20);
		contentPane.add(txtApellido);
		txtApellido.setColumns(10);

		txtTelefono = new JTextField();
		txtTelefono.setBounds(150, 72, 174, 20);
		contentPane.add(txtTelefono);
		txtTelefono.setColumns(10);

		txtFechaNac = new JTextField();
		txtFechaNac.setBounds(150, 97, 174, 20);
		contentPane.add(txtFechaNac);
		txtFechaNac.setColumns(10);

		JLabel lblGenero = new JLabel("Genero: ");
		lblGenero.setBounds(21, 164, 60, 14);
		contentPane.add(lblGenero);

		CboxGenero = new JComboBox();
		CboxGenero.setBounds(150, 161, 174, 20);
		contentPane.add(CboxGenero);
		CboxGenero.setModel(
				new DefaultComboBoxModel(new String[] { "Masculino", "Femenino", "Otro", "Prefiero no especificar" }));

		lblLosDatosIngresados = new JLabel("Los datos ingresados fueron: ");
		lblLosDatosIngresados.setBounds(21, 192, 200, 14);
		contentPane.add(lblLosDatosIngresados);

		// JLabel para mostrar el mensaje de los datos ingresados
		lblMensajeDatos = new JLabel("");
		lblMensajeDatos.setBounds(21, 206, 558, 51);
		contentPane.add(lblMensajeDatos);

		JButton btnMostrar = new JButton("Mostrar");
		btnMostrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Crea una lista de Textbox
				ArrayList<JTextField> TextBoxes = new ArrayList<JTextField>();
				TextBoxes.add(txtNombre);
				TextBoxes.add(txtApellido);
				TextBoxes.add(txtTelefono);
				TextBoxes.add(txtFechaNac);
				TextBoxes.add(txtDni);
				// Extrae las textbox vacias de esa lista
				ArrayList<JTextField> TextBoxesVacios = Ejercicio1.removerTextboxConTexto(TextBoxes);

				if (TextBoxesVacios.isEmpty()) {
					if (!txtNombre.getText().matches("^[a-zA-Z\\s]+$")) { // verificando si cumple con el patr�n que
																			// permite solo letras y espacios
						txtNombre.setBackground(Color.RED);
						lblMensajeDatos.setText("El nombre solo debe contener letras.");
						return;
					} else {
						txtNombre.setBackground(Color.WHITE); // Si es v�lido resetea el color
					}
					if (!txtApellido.getText().matches("^[a-zA-Z\\s]+$")) {// verificando si cumple con el patr�n que
																			// permite solo letras y espacios
						txtApellido.setBackground(Color.RED);
						lblMensajeDatos.setText("El apellido solo debe contener letras.");
						return;
					} else {
						txtApellido.setBackground(Color.WHITE); // Si es v�lido resetea el color
					}

					// Validar que el telefono solo contenga n�meros
					if (!txtTelefono.getText().matches("\\d+")) {
						txtTelefono.setBackground(Color.RED);
						lblMensajeDatos.setText("El tel�fono debe contener solo numeros.");
						return; // Salir si la validaci�n falla
					} else {
						txtTelefono.setBackground(Color.WHITE); // Si es v�lido resetea el color
					}

					// Validar que el telefono contenga unidades minimas
					if (txtTelefono.getText().length() < 8) {
						txtTelefono.setBackground(Color.RED);
						lblMensajeDatos.setText("La cantidad minima de digitos es 8.");
						return;
					} else {
						txtTelefono.setBackground(Color.WHITE);
					}

					// Validar que la fecha de nacimiento siga este formato dd/MM/yyyy
					if (!txtFechaNac.getText().matches("\\d{2}/\\d{2}/\\d{4}")) {
						txtFechaNac.setBackground(Color.RED);
						lblMensajeDatos.setText("La fecha de nacimiento debe tener el formato dd/MM/yyyy.");
						return; // Salir si la validaci�n falla
					} else {
						txtFechaNac.setBackground(Color.WHITE); // Si es v�lido resetea el color
					}

					// Validar que el dni solo contenga numeros
					if (!txtDni.getText().matches("\\d+")) {
						txtDni.setBackground(Color.RED);
						lblMensajeDatos.setText("El Dni debe contener solo numeros.");
						return; // Salir si la validaci�n falla
					} else {
						txtTelefono.setBackground(Color.WHITE); // Si es valido resetea el color
					}

					// Validar que el dni contenga unidades minimas
					if (txtDni.getText().length() < 6) {
						txtDni.setBackground(Color.RED);
						lblMensajeDatos.setText("La cantidad minima de digitos es 6.");
						return;
					} else {
						txtTelefono.setBackground(Color.WHITE);
					}

					// Si no hay cajas vac�as, muestra los datos
					String datos = "Nombre: " + txtNombre.getText() + ", Apellido: " + txtApellido.getText()
							+ ", Telefono: " + txtTelefono.getText() + ", Fecha de Nac: " + txtFechaNac.getText()
							+ ", Genero: " + CboxGenero.getSelectedItem();
					lblMensajeDatos.setText(datos); // Muestra los datos debajo del lblLosDatosIngresados

					// Limpia los campos de texto
					for (JTextField tb : TextBoxes) {
						tb.setText(""); // Limpia los campos
						tb.setBackground(Color.WHITE); // Restaura el color de fondo
					}
				} else {
					// Si hay campos vac�os, resalta en rojo los vac�os
					for (JTextField tb : TextBoxes) {
						if (TextBoxesVacios.contains(tb)) {
							tb.setBackground(Color.RED);
						} else {
							tb.setBackground(Color.WHITE);
						}
					}
					lblMensajeDatos.setText("Complete todos los campos"); // Muestra el mensaje de error
				}
			}
		});
		btnMostrar.setBackground(Color.WHITE);
		btnMostrar.setBounds(337, 160, 89, 23);
		contentPane.add(btnMostrar);

		JLabel label = new JLabel("Fecha de Nac: ");
		label.setBounds(21, 100, 100, 14);
		contentPane.add(label);

		txtDni = new JTextField();
		txtDni.setColumns(10);
		txtDni.setBounds(150, 122, 174, 20);
		contentPane.add(txtDni);
	}
}
