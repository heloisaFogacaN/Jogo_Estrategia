import java.util.ArrayList;

public abstract class Unidade {
    private Posicao posicao;
    private int vida;
    private int ataque;
    private int defesa;
    private int valorElixir;


    public Unidade(int vida, int ataque, int defesa, int valorElixir) {
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

    public Posicao getPosicao() {
        return posicao;
    }

    public int getDefesa() {
        return defesa;
    }

    public int getValorElixir() {
        return valorElixir;
    }

    public int getAtaque() {
        return ataque;
    }

    public int getVida() {
        return vida;
    }
}


