public class Bozo {
	public Bozo() {
		
	}

	public static void main(java.lang.String[] args) throws java.io.IOException {
        /* Variáveis auxiliares */
        String buffer;
        String toRoll;
        int position;
        int[] resultados = new int[5];
        int contaJogadas;
        int escolhaJogada;
        int posicaoUsada;
        int finalScore = 0;
        /* Objetos auxiliares */
        RolaDados dice = new RolaDados(5);
        Placar score = new Placar();
        /* 10 rodadas */
        for (int i = 0; i < 10; i++) {
            System.out.print("Pressione ENTER para iniciar a rodada ");
            buffer = EntradaTeclado.leString();
            contaJogadas = 0;
            System.out.println("Rolando dados...");
            resultados = dice.rolar();
            System.out.println("Seus resultados:");
            /* exibir dados */
            buffer = dice.toString();
            /* jogador tem três tentativas de rolar os dados
            até decidir colocar resultados no placar */
            while (contaJogadas < 3) {
                /* perguntar se o usuário quer rolar de
                novo ou inserir e pegar a pontuação */
                System.out.println("Deseja rolar novamente ou inserir seus resultados no placar?");
                System.out.println("1) Rolar 2) Inserir no placar");
                escolhaJogada = EntradaTeclado.leInt();
                if (escolhaJogada == 1) {
                    System.out.print("Escolha os dados a serem rolados (digite os números separados por espaço): ");
                    toRoll = EntradaTeclado.leString();
                    resultados = dice.rolar(toRoll);
                    System.out.println("Seus resultados:");
                    /* exibir dados */
                    buffer = dice.toString();
                    contaJogadas++;
                } else {
                    if (escolhaJogada == 2) {
                        contaJogadas = 3;
                    }
                }
            }
            /* escolheu adicionar e pegar a pontuação (saiu do while) */
            posicaoUsada = 0;
            position = 0;
            while (posicaoUsada != 1) {
                System.out.print("Escolha a posição que deseja ocupar: ");
                position = EntradaTeclado.leInt();
                if (score.jogadas[position] == -1) {
                    posicaoUsada = 1;
                } else {
                    System.out.println("Posição já utilizada! Selecione outra.");
                }
            }
            score.add(position, resultados);
        }
        /* fim de jogo */
        finalScore = score.getScore();
        System.out.println("Fim de jogo!");
        score.toString();
        System.out.print("Placar final: " + finalScore);
	}
}