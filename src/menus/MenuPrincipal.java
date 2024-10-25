package menus;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MenuPrincipal extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuPrincipal frame = new MenuPrincipal();
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
	public MenuPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblGrupoNro = new JLabel("GRUPO NRO 7:");
		lblGrupoNro.setBounds(10, 11, 89, 14);
		contentPane.add(lblGrupoNro);
		
		JButton btnEjercicio1 = new JButton("Ejercicio 1");
		btnEjercicio1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuEjercicio1 ejercicio1 = new MenuEjercicio1();
		        ejercicio1.setVisible(true);
		        //dispose(); // Cierra la ventana principal
			}
		});
		btnEjercicio1.setBounds(60, 47, 121, 23);
		contentPane.add(btnEjercicio1);
		
		JButton btnEjercicio2 = new JButton("Ejercicio 2");
		btnEjercicio2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuEjercicio2 ejercicio2 = new MenuEjercicio2();
		        ejercicio2.setVisible(true);
		        //dispose(); // Cierra la ventana principal
			}
		});
		btnEjercicio2.setBounds(60, 81, 121, 23);
		contentPane.add(btnEjercicio2);
		
		JButton btnEjercicio3 = new JButton("Ejercicio 3");
		btnEjercicio3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuEjercicio3 ejercicio3 = new MenuEjercicio3();
		        ejercicio3.setVisible(true);
		        //dispose(); // Cierra la ventana principal
			}
		});
		btnEjercicio3.setBounds(60, 115, 121, 23);
		contentPane.add(btnEjercicio3);
	}

}
