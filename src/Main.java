import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    static boolean jogoAcabou = false;
//    static Tabuleiro tabuleiro = new Tabuleiro();
    static Partida partida;
    public static void main(String[] args) {

        System.out.println("BEM-VINDO!");
        int menu = 0;
        do {
            menu = menu();
        } while (menu!= 4);
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
                iniciarPartida();
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

    private static void loginJogadores(){
        boolean comecar = false;
        Jogador j1;
        Jogador j2;
        do {
            System.out.println("Jogador 1");
            j1 = login();
            System.out.println("Jogador 2");
            j2 = login();
            if (j1.equals(j2)) {
                System.out.println("Para o jogo ocorrer deve haver dois jogadores diferentes");
            } else {
                comecar = true;
            }
        } while (!comecar);
    }

    private static void cadastar() {
        Jogador novoJogador = new Jogador();

        System.out.println("Informe seu nome:");
        novoJogador.setNome(scanner.next());
        System.out.println("Informe sua senha:");
        novoJogador.setSenha(scanner.next());
        boolean jogadorJaCadastrado = false;

        for (Jogador jogador : Jogador.getJogadores()) {
            if (novoJogador.getNome().equals(jogador.getNome()) && novoJogador.getSenha().equals(jogador.getSenha())) {
                System.out.println("Esse jogador já está cadastrado!");
                jogadorJaCadastrado = true;
                break;
            }
        }
        if (!jogadorJaCadastrado) {
            Jogador.adicionarJogador(novoJogador);
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
        partida.addJogador(jogador);
        return jogador;
    }

    private static void listarJogadores() {
        int i = 1;
        for (Jogador jogador : Jogador.jogadores) {
            System.out.println(i + "- " + jogador.toString() + "\n");
            i++;
        }
    }

    private static void iniciarPartida() {
        partida=new Partida();
        loginJogadores();
        do {
            System.out.println(partida.getTabuleiro());
            pedirBatalha();
            jogoAcabou = verificarPontuacao(j1, j2);
        } while (!jogoAcabou);
    }

    private static Posicao escolherPosicao(){
        Posicao posicao = null;
        do{
            System.out.println("\nInforme a posição da torre que deseja conquistar:");
            int escolhaPosicao = scanner.nextInt() - 1;
            ArrayList<Posicao> posicoes=partida.getTabuleiro().getPosicoes();
            if(escolhaPosicao>=0 && escolhaPosicao<posicoes.size()){
                posicao=posicoes.get(escolhaPosicao);
            }
        }while(posicao ==null);
        return posicao;
    }

    private static void pedirBatalha() {
        boolean continuar = false;
        Jogador j1=partida.getJogadores().get(0), j2=partida.getJogadores().get(1);
        System.out.println("Pontuação jogadores:\n"
                + j1.getNome() + ": " + j1.getPontos() + "\n"
                + j2.getNome() + ": " + j2.getPontos());
        do {

                System.out.println("\nJogador " + partida.jogadorDaVez());
            Posicao posicaoQueMove= escolherPosicao();


            Unidade unidadeAtacada = posicaoQueMove.getUnidade();
            if (unidadeAtacada != null) {

                    if (partida.verificaCor(unidadeAtacada)) {
                    continuar = true;
                    } else {
                    System.out.println("Escolha uma Torre que pertença ao adversário");
                    }
                }
                if (continuar) {
                    System.out.println("Jogador " + j1.getNome());
                    j1.setMago(escolherMago());
                    System.out.println("Jogador " + j2.getNome());
                    j2.setMago(escolherMago());
                    batalhar(j1.getMago(), j2.getMago(), posicaoQueMove, j1, j2, turno);
                    break;
                }
            } else {
                System.out.println("Escolha uma posição que contenha uma torre!");
            }
        } while (!continuar);
    }

    private static Mago escolherMago() {
        boolean opcaoValida = false;
        Mago tipoMago = null;
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

    private static void batalhar(Mago magoJogador, Mago magoAdversario, Posicao posicaoAtacada, Jogador j1, Jogador j2, int turno) {
        boolean rodadaAcabou = false;

        do {
            boolean trocarJogador = false;
            if (turno == 1) {
                System.out.println("\nJogador " + j1.getNome() + ", você deseja fazer qual jogada: ");
                magoJogador.atacar(magoAdversario, escolherAtaque(magoJogador));
                System.out.println("Vida do Mago do jogador " + j2.getNome() + " após o ataque: " + magoAdversario.getVida());
            } else if (turno == 2) {
                System.out.println("\nJogador " + j2.getNome() + ", você deseja fazer qual jogada: ");
                magoAdversario.atacar(magoJogador, escolherAtaque(magoAdversario));
                System.out.println("Vida do Mago do jogador " + j1.getNome() + " após o ataque: " + magoJogador.getVida());
            }
            trocarJogador = true;

            if (Tabuleiro.verificarTorreNaPosicao(posicaoAtacada)) {
                if (magoAdversario.getVida() <= 0) {
                    verificaVitoriaRodada(posicaoAtacada, j1);
                    rodadaAcabou = true; // Define que a rodada acabou
                } else if (magoJogador.getVida() <= 0) {
                    verificaVitoriaRodada(posicaoAtacada, j2);
                    rodadaAcabou = true; // Define que a rodada acabou
                }
            }
            if (trocarJogador) {
                turno = (turno == 1) ? 2 : 1;
            }
        } while (!rodadaAcabou);
    }

    private static int escolherAtaque(Mago magoJogador) {
        int opcao;
        System.out.println("1- Ataque\n" + magoJogador.poderes());

        opcao = scanner.nextInt();

        if (opcao == 2) {
            return magoJogador.poder2();
        } else if (opcao == 3) {
            return magoJogador.poder3();
        }
        return magoJogador.getAtaque();
    }

    private static void verificaVitoriaRodada(Posicao posicaoAtacada, Jogador jogador) {
        Tabuleiro.verificaCor(posicaoAtacada, jogador);
        if ((Tabuleiro.verificaCor(posicaoAtacada, jogador))) {
            System.out.println("O dono da torre venceu a batalha!");
        } else {
            System.out.println("Jogador " + jogador.getNome() + " venceu a batalha!");
            jogador.vencerBatalha(tabuleiro, posicaoAtacada);
            jogador.setPontos(jogador.getPontos() + 1);
        }
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
}