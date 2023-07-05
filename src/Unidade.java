import java.util.ArrayList;

public abstract class Unidade {
    private String cor;
    private Posicao posicao;
    private int vida;
    private int ataque;
    private int defesa;
    private int valorElixir;


    public Unidade(String cor, int vida, int ataque, int defesa, int valorElixir) {
        this.cor = cor;
        this.ataque = ataque;
        this.vida = vida;
        this.defesa = defesa;
        this.valorElixir = valorElixir;
    }

    public boolean verificaPeca(Posicao posicao, ArrayList<Posicao> possiveisMovimentos) {
        if (posicao.getUnidade() == null) {
            possiveisMovimentos.add(posicao);
            return false;

        }
        return true;
    }
    public String getCor() {
        return cor;
    }
}


