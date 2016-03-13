extends java.lang.Object
public class RolaDados {
	
	Dado[] dados;

	public RolaDados(int n) {
		dados = new Dado[n];
		for (int i = 0; i < n; i++) {
			dados[i] = new Dado();
		}
	}

	int[] rolar() {
		int[] resultados = new int[dados.length]; /* Número de resultados = Número de dados */
		for (int i = 0; i < dados.length; i++) {
			resultados[i] = dados[i].rolar();
		}
		return resutados;
	}

	int[] rolar(boolean[] quais) {
		int[] resultados = new int[dados.length];
		for (int i = 0; i < dados.length; i++) {
			if(quais[i]) {
				resultados[i] = dados[i].rolar();
			} else {
				resultados[i] = dados[i].getLado();
			}
		}
		return resultados;
	}

	int[] rolar(java.lang.String s) {
		// parse string to integers separated by space
	}

	@Override
	java.lang.String toString() {
		// how to print horizontally?
	}

	public static void main(java.lang.String[] args) throws java.lang.Exception {
		
	}

}