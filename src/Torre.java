import java.util.ArrayList;

public class Torre extends Unidade{
    private String cor;

    public Torre(int vida, int ataque, int defesa, String cor) {
        super(vida, ataque, defesa, cor);
        this.cor=cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getCor() {
        return cor;
    }



    @Override
    public String toString() {
        return " T ";
    }
}
