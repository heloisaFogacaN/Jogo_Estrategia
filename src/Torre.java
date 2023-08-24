import java.util.ArrayList;

public class Torre extends Unidade{
    private String cor;

    public Torre(int vida, int ataque, int defesa, String cor, Posicao posicao) {
        super(vida, ataque, defesa, cor, posicao);
        this.cor=cor;
    }

    public String getCor() {
        return cor;
    }

    @Override
    public String toString() {
        return " T ";
    }
}
