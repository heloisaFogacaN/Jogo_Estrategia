import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    static boolean jogoAcabou = false;
    //    static Tabuleiro tabuleiro = new Tabuleiro();
    static Partida partida = new Partida(null, null);

    public static void main(String[] args) {

        System.out.println("BEM-VINDO!");
        int menu = 0;
        do {
            menu = menu();
        } while (menu != 4);
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

    private static void loginJogadores() {
        Jogador j1;
        Jogador j2;
        do {
            System.out.println("Jogador 1");
            j1 = login();
            System.out.println("Jogador 2");
            j2 = login();
            if (j1.equals(j2)) {
                System.out.println("Para o jogo ocorrer deve haver dois jogadores diferentes");
            }
        } while (j1==j2);
        partida = new Partida(j1, j2);
    }

    private static void cadastar() {
        System.out.println("Informe seu nome:");
        String nome=(scanner.next());
        System.out.println("Informe sua senha:");
        String senha=(scanner.next());

        Jogador jogador=Jogador.buscarJogadores(senha, nome);
        boolean jogadorJaCadastrado = jogador!=null;

        if (!jogadorJaCadastrado) {
            new Jogador(nome, senha);
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

    private static void listarJogadores() {
        int i = 1;
        for (Jogador jogador : Jogador.getJogadores()) {
            if(jogador==null){
                System.out.println("Não há jogadores cadastrados!");
            } else {
                System.out.println(i + "- " + jogador.toString() + "\n");
                i++;
            }
        }
    }

    private static void iniciarPartida() {
        loginJogadores();
        do {
            System.out.println(partida.getTabuleiro());
            pedirBatalha();
            jogoAcabou = verificarVitoriaPartida();
        } while (!jogoAcabou);
    }

    private static Unidade escolherUnidade() {
        Posicao posicao = null;
        do {
            System.out.println("\nInforme a posição da torre que deseja conquistar:");
            int escolhaPosicao = scanner.nextInt() - 1;
            ArrayList<Posicao> posicoes = partida.getTabuleiro().getPosicoes();
            if (escolhaPosicao >= 0 && escolhaPosicao < posicoes.size()) {
                posicao = posicoes.get(escolhaPosicao);
            }
        } while (posicao == null || posicao.getUnidade() == null || !partida.verificaCor(posicao.getUnidade()));
        return posicao.getUnidade();
    }

    private static void pedirBatalha() {
        do {
            Jogador j1 = partida.jogadorRodada(), j2 = partida.adversarioRodada();
            System.out.println("Pontuação jogadores:\n"
                    + j1.getNome() + ": " + j1.getPontos() + "\n"
                    + j2.getNome() + ": " + j2.getPontos());

            System.out.println("\nJogador " + j1.getNome());
            Unidade unidadeAtacada = escolherUnidade();

            System.out.println("Jogador " + j1.getNome());
            j1.setMago(escolherMago(j1));
            System.out.println("Jogador " + j2.getNome());
            j2.setMago(escolherMago(j2));

            batalhar(unidadeAtacada);

            partida.trocarRodada();
        } while (!verificarVitoriaPartida());
    }

    private static Mago escolherMago(Jogador jogador) {
        int opcao;
        Mago mago = null;
        do {
            System.out.println("""
                    Você deseja utilizar qual mago?
                    1- Mago Gandalf
                    2- Mago Saruman
                    3- Mago Galadriel
                    """);
            opcao = scanner.nextInt();
            switch (opcao) {
                case 1:
                    mago = new MagoGandalf();
                    break;
                case 2:
                    mago = new MagoSaruman();
                    break;
                case 3:
                    mago = new MagoGaladriel();
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao > 3 || opcao < 1);
        return mago;
    }

    private static void batalhar(Unidade torre) {
        do {
            Jogador j1 = partida.jogadorTurno(), j2 = partida.adversarioTurno();

            System.out.println("\nJogador " + j1.getNome() + ", você deseja fazer qual jogada: ");
            escolherAtaque(j1.getMago());
            j1.atacar(j2.getMago());
            System.out.println("Vida do Mago do jogador " + j2.getNome() + " após o ataque: " + j2.getMago().getVida());

            partida.trocarTurno();
        } while (!verificaVitoriaRodada(torre));
    }

    private static void escolherAtaque(Mago magoJogador) {
        int opcao;
        System.out.println("1- Ataque\n" + magoJogador.poderes());

        opcao = scanner.nextInt();

        magoJogador.setPoderSelecionado(opcao - 1);
    }

    private static boolean verificaVitoriaRodada(Unidade torre) {
        Jogador j1 = partida.jogadorTurno(), j2 = partida.adversarioTurno();
        if (j1.getMago().getVida() <= 0) {
            System.out.println("O dono da torre venceu a batalha!");
            return true;
        } else if (j2.getMago().getVida() <= 0) {
            System.out.println("Jogador " + j1.getNome() + " venceu a batalha!");
            j1.vencerBatalha(torre);
            j1.setPontos(j1.getPontos() + 1);
            return true;
        }
        return false;
    }

    private static boolean verificarVitoriaPartida() {
        for (Jogador jogador : partida.getJogadores()) {
            if (jogador.getPontos() == 7) {
                System.out.println("O jogador " + jogador.getNome() + " venceu o jogo!");
                return true;
            }
        }
        return false;
    }
}