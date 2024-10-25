package clases;

import java.util.ArrayList;

public class Ejercicio3 {

	public static String ConcatenarOpciones(String OS, ArrayList<String> Especialidades, String Horas) {
		String EspecialidadesConcatenadas = "";

		// Concatena las especialidades
		for (String especialidad : Especialidades) {
			EspecialidadesConcatenadas = EspecialidadesConcatenadas + especialidad + ", ";
		}

		// Remueve la coma colgante
		String EspecialidadesFinal = EspecialidadesConcatenadas.substring(0, EspecialidadesConcatenadas.length() - 2);

		// Arma el texto final
		String TextoFinal = OS + " - " + EspecialidadesFinal + " - " + Horas + "Hs";

		return TextoFinal;
	}
}
