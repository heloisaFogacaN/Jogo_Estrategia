import java.util.ArrayList;

public class Elfos extends Unidade {
    public Elfos( int vida, int ataque, int defesa, int valorElixir) {
        super(vida, ataque, defesa, valorElixir);
    }

    @Override
    public ArrayList<Posicao> possiveisMovimento(Tabuleiro tabuleiro) {
        return null;
    }

}
