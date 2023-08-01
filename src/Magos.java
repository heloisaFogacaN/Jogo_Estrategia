import java.util.ArrayList;

public abstract class Magos {
    private int vida, ataque, ataqueEspecial;
    private boolean escudoAtivo;
    private Jogador jogador;


    public Magos(Jogador jogador, int vida, int ataque, int defesa, int ataqueEspecial) {
        this.vida=vida;
        this.ataque=ataque;
        this.jogador = jogador;
        this.ataqueEspecial = ataqueEspecial;
    }



    public int getAtaqueEspecial() {
        return ataqueEspecial;
    }

    public Magos(int vida, int ataque) {
    }

    public Jogador getJogador() {
        return jogador;
    }



    public void receberAtaque(int ataqueOponente) {
        int dano = ataqueOponente - this.getAtaque();
        if (dano > 0) {
            this.setVida(this.getVida() - dano);
        }
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public int getVida() {
        return vida;
    }

    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }

    public int getAtaque() {
        return ataque;
    }
}
