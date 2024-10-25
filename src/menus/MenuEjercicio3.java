package menus;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import clases.Ejercicio3;

public class MenuEjercicio3 extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JRadioButton rdbtnWindows;
	private JRadioButton rdbtnMac;
	private JRadioButton rdbtnLinux;
	private JTextField textHoras;

	/**
	 * Create the frame.
	 */
	public MenuEjercicio3() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 314);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panelSistema = new JPanel();
		panelSistema.setBounds(23, 27, 390, 37);
		contentPane.add(panelSistema);
		panelSistema.setLayout(null);
		panelSistema.setBorder(new LineBorder(Color.BLACK));

		JLabel lblEligeUnSistema = new JLabel("Elije un sistema operativo");
		lblEligeUnSistema.setBounds(10, 11, 144, 14);
		panelSistema.add(lblEligeUnSistema);

		rdbtnWindows = new JRadioButton("Windows");
		rdbtnWindows.setActionCommand("Windows");
		rdbtnWindows.setBounds(160, 7, 81, 23);
		panelSistema.add(rdbtnWindows);

		rdbtnMac = new JRadioButton("Mac");
		rdbtnMac.setActionCommand("Mac");
		rdbtnMac.setBounds(243, 7, 58, 23);
		panelSistema.add(rdbtnMac);

		rdbtnLinux = new JRadioButton("Linux");
		rdbtnLinux.setActionCommand("Linux");
		rdbtnLinux.setBounds(303, 7, 58, 23);
		panelSistema.add(rdbtnLinux);

		// agrupar los RadioButton
		ButtonGroup groupSistema = new ButtonGroup();
		groupSistema.add(rdbtnWindows);
		groupSistema.add(rdbtnMac);
		groupSistema.add(rdbtnLinux);

		JPanel panelEspecialidad = new JPanel();
		panelEspecialidad.setBackground(new Color(240, 240, 240));
		panelEspecialidad.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelEspecialidad.setBounds(23, 88, 390, 101);
		contentPane.add(panelEspecialidad);
		panelEspecialidad.setLayout(null);

		JLabel lblEspecialidad = new JLabel("Elije una especialidad");
		lblEspecialidad.setBounds(10, 41, 108, 14);
		panelEspecialidad.add(lblEspecialidad);

		JCheckBox chckbxProgramacion = new JCheckBox("Programacion");
		chckbxProgramacion.setBounds(177, 7, 126, 23);
		panelEspecialidad.add(chckbxProgramacion);

		JCheckBox chckbxAdministracion = new JCheckBox("Administracion");
		chckbxAdministracion.setBounds(177, 37, 126, 23);
		panelEspecialidad.add(chckbxAdministracion);

		JCheckBox chckbxDiseñoGraf = new JCheckBox("Diseno Grafico");
		chckbxDiseñoGraf.setBounds(177, 68, 126, 23);
		panelEspecialidad.add(chckbxDiseñoGraf);

		// Crea una lista de checkboxes para revisar su estado despues
		ArrayList<JCheckBox> checkBoxes = new ArrayList<JCheckBox>();
		checkBoxes.add(chckbxAdministracion);
		checkBoxes.add(chckbxDiseñoGraf);
		checkBoxes.add(chckbxProgramacion);

		JLabel lblCantidadHoras = new JLabel("Cantidad de horas en el computador:");
		lblCantidadHoras.setBounds(33, 210, 218, 14);
		contentPane.add(lblCantidadHoras);

		textHoras = new JTextField();
		textHoras.setBounds(261, 207, 86, 20);
		contentPane.add(textHoras);
		textHoras.setColumns(10);

		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// Consigue el Sistema Operativo
		        String OS = null; // Inicializa OS a null
		        if (groupSistema.getSelection() != null) { // Verifica si se seleccionó un botón de radio
		            OS = groupSistema.getSelection().getActionCommand();
		        }
				
				if (OS == null) {
	                mostrarMensajeError();
	                return; // Sale de la función, si no se seleccionó un solo sistema operativo
	            }

	            // Verifica si se seleccionó al menos una especialidad
	            boolean especialidadSeleccionada = false;
	            for (JCheckBox checkBox : checkBoxes) {
	                if (checkBox.isSelected()) {
	                    especialidadSeleccionada = true;
	                    break; // Sale del bucle, si se encontró una especialidad seleccionada
	                }
	            }
	            if (!especialidadSeleccionada) {
	                mostrarMensajeError();
	                return; // Sale de la función si no se seleccionó ninguna especialidad
	            }


				// Consigue las checkboxes marcadas
				ArrayList<String> Especialidades = new ArrayList<String>();
				for (JCheckBox checkBox : checkBoxes) {
					if (checkBox.isSelected()) {
						Especialidades.add(checkBox.getText());
					}
				}
				
				//Verifica si el el campo de numeros está vacio o no
				if (textHoras.getText().isEmpty()) {
					mostrarMensajeErrorNumero();
					}else {
						if (!textHoras.getText().matches("\\d+")) { // Verificar si se ingresaron numeros
							JOptionPane.showMessageDialog(MenuEjercicio3.this,
							"Ingrese valores validos (Numericos) en este campo", "Error", JOptionPane.ERROR_MESSAGE);
							textHoras.setText("");
					//System.out.println("Ingrese valores validos (Numericos) en este campo");
					return; // Salir si falla
				}else {
					
					// Consigue la Cantidad de Horas
					String Horas = textHoras.getText();
					
					// Arma el texto Final
					String TextoFinal = Ejercicio3.ConcatenarOpciones(OS, Especialidades, Horas);
					
					JOptionPane.showMessageDialog(MenuEjercicio3.this, "Los valores ingresados fueron: " + TextoFinal, 
					"Mensaje", JOptionPane.INFORMATION_MESSAGE);
						}
					}
				
			}
		});
		btnAceptar.setBounds(258, 238, 89, 23);
		contentPane.add(btnAceptar);
	}
	
	// Función para mostrar el mensaje de error
    private void mostrarMensajeError() {
        JOptionPane.showMessageDialog(MenuEjercicio3.this,
                "Debe seleccionar al menos 1 opción en cada caso.",
                "Error", JOptionPane.ERROR_MESSAGE);
    }
 // Función para mostrar el mensaje de error en las horas
    private void mostrarMensajeErrorNumero() {
        JOptionPane.showMessageDialog(MenuEjercicio3.this,
                "El campo para ingresar las horas en el computador no puede quedar vacio",
                "Error", JOptionPane.ERROR_MESSAGE);
    }
}


