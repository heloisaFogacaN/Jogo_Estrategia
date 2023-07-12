import java.util.ArrayList;

public class Torre extends Unidade{

    public Torre(int vida, int ataque, int defesa, int valorElixir) {
        super(20, ataque, defesa, valorElixir);
    }


    @Override
    public ArrayList<Posicao> possiveisMovimento(Tabuleiro tabuleiro) {
        Posicao posicaoAtual = this.getPosicao();
        int posicaoNoTabuleiro = tabuleiro.getPosicoes().indexOf(posicaoAtual);
        ArrayList<Posicao> possiveisMovimentos = new ArrayList<>();

        return null;
    }
}
