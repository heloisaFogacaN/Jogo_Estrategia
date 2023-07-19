import java.util.ArrayList;

public class Elfos extends Unidade {
    public Elfos( int vida, int ataque, int defesa) {

        super(3, 5, 3);
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
        return "Elfos";
    }
}
