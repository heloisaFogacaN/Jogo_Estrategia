import java.util.ArrayList;

public class Torre extends Unidade{
    String cor;

    public Torre(int vida, int ataque, int defesa, String cor) {
        super(vida, ataque, defesa);
        this.cor=cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
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
