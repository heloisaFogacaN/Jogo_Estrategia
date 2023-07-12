import java.util.ArrayList;

public class Elfos extends Unidade {
    public Elfos( int vida, int ataque, int defesa, int valorElixir) {

        super(3, 5, 3, 5);
    }

    @Override
    public ArrayList<Posicao> possiveisMovimento(Tabuleiro tabuleiro) {
        return null;
    }

}
