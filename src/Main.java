import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    static boolean jogoAcabou = false;
    static int escolhaAtaque = 0;

    public static void main(String[] args) {
        Jogador.adicionarJogador();
        System.out.println("BEM-VINDO!");
        int menu = 0;
        do {
            menu();
        } while (!(menu == 4));
    }

    private static int menu() {
        System.out.println("""
                                
                Selecione a opção que deseja:
                                
                1- Cadastrar jogador
                2- Iniciar Jogada
                3- Listar jogadores
                4- Encerrar
                """);
        int opcao = scanner.nextInt();

        switch (opcao) {
            case 1:
                cadastar();
                break;
            case 2:
                boolean comecar = false;
                Jogador j1 = null;
                Jogador j2 = null;
                do {
                    System.out.println("Jogador 1");
                    j1 = login();
                    System.out.println("Jogador 2");
                    j2 = login();
                    if (j1.getNome().equals(j2.getNome()) && j1.getSenha().equals(j2.getSenha())) {
                        System.out.println("Para o jogo ocorrer deve haver dois jogadores diferentes");
                    } else {
                        comecar = true;
                    }
                } while (!comecar);
                Tabuleiro tabuleiro = new Tabuleiro();
                iniciarPartida(tabuleiro,j1, j2);
                break;
            case 3:
                listarJogadores();
                break;
            case 4:
                System.exit(0);
                break;
            default:
                System.out.println("Opção inválida!");
        }
        return opcao;
    }

    private static void cadastar() {
        Jogador novoJogador = new Jogador();

        System.out.println("Informe seu nome:");
        novoJogador.setNome(scanner.next());
        System.out.println("Informe sua senha:");
        novoJogador.setSenha(scanner.next());
        boolean jogadorJaCadastrado = false;

        for (Jogador jogador : Jogador.jogadores) {
            if (novoJogador.getNome().equals(jogador.getNome()) && novoJogador.getSenha().equals(jogador.getSenha())) {
                System.out.println("Esse jogador já está cadastrado!");
                jogadorJaCadastrado = true;
                break;
            }
        }
        if (!jogadorJaCadastrado) {
            Jogador.jogadores.add(novoJogador);
        }
    }

    private static Jogador login() {
        Jogador jogador;
        do {
            System.out.println("Informe seu nome:");
            String nome = scanner.next();
            System.out.println("Informe sua senha:");
            String senha = scanner.next();
            jogador = Jogador.buscarJogadores(senha, nome);
            if (jogador == null) {
                System.out.println("Conta inválida!!");
            }
        } while (jogador == null);

        return jogador;
    }

    private static void iniciarPartida(Tabuleiro tabuleiro, Jogador j1, Jogador j2) {
        j1.setCor("Branco");
        j2.setCor("Preto");
        int turno = 1;
        do {
            mostrarTabuleiro(tabuleiro);
            pedirBatalha(tabuleiro, j1, j2, turno);
            turno = (turno == 1) ? 2 : 1;
            jogoAcabou = verificarPontuacao(j1, j2);
        } while (!jogoAcabou);
    }

    private static void listarJogadores() {
        int i = 1;
        for (Jogador jogador : Jogador.jogadores) {
            System.out.println(i + "- " + jogador.toString() + "\n");
            i++;
        }
    }

    private static void pedirBatalha(Tabuleiro tabuleiro, Jogador j1, Jogador j2, int turno) {
        boolean continuar = false;

        System.out.println("Pontuação jogadores:\n"
                + j1.getNome() + ": " + j1.getPontos() + "\n"
                + j2.getNome() + ": " + j2.getPontos());
        do {
            if (turno == 1) {
                System.out.println("\nJogador " + j1.getNome());
            } else if (turno == 2) {
                System.out.println("\nJogador " + j2.getNome());
            }
            System.out.println("\nInforme a posição da torre que deseja conquistar:");
            int escolhaPosicao = scanner.nextInt() - 1;
            Posicao posicaoQueMove = null;
            for (Posicao posicao : tabuleiro.getPosicoes()) {
                if (posicao.getNumero() == escolhaPosicao) {
                    posicaoQueMove = posicao;
                }
            }

            Unidade unidadeAtacada = posicaoQueMove.getUnidade();
            if (unidadeAtacada != null) {
                if (turno == 1) {
                    if ((Tabuleiro.verificaCor(posicaoQueMove, j1))) {
                        System.out.println("Escolha uma Torre que pertença ao adversário");
                    } else {
                        continuar = true;
                    }
                } else {
                    if ((Tabuleiro.verificaCor(posicaoQueMove, j2))) {
                        System.out.println("Escolha uma Torre que pertença ao adversário");
                    } else {
                        continuar = true;
                    }
                }
                if (continuar) {
                    System.out.println("Jogador " + j1.getNome());
                    j1.setMago(escolherMago());
                    System.out.println("Jogador " + j2.getNome());
                    j2.setMago(escolherMago());
                    batalhar(tabuleiro, j1.getMago(), j2.getMago(), posicaoQueMove, j1, j2, turno);
                    break;

                }
            } else {
                System.out.println("Escolha uma posição que contenha uma torre!");
            }

        } while (!continuar);
    }

    private static Magos escolherMago() {
        boolean opcaoValida = false;
        Magos tipoMago = null;
        do {
            System.out.println("""
                    Você deseja utilizar qual mago?
                    1- Mago Gandalf
                    2- Mago Saruman
                    3- Mago Galadriel
                    """);
            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    tipoMago = new MagoGandalf();
                    opcaoValida = true;
                    break;
                case 2:
                    tipoMago = new MagoSaruman();
                    opcaoValida = true;
                    break;
                case 3:
                    tipoMago = new MagoGaladriel();
                    opcaoValida = true;
                    break;
                default:
                    System.out.println("Opção inválida. Escolha novamente.");
            }
        } while (!opcaoValida);

        return tipoMago;
    }

    public static void batalhar(Tabuleiro tabuleiro,Magos magoJogador, Magos magoAdversario, Posicao posicaoAtacada, Jogador j1, Jogador j2, int turno) {
        boolean rodadaAcabou = false;

        do {
            boolean trocarJogador = false;
            if (turno == 1) {
                System.out.println("\nJogador " + j1.getNome() + ", você deseja fazer qual jogada: ");
            } else if (turno == 2) {
                System.out.println("\nJogador " + j2.getNome() + ", você deseja fazer qual jogada: ");
            }

            int escolha = 0;

            if (turno == 1) {
                escolha = escolherAtaque(magoJogador);
            } else {
                escolha = escolherAtaque(magoAdversario);
            }

            if (turno == 1) {
                switch (escolhaAtaque) {
                    case 1:
                        Magos.atacar(magoAdversario, magoJogador.getAtaque());
                        break;
                    case 2:
                        Magos.atacar(magoAdversario, magoJogador.poder2());
                        break;
                    case 3:
                        Magos.atacar(magoAdversario, magoJogador.poder3());
                        break;
                    default:
                        System.out.println("Opção inválida!");
                        Magos.atacar(magoAdversario, 0);
                }
                System.out.println("Vida do Mago do jogador " + j2.getNome() + " após o ataque: " + magoAdversario.getVida());
            } else {
                switch (escolhaAtaque) {
                    case 1:
                        Magos.atacar(magoJogador, magoAdversario.getAtaque());
                        break;
                    case 2:
                        Magos.atacar(magoJogador, magoAdversario.poder2());
                        break;
                    case 3:
                        Magos.atacar(magoJogador, magoAdversario.poder3());
                        break;
                }
                System.out.println("Vida do Mago do jogador " + j1.getNome() + " após o ataque: " + magoJogador.getVida());
            }
            trocarJogador = true;

            if (Tabuleiro.verificarTorreNaPosicao(posicaoAtacada)) {
                if (magoAdversario.getVida() <= 0) {
                    Tabuleiro.verificaCor(posicaoAtacada, j1);
                    if ((Tabuleiro.verificaCor(posicaoAtacada, j1))) {
                        System.out.println("O dono da torre venceu a batalha!");
                    } else {
                        System.out.println("Jogador " + j1.getNome() + " venceu a batalha!");
                        j1.vencerBatalha(tabuleiro, posicaoAtacada);
                        j1.setPontos(j1.getPontos() + 1);
                    }
                    rodadaAcabou = true; // Define que a rodada acabou
                } else if (magoJogador.getVida() <= 0) {
                    if ((Tabuleiro.verificaCor(posicaoAtacada, j2))) {
                        System.out.println("O dono da torre venceu a batalha!");
                    } else {
                        System.out.println("Jogador " + j2.getNome() + " venceu a batalha!");
                        j2.vencerBatalha(tabuleiro, posicaoAtacada);
                        j2.setPontos(j2.getPontos() + 1);
                    }
                    rodadaAcabou = true; // Define que a rodada acabou
                }
            }
            if (trocarJogador) {
                turno = (turno == 1) ? 2 : 1;
            }
        } while (!rodadaAcabou);
    }

    private static int escolherAtaque(Magos magoJogador) {
        int opcao;
        System.out.println("1- Ataque");
        if (magoJogador instanceof MagoGandalf) {
            System.out.printf("""
                    2- Poder de Fogo
                    3- Poder Relâmpago
                    """);
        } else if (magoJogador instanceof MagoSaruman) {
            System.out.printf("""
                    2- Poder de Gelo
                    3- Poder Mente
                    """);
        } else if (magoJogador instanceof MagoGaladriel) {
            System.out.printf("""
                    2- Poder da Luz
                    3- Poder da Telepatia
                    """);
        }
        opcao = scanner.nextInt();
        escolhaAtaque = opcao;

        if (opcao == 2) {
            return magoJogador.poder2();
        } else if (opcao == 3) {
            return magoJogador.poder3();
        }
        return magoJogador.getAtaque();
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
                        System.out.print("|" + unidade + "|");
                    } else if (marcacao != null) {
                        System.out.print("|" + marcacao + "|");
                    } else {
                        System.out.print("|   |");
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