import java.util.ArrayList;

public class Hobbits extends Unidade{

    public Hobbits(int vida, int ataque, int defesa, int valorElixir) {
        super(vida, ataque, defesa, valorElixir);
    }

    @Override
    public ArrayList<Posicao> possiveisMovimento(Tabuleiro tabuleiro) {
        return null;
    }
}
