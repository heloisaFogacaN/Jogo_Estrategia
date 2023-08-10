import java.util.ArrayList;

public class Jogador {
    private String nome;
    private String senha;
    private int pontos;
    private String cor;
    private Magos mago;


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

    public void setMago(Magos mago) {
        this.mago = mago;
    }

    public Magos getMago() {
        return mago;
    }

    public void vencerBatalha(Tabuleiro tabuleiro, Posicao posicaoAtacada) {
        tabuleiro.marcarPosicao(posicaoAtacada, " X ");
        this.pontos+=1;
    }


}