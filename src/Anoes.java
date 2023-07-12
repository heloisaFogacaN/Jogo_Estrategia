import java.util.ArrayList;

public class Anoes extends Unidade{
    public Anoes( int vida, int ataque, int defesa, int valorElixir) {
            super(3, 3, 5, 3);
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
        return "Anões";
    }
}
