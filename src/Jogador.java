import java.util.ArrayList;

public class Jogador {
    private String nome;
    private String senha;
    private String pontos;
    private ArrayList<Unidade> unidades;

    private int elixir;

    public Jogador(String nome, String senha){
        this.nome=nome;
        this.senha=senha;
    }


    public String getNome() {
        return nome;
    }

    public String getSenha() {
        return senha;
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