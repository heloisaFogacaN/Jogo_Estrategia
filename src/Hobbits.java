import java.util.ArrayList;

public class Hobbits extends Unidade{

    public Hobbits(int vida, int ataque, int defesa, int valorElixir) {
        super(3, 2, 2, 2);
    }

    @Override
    public ArrayList<Posicao> possiveisMovimento(Tabuleiro tabuleiro) {
        Posicao posicaoAtual = this.getPosicao();
        int posicaoNoTabuleiro = tabuleiro.getPosicoes().indexOf(posicaoAtual);
        ArrayList<Posicao> possiveisMovimentos = new ArrayList<>();

        return possiveisMovimentos;
    }

    @Override
    public String toString() {
        return "Hobbits";
    }
}
