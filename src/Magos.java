import java.util.ArrayList;

public abstract class Magos {
    private int vida, ataque, rodadasEscudoAtivo;
    private boolean escudoAtivo;
    public Magos(int vida, int ataque) {
        this.vida=vida;
        this.ataque=ataque;
    }

    public abstract void ataqueEspecial();


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
