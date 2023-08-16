import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean jogoAcabou = false;
        Tabuleiro tabuleiro = new Tabuleiro();

        Jogador j1 = new Jogador("Jorge", "Senh@123", "branco");
        Jogador j2 = new Jogador("Wilson", "Wilson", "preta");

        int turno = 1;
        do {
            System.out.println(j1.getPontos() +" pontos jogador 1");
            System.out.println(j2.getPontos() +" pontos jogador 2");
            mostrarTabuleiro(tabuleiro);
            pedirBatalha(tabuleiro, j1, j2, turno);
            turno = (turno == 1) ? 2 : 1;
            jogoAcabou = verificarPontuacao(j1, j2);
        } while (!jogoAcabou);
    }

    private static void pedirBatalha(Tabuleiro tabuleiro, Jogador j1, Jogador j2, int turno) {
        boolean torreEncontrada = false;
        do {
            System.out.println("\nInforme a posição da torre que deseja conquistar:");
            Posicao escolhaPosicao = new Posicao(scanner.nextInt() - 1);

            for (Posicao posicao : tabuleiro.posicoes) {
                if (posicao.getNumero() == escolhaPosicao.getNumero() && Tabuleiro.verificarTorreNaPosicao(escolhaPosicao)) {
                    torreEncontrada = true;
                    System.out.println("Jogador " + j1.getNome());
                    j1.setMago(escolherMago());
                    System.out.println("Jogador " + j2.getNome());
                    j2.setMago(escolherMago());
                    batalhar(tabuleiro, j1.getMago(), j2.getMago(), escolhaPosicao, j1, j2, turno);
                    break;
                }
            }
            if (!torreEncontrada) {
                System.out.println("Não há uma torre na posição informada. Escolha outra posição!");
            }
        } while (!torreEncontrada);
    }

    private static Magos escolherMago() {
        boolean opcaoValida = false;
        Magos tipoMago = null;
        do {
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
                    opcaoValida = true;
                    break;
                case 2:
                    tipoMago = new MagoCinzento(560, 40);
                    opcaoValida = true;
                    break;
                case 3:
                    tipoMago = new MagoNegro(550, 50);
                    opcaoValida = true;
                    break;
                default:
                    System.out.println("Opção inválida. Escolha novamente.");
            }
        } while (!opcaoValida);

        return tipoMago;
    }

    public static void batalhar(Tabuleiro tabuleiro, Magos magoJogador, Magos magoAdversario, Posicao posicaoAtacada, Jogador j1, Jogador j2, int turno) {
        int contadorAtaqueEspecial = 0;
        boolean rodadaAcabou = false;

        do {
            boolean trocarJogador = false;
            if (turno == 1) {
                System.out.println("\nJogador " + j1.getNome() + ", você deseja fazer qual jogada: ");
            } else if (turno == 2) {
                System.out.println("\nJogador " + j2.getNome() + ", você deseja fazer qual jogada: ");
            }

            System.out.println("""
                    1- Ataque
                    2- Ataque Especial (você pode fazer apenas três ataques especiais por rodada)
                    """);
            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    if (turno == 1) {
                        Magos.atacar(magoAdversario, magoJogador.getAtaque());
                        System.out.println("Vida do Mago do jogador " + j2.getNome() + " após o ataque: " + magoAdversario.getVida());
                    } else {
                        Magos.atacar(magoJogador, magoAdversario.getAtaque());
                        System.out.println("Vida do Mago do jogador " + j1.getNome() + " após o ataque: " + magoJogador.getVida());
                    }
                    trocarJogador = true;
                    break;
                case 2:
                    contadorAtaqueEspecial++;
                    if (contadorAtaqueEspecial <= 3) {
                        if (turno == 1) {
                            Magos.atacar(magoAdversario, (magoJogador.getAtaque() + magoAdversario.getAtaqueEspecial()));
                            System.out.println("Vida do Mago após o ataque especial: " + magoJogador.getVida());
                        } else {
                            Magos.atacar(magoJogador, (magoAdversario.getAtaque() + magoAdversario.getAtaqueEspecial()));
                            System.out.println("Vida do Mago após o ataque especial: " + magoJogador.getVida());
                        }
                        trocarJogador = true;
                    } else if (contadorAtaqueEspecial > 3) {
                        System.out.println("Você já usou seus três ataques especiais!");
                        trocarJogador = false;
                    }
                    break;
                default:
                    System.out.println("Opção inválida!");
                    trocarJogador = false;
            }
            if (Tabuleiro.verificarTorreNaPosicao(posicaoAtacada)) {
                if (magoAdversario.getVida() <= 0) {
                    if (Tabuleiro.verificaCor(posicaoAtacada, j1)) {
                        System.out.println("O dono da torre venceu a batalha!");
                    } else {
                        System.out.println("Jogador " + j1.getNome() + " venceu a batalha!");
                        j1.vencerBatalha(tabuleiro, posicaoAtacada);
                    }
                    rodadaAcabou = true; // Define que a rodada acabou
                } else if (magoJogador.getVida() <= 0) {
                    if ((Tabuleiro.verificaCor(posicaoAtacada, j2))) {
                        System.out.println("O dono da torre venceu a batalha!");
                    } else {
                        System.out.println("Jogador " + j2.getNome() + " venceu a batalha!");
                        j2.vencerBatalha(tabuleiro, posicaoAtacada);
                    }
                    rodadaAcabou = true; // Define que a rodada acabou
                }
            }
            if (trocarJogador) {
                turno = (turno == 1) ? 2 : 1;
            }
        } while (!rodadaAcabou);
    }

    private static boolean verificarPontuacao(Jogador j1, Jogador j2) {
        boolean jogoAcabou = false;

        if (j1.getPontos() == 7) {
            System.out.println("O jogador " + j1.getNome() + " venceu o jogo!");
            jogoAcabou = true;
        } else if (j2.getPontos() == 7) {
            System.out.println("O jogador " + j2.getNome() + " venceu o jogo!");
            jogoAcabou = true;
        }
        return jogoAcabou;
    }

    public static void mostrarTabuleiro(Tabuleiro tabuleiro) {
        int posicao = 0;

        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 9; j++) {
                if (posicao < tabuleiro.getPosicoes().size()) {
                    Posicao posicaoAtual = tabuleiro.getPosicoes().get(posicao);
                    Unidade unidade = posicaoAtual.getUnidade();
                    String marcacao = posicaoAtual.getMarcacao();

                    if (unidade != null) {
                        System.out.print("|" + unidade + "| ");
                    } else if (marcacao != null) {
                        System.out.print("|" + marcacao + "| ");
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
    }
}