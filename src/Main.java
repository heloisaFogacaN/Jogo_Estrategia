import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    private ArrayList<Posicao> listaPosicoes;
    static Tabuleiro tabuleiro = new Tabuleiro();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        mostrarTabuleiro();
        System.out.println("\nInforme a torre que deseja conquistar:");
        int escolhaPosicao = scanner.nextInt();
        Posicao posicao = posicoes.get(escolhaPosicao);
        System.out.println("""
                Você deseja utilizar qual mago?
                1- Mago Branco
                2- Mago Cinzento
                3- Mago Negro
                """);
        int opcao= scanner.nextInt();
        Magos tipoMago= null;
        switch (opcao){
            case 1:
                 tipoMago = new MagoBranco(450, 60, 60);
                break;
            case 2:
                tipoMago = new MagoCinzento(450, 60, 60);
                break;
            case 3:
                tipoMago = new MagoNegro(450, 60, 60);
        }
        Batalha.batalhar(escolhaPosicao,tipoMago);
    }

    private static boolean validarVitoria(Jogador adversario) {
        return true;
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
                            System.out.print("|   | ");
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