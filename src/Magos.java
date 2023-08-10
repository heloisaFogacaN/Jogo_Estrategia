import java.util.ArrayList;

public abstract class Magos {
    private int vida, ataque, ataqueEspecial;
    private boolean escudoAtivo;


    public Magos( int vida, int ataque) {
        this.vida=vida;
        this.ataque=ataque;
    }

    public int getAtaqueEspecial() {
        return ataqueEspecial;
    }


    public void receberAtaque(int ataqueOponente) {
            this.setVida(this.getVida() - ataqueOponente);
    }
    public static void atacar(Magos adversario, int ataque) {
        adversario.receberAtaque(ataque);
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public int getVida() {
        return vida;
    }

    public int getAtaque() {
        return ataque;
    }
}
