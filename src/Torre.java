import java.util.ArrayList;

public class Torre extends Unidade{


    public Torre(int vida, int ataque, int defesa, int valorElixir) {
        super(vida, ataque, defesa, valorElixir);
    }

    @Override
    public ArrayList<Posicao> possiveisMovimento(Tabuleiro tabuleiro) {
        return null;
    }

    @Override
    public String toString() {
        return "Torre";
    }
}
