import java.util.ArrayList;

public class Jogador {
    private String nome;
    private String senha;
    private int pontos;
    private String cor;
    private ArrayList<Unidade> unidades;

    private int elixir;

    public Jogador(String nome, String senha, String cor){
        this.nome=nome;
        this.senha=senha;
        this.cor=cor;
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

    public ArrayList<Unidade> getUnidade() {
        return unidades;
    }

    public void vencerBatalha(Tabuleiro tabuleiro, Posicao posicaoAtacada) {
        tabuleiro.marcarPosicao(posicaoAtacada, "x");
        this.pontos+=1;
    }

    public boolean moverPeca(Unidade unidade, Posicao posicao, Tabuleiro tabuleiro, Jogador adversario) {
        Unidade unidadeAdversaria = posicao.getUnidade();
        boolean valida=unidade.mover(tabuleiro, posicao);
        if(posicao.getUnidade() != null){
            adversario.unidades.remove(posicao.getUnidade());
        }
        return true;
    }
}