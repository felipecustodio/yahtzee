public class Placar {

    /* posicoes = armazena placar com numero das posicoes */
    private int[] posicoes;
    /* jogadas = inicilizado com -1 para verificar se posição foi usada, armazena resultados */
    public int[] jogadas;
    private int escore;

	public Placar() {
        /* inicializar posições e escore */
        /* preencher placar com posições */
        posicoes = new int[11];
        jogadas = new int[11];
        for (int i = 0; i < 10; i++) {
            jogadas[i] = -1;
            switch (i) {
                case 1:
                /* posição externa */
                    posicoes[0] = i;
                    break;
                case 2:
                /* posição externa */
                    posicoes[3] = i;
                    break;
                case 3:
                /* posição externa */
                    posicoes[6] = i;
                    break;
                case 4:
                /* posição externa */
                    posicoes[2] = i;
                    break;
                case 5:
                /* posição externa */
                    posicoes[5] = i;
                    break;
                case 6:
                /* posição externa */
                    posicoes[8] = i;
                    break;
                case 7:
                /* posição interna: full */
                    posicoes[1] = i;
                    break;
                case 8:
                /* posição interna: seq. */
                    posicoes[4] = i;
                    break;
                case 9:
                /* posição intena: quadra */
                    posicoes[7] = i;
                    break;
                case 10:
                /* posição interna: quina */
                    posicoes[10] = i;
                    break;
            }
        }
        escore = 0;
	}

	public void add(int posicao, int[] dados) throws java.lang.IllegalArgumentException {
        /* posições da tabela de escore != índice do vetor de posições
        ex.: na representação gráfica, o 7 ocupa a segunda posição */
        /* calcular valor que será inserido caso seja posição interna (soma dos valores) */
        int soma = 0;
        int contador;
        for (int i = 0; i < 5; i++) soma += dados[i];
        /* verificar posição */
        switch (posicao) {
            case 1:
                /* posição externa */
                jogadas[0] = soma;
                break;
            case 2:
                /* posição externa */
                jogadas[3] = soma;
                break;
            case 3:
                /* posição externa */
                jogadas[6] = soma;
                break;
            case 4:
                /* posição externa */
                jogadas[2] = soma;
                break;
            case 5:
                /* posição externa */
                jogadas[5] = soma;
                break;
            case 6:
                /* posição externa */
                jogadas[8] = soma;
                break;
            case 7:
                /* posição interna: full */
                /* fazer checagem do full */
                for (int i = 0; i < 5; i++) {
                    contador = 0;
                    for (int j = 0; j < 5; j++) {
                        if (dados[j] == dados[i]) {
                            contador++;
                        }
                    }
                    if (contador == 3) {
                        jogadas[1] = 15;
                        break;
                    }
                }
                jogadas[1] = 0;
                break;
            case 8:
                /* posição interna: seq. */
                /* fazer checagem da sequência */
                /* primeiro passo: ordenar vetor para facilitar */
                int aux;
                for (int i = 0; i < 5; i++) {
                    for (int j = 0; j < 4; j++) {
                        if (dados[j] > dados[j + 1]) {
                            aux = dados[j];
                            dados[j] = dados[j + 1];
                            dados[j + 1] = aux;
                        }
                    }
                }
                aux = 0;
                /* verificar 1 2 3 4 5 */
                for (int i = 0; i < 5; i++) {
                    if (dados[i] == i + 1) {
                        aux++;
                    }
                }
                if (aux == 5) {
                    jogadas[4] = 20;
                    break;
                } else {
                    /* verificar 2 3 4 5 6 */
                    aux = 0;
                    for (int i = 0; i < 5; i++) {
                        if (dados[i] == i + 2) {
                            aux++;
                        }
                    }
                    if (aux == 5) {
                        jogadas[4] = 20;
                        break;
                    } else {
                        jogadas[4] = 0;
                        break;
                    }
                }
            case 9:
                /* posição intena: quadra */
                /* fazer checagem da quadra */
                for (int i = 0; i < 5; i++) {
                    contador = 0;
                    for (int j = 0; j < 5; j++) {
                        if (dados[j] == dados[i]) {
                            contador++;
                        }
                    }
                    if (contador == 4) {
                        jogadas[7] = 30;
                        break;
                    }
                }
                jogadas[7] = 0;
                break;
            case 10:
                /* posição interna: quina */
                // fazer checagem da quina
                for (int i = 0; i < 5; i++) {
                    contador = 0;
                    for (int j = 0; j < 5; j++) {
                        if (dados[j] == dados[i]) {
                            contador++;
                        }
                    }
                    if (contador == 5) {
                        jogadas[10] = 40;
                        break;
                    }
                }
                jogadas[10] = 0;
                break;
        }
        /* atualizar posicoes */
        for (int i = 0; i < 10; i++) {
            if (jogadas[i] != -1) posicoes[i] = jogadas[i];
        }
  }

  public int getScore() {
      escore = 0;
      for (int i = 0; i < 10; i++) {
          if (jogadas[i] != -1) escore += jogadas[i];
      }
      return escore;
  }

    @Override
  public java.lang.String toString() {
        /* por que esse método retorna string? */
        String s = "Placar";
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 3; j++) {
                /* posição inútil do vetor: 9*/
                if (i == 9) {
                    System.out.print(" \t | \t");
                } else {
                    if (jogadas[i] != -1) {
                        System.out.print(jogadas[i] + "\t | \t");
                    } else {
                        System.out.print(posicoes[i] + "\t | \t");
                    }
                }
                i++;
            }
            System.out.print("\n");
        }
        /* imprimir posição 10 separadamente (embaixo do placar) */
        if (jogadas[10] != -1) {
            System.out.print("\t" + jogadas[10] + "\t | \n");
        } else {
            System.out.print("\t" + posicoes[10] + "\t | \n");
        }

        return s;
  }
}