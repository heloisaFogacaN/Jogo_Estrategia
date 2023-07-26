import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    private ArrayList<Posicao> listaPosicoes;
    private static  Scanner scanner = new Scanner(System.in);
    static Tabuleiro tabuleiro = new Tabuleiro();
    public static void main(String[] args) {
        Jogador j1 = new Jogador("Jorge", "Senh@123");
        Jogador j2 = new Jogador("Wilson", "Wilson");
        mostrarTabuleiro();
        boolean torreEncontrada = false;

        do {
            System.out.println("\nInforme a posição da torre que deseja conquistar:");
            int escolhaPosicao = scanner.nextInt();

            Tabuleiro tabuleiro = new Tabuleiro();
            for (Posicao posicao : tabuleiro.posicoes) {
                if (posicao.equals(escolhaPosicao) && Tabuleiro.verificarTorreNaPosicao(escolhaPosicao)==true) {
                    torreEncontrada = true;
                    Magos magoJogador = escolherMago();
                    Magos magoAdversario = escolherMago();
                    batalhar( magoJogador, magoAdversario, escolhaPosicao, j1, j2);
                    break;
                }
            }
            if (!torreEncontrada) {
                System.out.println("Não há uma torre na posição informada. Escolha outra posição.");
            }
        }while(!torreEncontrada);

    }

    private static Magos escolherMago() {
        System.out.println("""
            Você deseja utilizar qual mago?
            1- Mago Branco
            2- Mago Cinzento
            3- Mago Negro
            """);
        int opcao = scanner.nextInt();
        Magos tipoMago = null;

        switch (opcao) {
            case 1:
                tipoMago = new MagoBranco(565,45);
                break;
            case 2:
                tipoMago = new MagoCinzento(560, 40);
                break;
            case 3:
                tipoMago = new MagoNegro(550, 50);
                break;
            default:
                System.out.println("Opção inválida. Escolha novamente.");
                tipoMago = escolherMago();
        }
        return tipoMago;
    }

    public static void batalhar(Magos magoJogador, Magos magoAdversario, int posicaoAtacada, Jogador j1, Jogador j2){
        Magos atacante = magoJogador;
        Magos defensor = magoAdversario;


        while (magoJogador.getVida() > 0 && magoAdversario.getVida() > 0) {
            defensor.receberAtaque(atacante.getAtaque());

            Magos jogada = atacante;
            atacante = defensor;
            defensor = jogada;
        }
        if (magoJogador.getVida() > 0) {
            System.out.println("O mago jogador venceu a batalha!");
            j1.vencerBatalha(tabuleiro, posicaoAtacada);
        } else if (magoAdversario.getVida() > 0) {
            System.out.println("O mago adversário venceu a batalha!");
        } else {
            System.out.println("A batalha terminou em empate!");
        }
    }


    public static void mostrarTabuleiro() {
            int posicao = 0;

            for (int i = 0; i < 7; i++) {
                for (int j = 0; j < 9; j++) {
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