import java.util.ArrayList;

public abstract class Mago {
    private int vida, ataque;
    private boolean escudoAtivo;
    private ArrayList<Poder> poderes;


    public Mago(int vida, int ataque) {
        this.vida=vida;
        this.ataque=ataque;
    }

    public void addPoder(Poder poder){
        poderes.add(poder);
    }

    public abstract String poderes();

    public abstract int poder2();

    public abstract int poder3();

    public void receberAtaque(Poder poder) {
            this.setVida(this.getVida() - poder.getDano());
    }

    public void atacar(Mago adversario, int ataque) {
        if (ataque == 2) {
             this.poder2();
        } else if (ataque == 3) {
             this.poder3();
        }
        return magoJogador.getAtaque();
        adversario.receberAtaque(poder);
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
