import java.util.Scanner;
/**
 *  Esta es una clase estática que permite calcular todos los
 * números primos desde el número 2 hasta un número entero
 * suministrado como parámetro al método generarPrimos.
 * 
 * @author Juan Vicente Costa Morales (Profesor)
 * @author Antonio Molina Gutiérrez (Alumno)
 * @version 1.0.0 24/02/2021
 * 
 */
public class Criba {
	/**
	 *  Este método privado acepta como parámetro un <b>entero positivo</b>
	 * y devuelve un array de enteros con todos los números
	 * primos comprendidos entre el 2 y valor del parámetro.
	 *  En el caso de que el parámetro sea menor que 2, se
	 * devuelve un array de enteros vacío.
	 * @param max int Valor hasta el que se calculan los primos
	 * @return int[] Los números primos hallados.
	 */
	public static int[] generarPrimos(int max) {
		int i, j;
		if (max >= 2) {
			// Declaraciones
			int dim = max + 1; // Tamaño del array
			boolean[] esPrimo = new boolean[dim];
			// Inicializar el array
			for (i = 0; i < dim; i++)
				esPrimo[i] = true;
			// Eliminar el 0 y el 1, que no son primos
			esPrimo[0] = esPrimo[1] = false;
			// Criba
			for (i = 2; i < Math.sqrt(dim) + 1; i++) {
				if (esPrimo[i]) {
					// Eliminar los múltiplos de i
					for (j = 2 * i; j < dim; j += i)
						esPrimo[j] = false;
				}
			}
			return getPrimos(esPrimo);
		} else { // max < 2
			return new int[0];
			// Vector vacío
		}
	}
	
	/**
	 *  Este método acepta como parámetro un array de booleanos
	 * y devuelve un array de enteros con los índices de los
	 * elementos del array booleano cuyo valor es true.
	 * @param esPrimo boolean[]
	 * @return int[]
	 */
	private static int[] getPrimos(boolean[] esPrimo) {
		int i;
		int j;
		// ¿Cuántos primos hay?
		int cuenta = 0;

		for (i = 0; i < esPrimo.length; i++) {
			if (esPrimo[i])
				cuenta++;
		}

		// Rellenar el vector de números primos
		int[] primos = new int[cuenta];
		for (i = 0, j = 0; i < esPrimo.length; i++) {
			if (esPrimo[i])
				primos[j++] = i;
		}

		return primos;
	}

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		System.out.println("Introduce el número para la criba de Erastótenes:");
		int dato = teclado.nextInt();
		teclado.close();
		int vector[] = new int[dato];
		System.out.println("\nVector inicial hasta :" + dato);
		for (int i = 0; i < vector.length; i++) {
			if (i % 10 == 0)
				System.out.println();
			System.out.print(i + 1 + "\t");
		}
		vector = generarPrimos(dato);
		System.out.println("\nVector de primos hasta:" + dato);
		for (int i = 0; i < vector.length; i++) {
			if (i % 10 == 0)
				System.out.println();
			System.out.print(vector[i] + "\t");
		}
	}
}