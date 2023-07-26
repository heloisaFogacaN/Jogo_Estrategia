import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    private ArrayList<Posicao> listaPosicoes;
    private static  Scanner scanner = new Scanner(System.in);
    static Tabuleiro tabuleiro = new Tabuleiro();
    public static void main(String[] args) {
        mostrarTabuleiro();
        System.out.println("\nInforme a posição da torre que deseja conquistar:");
        int escolhaPosicao = scanner.nextInt();

        Tabuleiro tabuleiro = new Tabuleiro();

        for (Posicao posicao : tabuleiro.posicoes) {
            if (posicao.equals(escolhaPosicao)) {
                Magos magoJogador = escolherMago();
                Magos magoAdversario = escolherMago();
                batalhar(escolhaPosicao, magoJogador, magoAdversario);
                break; // Para sair do loop quando encontrar a posição desejada
            }
        }
    }

    private static boolean validarVitoria(Jogador adversario) {
        return true;
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
                tipoMago = new MagoBranco(450, 60, 60);
                break;
            case 2:
                tipoMago = new MagoCinzento(450, 60, 60);
                break;
            case 3:
                tipoMago = new MagoNegro(450, 60, 60);
                break;
            default:
                System.out.println("Opção inválida. Escolha novamente.");
                tipoMago = escolherMago();
        }

        return tipoMago;
    }

    public static void batalhar(int escolhaPosicao, Magos magoJpgador, Magos magoAdversario){

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