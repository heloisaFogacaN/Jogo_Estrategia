import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    private ArrayList<Posicao> listaPosicoes;
    static Tabuleiro tabuleiro = new Tabuleiro();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        mostrarTabuleiro();


    }

    private static boolean validarVitoria(Jogador adversario) {
        for (Unidade unidade : adversario.getUnidade()) {
            if (unidade instanceof Hobbits) {
                return false;
            }
            return true;
        }
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