import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    private ArrayList<Posicao> listaPosicoes;
    private static Scanner scanner = new Scanner(System.in);
    static Tabuleiro tabuleiro = new Tabuleiro();

    public static void main(String[] args) {
        boolean jogoAcabou = false;
        Jogador j1 = new Jogador("Jorge", "Senh@123");
        Jogador j2 = new Jogador("Wilson", "Wilson");
        mostrarTabuleiro();
        do {
            pedirBatalha(j1, j2);
        } while (!jogoAcabou);

    }

    private static void pedirBatalha(Jogador j1, Jogador j2) {
        boolean torreEncontrada = false;
        int turno = 1;

        do {
            if (turno == 1) {
                System.out.println("Jogador " + j1.getNome());
            } else if (turno == 2) {
                System.out.println("Jogador " + j2.getNome());
            }

            System.out.println("\nInforme a posição da torre que deseja conquistar:");
            Posicao escolhaPosicao = new Posicao(scanner.nextInt() - 1);

            Tabuleiro tabuleiro = new Tabuleiro();
            for (Posicao posicao : tabuleiro.posicoes) {
                if (posicao.getNumero() == escolhaPosicao.getNumero() && Tabuleiro.verificarTorreNaPosicao(escolhaPosicao)) {
                    torreEncontrada = true;
                    System.out.println("Jogador " + j1.getNome());
                    Magos magoJogador = escolherMago();
                    System.out.println("Jogador " + j2.getNome());
                    Magos magoAdversario = escolherMago();
                    batalhar(magoJogador, magoAdversario, escolhaPosicao, j1, j2);
                    break;
                }
            }
            if (!torreEncontrada) {
                System.out.println("Não há uma torre na posição informada. Escolha outra posição!");
            }
        } while (!torreEncontrada);
    }

    private static Magos escolherMago() {
        boolean opcaoValida=false;
        Magos tipoMago = null;
        do{
            System.out.println("""
                Você deseja utilizar qual mago?
                1- Mago Branco
                2- Mago Cinzento
                3- Mago Negro
                """);
            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    tipoMago = new MagoBranco(565, 45);
                    opcaoValida=true;
                    break;
                case 2:
                    tipoMago = new MagoCinzento(560, 40);
                    opcaoValida=true;
                    break;
                case 3:
                    tipoMago = new MagoNegro(550, 50);
                    opcaoValida=true;
                    break;
                default:
                    System.out.println("Opção inválida. Escolha novamente.");
            }
        } while(!opcaoValida);

        System.out.println(tipoMago.getVida());

        return tipoMago;
    }

    public static void batalhar(Magos magoJogador, Magos magoAdversario, Posicao posicaoAtacada, Jogador j1, Jogador j2) {
        Magos atacante = magoJogador;
        Magos defensor = magoAdversario;
        int turno = 1;
        boolean jogoAcabou = false;

        do {
            if (turno == 1) {
                System.out.println("Jogador " + j1.getNome() + ", você deseja fazer qual jogada: ");
                System.out.println(magoJogador.getVida());
            } else if (turno == 2) {
                System.out.println("Jogador " + j2.getNome() + ", você deseja fazer qual jogada: ");
                System.out.println(magoAdversario.getVida());
            }

            System.out.println("""
            1- Ataque
            2- Ataque Especial (você pode fazer apenas três ataques especiais por rodada)
            """);
            int opcao = scanner.nextInt();

            if (opcao == 1) {
                System.out.println("tô aqui pra morrer");
                // Ataque normal
                defensor.receberAtaque(atacante.getAtaque());
                System.out.println("Vida do Mago após o ataque: " + defensor.getVida());
            } else if (opcao == 2) {
                System.out.println("maluquice");
                // Ataque especial
                int ataqueTotal = atacante.getAtaque() + atacante.getAtaqueEspecial();
                defensor.receberAtaque(ataqueTotal);
                System.out.println("Vida do Mago após o ataque especial: " + defensor.getVida());
            }

            // Verificar se o defensor foi derrotado
            if (defensor.getVida() <= 0) {
                System.out.println("Jogador venceu a batalha!");
                jogoAcabou = true; // Define que o jogo acabou
            }

            // Alternar os jogadores após cada ataque
            Magos temp = atacante;
            atacante = defensor;
            defensor = temp;
            turno = (turno == 1) ? 2 : 1;
        } while (!jogoAcabou);
    }



    public static void mostrarTabuleiro() {
            int posicao = 0;

            for (int i = 0; i < 7; i++) {
                for (int j = 0; j <9; j++) {
                    if (posicao < tabuleiro.getPosicoes().size()) {
                        Unidade unidade = tabuleiro.getPosicoes().get(posicao).getUnidade();
                        if (unidade != null) {
                            System.out.print("|" + unidade + "| ");
                        } else {
                            System.out.print("|  | ");
                        }
                        posicao++;
                    } else {
                        System.out.print("   ");
                    }
                }
                System.out.println();
            }
            posicao = 0;
        }
}