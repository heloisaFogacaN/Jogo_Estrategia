import java.util.ArrayList;

public abstract class Magos {
    private int vida, ataque, rodadasEscudoAtivo;
    private boolean escudoAtivo;
    public Magos(int vida, int ataque) {
        this.vida=vida;
        this.ataque=ataque;
    }

    public abstract void ataqueEspecial();

    public abstract int calcularAtaque();

    public void receberAtaque(int dano) {
        this.vida -= dano;

        if (this.vida < 0) {
            this.vida = 0;
        }

        System.out.println("O mago recebeu um ataque e perdeu " + dano + " pontos de vida!");
        System.out.println("Vida restante: " + this.vida);
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
