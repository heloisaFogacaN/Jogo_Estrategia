import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    private ArrayList<Posicao> listaPosicoes;
    private static  Scanner scanner = new Scanner(System.in);
    static Tabuleiro tabuleiro = new Tabuleiro();
    public static void main(String[] args) {
        boolean jogoAcabou=false;
        Jogador j1 = new Jogador("Jorge", "Senh@123");
        Jogador j2 = new Jogador("Wilson", "Wilson");
        mostrarTabuleiro();
        do{
            pedirBatalha(j1,j2);
        } while(!jogoAcabou);

    }

    private static void pedirBatalha(Jogador j1, Jogador j2) {
        boolean torreEncontrada = false;
        int turno=1;

        do {
            if(turno==1){
                System.out.println("Jogador "+ j1.getNome());
            } else if(turno==2){
                System.out.println("Jogador "+ j2.getNome());
            }

            System.out.println("\nInforme a posição da torre que deseja conquistar:");
            Posicao escolhaPosicao = new Posicao(scanner.nextInt() -1);

            Tabuleiro tabuleiro = new Tabuleiro();
            for (Posicao posicao : tabuleiro.posicoes) {
                if (posicao.getNumero()==escolhaPosicao.getNumero() && Tabuleiro.verificarTorreNaPosicao(escolhaPosicao)) {
                    torreEncontrada = true;
                    System.out.println("Jogador " + j1.getNome());
                    Magos magoJogador = escolherMago();
                    System.out.println("Jogador " +j2.getNome());
                    Magos magoAdversario = escolherMago();
                    batalhar(magoJogador, magoAdversario, escolhaPosicao, j1, j2, turno);
                    break;
                }
            }
            if (!torreEncontrada) {
                System.out.println("Não há uma torre na posição informada. Escolha outra posição!");
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

    public static void batalhar(Magos magoJogador, Magos magoAdversario, Posicao posicaoAtacada, Jogador j1, Jogador j2, int turno){
        Magos atacante = magoJogador;
        Magos defensor = magoAdversario;

        do{
            if(turno==1){
                System.out.println("Jogador "+j1.getNome()+ " você deseja fazer qual jogada: ");
            } else if(turno==2){
                System.out.println("Jogador "+j2.getNome()+ " você deseja fazer qual jogada: ");
            }

            System.out.println("""
                    1- Ataque
                    2- Ataque Especial
                    """);
            int opcao=scanner.nextInt();

          if (magoJogador.getVida() > 0 && magoAdversario.getVida() > 0) {
              if(opcao == 1){
                  defensor.receberAtaque(atacante.getAtaque());
                  System.out.println(defensor.getVida());
                  if(turno==1){
                      atacante = magoAdversario;
                      defensor = magoJogador;
                      turno++;
                  } else if(turno==2){
                      atacante = magoJogador;
                      defensor = magoAdversario;
                      turno--;
                  }
              }
            }

        } while(turno!=3);
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
        }
}