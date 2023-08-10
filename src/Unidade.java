import java.util.ArrayList;

public abstract class Unidade {
    private Posicao posicao;
    private int vida, ataque, defesa;
    private String cor;


    public Unidade(int vida, int ataque, int defesa, String cor) {
        this.ataque = ataque;
        this.vida = vida;
        this.defesa = defesa;
        this.cor=cor;
    }

    public String getCor() {
        return cor;
    }

}


