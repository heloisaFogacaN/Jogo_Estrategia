import java.util.ArrayList;

public class Jogador {
    private static ArrayList<Jogador> jogadores = new ArrayList<>();
    private String nome;
    private String senha;
    private int pontos = 0;
    private String cor;
    private Mago mago;

    public Jogador(String nome, String senha){
        this.nome=nome;
        this.senha=senha;

        jogadores.add(this);
    }

    public String getCor() {
        return cor;
    }

    public String getNome() {
        return nome;
    }

    public int getPontos() {
        return pontos;
    }

    public void setMago(Mago mago) {
        this.mago = mago;
    }

    public Mago getMago() {
        return mago;
    }

    public String getSenha() {
        return senha;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public void setPontos(int pontos) {
        this.pontos = pontos;
    }

    public void vencerBatalha(Unidade torre) {
        Tabuleiro.marcarPosicao(torre.getPosicao());
    }

    public static Jogador buscarJogadores(String senha, String nome) {
        for (Jogador jogador : jogadores) {
            if (senha.equals(jogador.senha) && nome.equals(jogador.nome)) {
                return jogador;
            }
        }
        return null;
    }


    public static ArrayList<Jogador> getJogadores() {
        return jogadores;
    }

    public void atacar(Mago adversario) {
        this.getMago().atacar(adversario);
    }

    @Override
    public String toString() {
        return "\nNome:" + nome +
                "\nSenha:" + senha;
    }
}