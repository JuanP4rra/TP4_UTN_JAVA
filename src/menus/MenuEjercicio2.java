package menus;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class MenuEjercicio2 extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNota1;
	private JTextField txtNota2;
	private JTextField txtNota3;
	private JTextField txtPromedio;
	private JTextField txtCondicion;
	protected Float SumaNotas;
	protected Float nota1, nota2, nota3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuEjercicio2 frame = new MenuEjercicio2();
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
	public MenuEjercicio2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 538, 448);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panelNotaEstudiante = new JPanel();
		panelNotaEstudiante.setBorder(new TitledBorder(new LineBorder(new Color(175, 238, 238)), "Notas del estuiante",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelNotaEstudiante.setBounds(41, 44, 324, 215);
		contentPane.add(panelNotaEstudiante);
		panelNotaEstudiante.setLayout(null);

		JLabel lblNota1 = new JLabel("Nota 1:");
		lblNota1.setBounds(40, 34, 39, 14);
		panelNotaEstudiante.add(lblNota1);
		lblNota1.setFont(new Font("Tahoma", Font.BOLD, 11));

		JLabel lblNota2 = new JLabel("Nota 2:");
		lblNota2.setBounds(40, 77, 39, 14);
		panelNotaEstudiante.add(lblNota2);
		lblNota2.setFont(new Font("Tahoma", Font.BOLD, 11));

		JLabel lblNota3 = new JLabel("Nota 3:");
		lblNota3.setBounds(40, 120, 39, 14);
		panelNotaEstudiante.add(lblNota3);
		lblNota3.setFont(new Font("Tahoma", Font.BOLD, 11));

		JLabel lblTPS = new JLabel("TPS");
		lblTPS.setBounds(40, 162, 21, 14);
		panelNotaEstudiante.add(lblTPS);
		lblTPS.setFont(new Font("Tahoma", Font.BOLD, 11));

		txtNota1 = new JTextField();
		txtNota1.setBounds(166, 31, 97, 20);
		panelNotaEstudiante.add(txtNota1);
		txtNota1.setColumns(10);

		txtNota2 = new JTextField();
		txtNota2.setBounds(166, 117, 97, 20);
		panelNotaEstudiante.add(txtNota2);
		txtNota2.setColumns(10);

		txtNota3 = new JTextField();
		txtNota3.setBounds(166, 74, 97, 20);
		panelNotaEstudiante.add(txtNota3);
		txtNota3.setColumns(10);

		JComboBox cbxTPS = new JComboBox();
		cbxTPS.setBounds(166, 159, 97, 20);
		panelNotaEstudiante.add(cbxTPS);
		cbxTPS.setModel(new DefaultComboBoxModel(new String[] { "Aprobado", "Desaprobado" }));
		cbxTPS.setForeground(new Color(0, 0, 0));
		cbxTPS.setFont(new Font("Tahoma", Font.PLAIN, 11));
		cbxTPS.setToolTipText("");

		// Panel para mostrar promedio y condici�n
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(41, 280, 324, 100);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		BevelBorder borde2 = new BevelBorder(BevelBorder.LOWERED, null, null, null, null);
		Border bordeConTitulo2 = BorderFactory.createTitledBorder(borde2, "Promedio y Condicion", TitledBorder.LEFT,
				TitledBorder.TOP, null, Color.BLACK);
		panel_1.setBorder(bordeConTitulo2);

		JLabel lblPromedio = new JLabel("Promedio");
		lblPromedio.setBounds(10, 30, 70, 14);
		panel_1.add(lblPromedio);

		JLabel lblCondicion = new JLabel("Condicion");
		lblCondicion.setBounds(10, 65, 70, 14);
		panel_1.add(lblCondicion);

		txtPromedio = new JTextField();
		txtPromedio.setBounds(160, 27, 123, 20);
		panel_1.add(txtPromedio);
		txtPromedio.setColumns(10);

		txtCondicion = new JTextField();
		txtCondicion.setBounds(160, 69, 123, 20);
		panel_1.add(txtCondicion);
		txtCondicion.setColumns(10);

		// Botones
		JButton btnNuevo = new JButton("NUEVO");
		btnNuevo.setBounds(377, 139, 91, 40);
		contentPane.add(btnNuevo);

		JButton btnCalcular = new JButton("CALCULAR");
		btnCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					// Obtiene las notas del usuario
					nota1 = Float.parseFloat(txtNota1.getText());
					nota2 = Float.parseFloat(txtNota2.getText());
					nota3 = Float.parseFloat(txtNota3.getText());

					// Verifica que las notas estén entre 1 y 10
					if (nota1 >= 1 && nota1 <= 10 && nota2 >= 1 && nota2 <= 10 && nota3 >= 1 && nota3 <= 10) {

						// Calcula la suma de las notas
						SumaNotas = nota1 + nota2 + nota3;
						// Saca la nota final a mostrar
						String NotaFinal = String.format("%.2f", SumaNotas / 3);
						// Mostrar Nota del Estudiante
						txtPromedio.setText(NotaFinal);

						// Calcular Condicion del Estudiante

						if (cbxTPS.getSelectedItem().toString().matches("Aprobado") && nota1 >= 8 && nota2 >= 8
								&& nota3 >= 8) {
							txtCondicion.setText("Promocionado");
						} else if (cbxTPS.getSelectedItem().toString().matches("Desaprobado") || nota1 < 6 || nota2 < 6
								|| nota3 < 6) {
							txtCondicion.setText("Libre");
						} else {
							txtCondicion.setText("Regular");
						}

					} else {
						// Muestra un mensaje de error si las notas no están en el rango válido
						JOptionPane.showMessageDialog(MenuEjercicio2.this, "Las notas deben estar entre 1 y 10.",
								"Error", JOptionPane.ERROR_MESSAGE);
					}
				} catch (NumberFormatException ex) {
					// Muestra un mensaje de error si el usuario no ingresó números válidos
					JOptionPane.showMessageDialog(MenuEjercicio2.this,
							"Por favor, ingrese numeros validos para las notas.", "Error", JOptionPane.ERROR_MESSAGE);
					// Limpiamos los textbox
					txtNota1.setText("");
					txtNota2.setText("");
					txtNota3.setText("");
					txtCondicion.setText("");
					txtPromedio.setText("");
					cbxTPS.setSelectedIndex(0);
				}

			}
		});
		btnCalcular.setBounds(375, 86, 93, 40);
		contentPane.add(btnCalcular);

		JButton btnNewButton = new JButton("SALIR");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton.setBounds(377, 192, 91, 40);
		contentPane.add(btnNewButton);

		// Acci�n para el bot�n Nuevo
		btnNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtNota1.setText("");
				txtNota2.setText("");
				txtNota3.setText("");
				txtPromedio.setText("");
				txtCondicion.setText("");
				cbxTPS.setSelectedIndex(0);
			}
		});
	}
}
