// Felipe Scrochio Custódio - 9442688
/**
 * Dado usado no jogo de Bozó. 
 * Pode ter número de lados variável. Possui métodos para
 * fazer a jogada e exibir seu resultado graficamente.
 */
public class Dado {
	
	// Campos
	private int lados;
	private int resultado;

	// Construtores
	/** 
	* Construtor padrão, inicializa um dado de 6 lados 
	*/
	public Dado() {
		lados = 6;
	}

	/**
	 * Construtor que retorna um dado com n lados
	 * @param  n Número de lados desejado
	 * @return   Dado inicializado com n lados
	 */
	public Dado(int n) {
		lados = n;
	}
	
	// Métodos
	/**
	 * Retorna o último resultado do dado
	 * @return int com o resultado do dado
	 */
	public int getLado() {
		return resultado;
	}

	/**
	 * Faz a jogada do dado.
	 * @return Um número de 1 até o número de lados do dado
	 */
	public int rolar() {
		Random r = new Random();
		resultado = r.getIntRand(lados) + 1; // 1 a Lados
		/* resultado do dado deve ser armazenado */
		return resultado;
	}

	/**
	 * Retorna e imprime o resultado do dado de forma gráfica
	 * @return String contendo o resultado do dado em forma gráfica
	 */
	@Override
	public java.lang.String toString() {
		String d;
		if(lados == 6) {
			switch(resultado) {
				case 1:
					d = "+-----+\n|     |\n|  *  |\n|     |\n+-----+";
					System.out.println(d);
					return d;
				case 2:
					d = "+-----+\n|    *|\n|     |\n|*    |\n+-----+";
					System.out.println(d);
					return d;
				case 3:
					d = "+-----+\n|    *|\n|  *  |\n|*    |\n+-----+";
					System.out.println(d);
					return d;
				case 4:
					d = "+-----+\n|*   *|\n|     |\n|*   *|\n+-----+";
					System.out.println(d);
					return d;
				case 5:
					d = "+-----+\n|*   *|\n|  *  |\n|*   *|\n+-----+";
					System.out.println(d);
					return d;
				case 6:
					d = "+-----+\n|*   *|\n|*   *|\n|*   *|\n+-----+";
					System.out.println(d);
					return d;
			}
		} else {
			System.out.println("Esse tipo de dado não pode ser impresso.");
			return;
		}
	}
}










