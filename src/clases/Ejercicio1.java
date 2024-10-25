package clases;

import java.util.ArrayList;

import javax.swing.JTextField;

public class Ejercicio1 {

	public static ArrayList<JTextField> removerTextboxConTexto(ArrayList<JTextField> TxtBoxes) {

		ArrayList<JTextField> TxtVacias = new ArrayList<JTextField>();

		// Añade las cajas vacias a una lista
		for (JTextField textBox : TxtBoxes) {
			if (textBox.getText().length() == 0) {
				TxtVacias.add(textBox);
			}
		}
		return TxtVacias;
	}
}
