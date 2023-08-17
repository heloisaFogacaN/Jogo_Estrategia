import java.util.ArrayList;

public class Jogador {
    static ArrayList<Jogador> jogadores = new ArrayList<>();
    private String nome;
    private String senha;
    private int pontos;
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

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public void vencerBatalha(Tabuleiro tabuleiro, Posicao posicaoAtacada) {
        tabuleiro.marcarPosicao(posicaoAtacada, " X ");
        this.pontos++;
    }

    public static Jogador buscarJogadores(String senha, String nome) {
        for (Jogador jogador : jogadores) {
            if (senha.equals(jogador.senha) && nome.equals(jogador.nome)) {
                return jogador;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "Nome=" + nome + "\n" +
                "Senha=" + senha;
    }
}