import java.util.ArrayList;

public class Magos extends Unidade {
    public Magos(int vida, int ataque, int defesa) {
        super(vida, ataque, defesa);
    }

    @Override
    public ArrayList<Posicao> possiveisMovimento(Tabuleiro tabuleiro) { return null;
    }
}
