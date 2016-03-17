/**
* Classe que faz a rolagem dos dados, pela primeira vez,
* ou também rolando dados que o usuario deseja rolar novamente
* @author Felipe Custodio, Gabriel Scalici
*/
public class RolaDados {
	
	Dado[] dados;

	/**
	* Cria e armazena vários objetos do tipo dado
	* Inicializa todos os dados em um array de dados
	* @param n Número de dados desejados
	*/

	public RolaDados(int n) {
		dados = new Dado[n];
		for (int i = 0; i < n; i++) {
			dados[i] = new Dado();
		}
	}

	public int[] rolar() {
		int[] resultados = new int[dados.length]; 
		/* Número de resultados = Número de dados */
		for (int i = 0; i < dados.length; i++) resultados[i] = dados[i].rolar();
		return resultados;
	}

	public int[] rolar(boolean[] quais) {
		int[] resultados = new int[dados.length];
		for (int i = 0; i < dados.length; i++) {
			if (quais[i]) {
				resultados[i] = dados[i].rolar();
			} else {
				resultados[i] = dados[i].getLado();
			}
		}
		return resultados;
	}

	public int[] rolar(java.lang.String s) {
		int i, j, k; // auxiliares
		// converter string de indices para inteiros
		String aux[] = s.trim().split(" ");
		int indices[] = new int[aux.length];
		for (i = 0; i < aux.length; i++) {
			indices[i] = Integer.parseInt(String.valueOf(aux[i]));
		}
		// rolar dados
		int[] resultados = new int[dados.length];
		k = 0;
		j = indices[k] - 1;
		for (i = 0; i < dados.length; i++) {
			// verificar se índice é pra ser rolado
			if (i == j) {
				// índice rolado, passar para o próximo
				resultados[i] = dados[i].rolar();
				k++;
                if (k < indices.length) {
                    j = indices[k] - 1;
                }
			} else {
				resultados[i] = dados[i].getLado();
			}	
		}
		return resultados;
	}

	@Override
	public java.lang.String toString() {
		String s = " ";
		String[] desenhos = new String[dados.length];
		// imprimir índices dos dados
		for (int i = 0; i < dados.length; i++) {
			// espaçamento: tamanho do dado
			System.out.print(i+1 + "          "); 
		}
		System.out.print("\n"); 
		// imprimir desenhos dos dados
		for (int i = 0; i < dados.length; i++) {
			desenhos[i] = dados[i].toString();
		}
        return s;
	}

	public static void main(java.lang.String[] args) throws java.lang.Exception {

	}
}