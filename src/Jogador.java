import java.util.ArrayList;

public class Jogador {
    static ArrayList<Jogador> jogadores = new ArrayList<>();
    private String nome;
    private String senha;
    private int pontos = 0;
    private String cor;
    private Magos mago;

    public String getCor() {
        return cor;
    }

    public String getNome() {
        return nome;
    }

    public int getPontos() {
        return pontos;
    }

    public void setMago(Magos mago) {
        this.mago = mago;
    }

    public Magos getMago() {
        return mago;
    }

    public String getSenha() {return senha;}

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public void setPontos(int pontos) {
        this.pontos = pontos;
    }

    public void vencerBatalha(Tabuleiro tabuleiroJogo, Posicao posicaoAtacada) {
        tabuleiroJogo.marcarPosicao(posicaoAtacada, " X ");
    }

    public static Jogador buscarJogadores(String senha, String nome) {
        for (Jogador jogador : jogadores) {
            if (senha.equals(jogador.senha) && nome.equals(jogador.nome)) {
                return jogador;
            }
        }
        return null;
    }
    public static void adicionarJogador() {
        Jogador primeiro = new Jogador();
        primeiro.setNome("Primeiro");
        primeiro.setSenha("Primeiro");

        Jogador.jogadores.add(primeiro);
    }

    @Override
    public String toString() {
        return "\nNome:" + nome + "\n" +
                "Senha:" + senha;
    }
}