import java.util.ArrayList;

public abstract class Magos {
    private int vida, ataque, rodadasEscudoAtivo;
    private boolean escudoAtivo;
    public Magos(int vida, int ataque) {
        this.vida=vida;
        this.ataque=ataque;
    }

    public abstract void ataqueEspecial();


    public int getAtaqueEspecial() {
        return vida;
    }

    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }

    public int getAtaque() {
        return ataque;
    }
}
