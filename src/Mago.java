import java.util.ArrayList;

public abstract class Mago {
    private int vida;
    private boolean escudoAtivo;
    private ArrayList<Poder> poderes;
    private Poder poderSelecionado;

    public void setPoderSelecionado(int poderSelecionado) {
        this.poderSelecionado = poderes.get(poderSelecionado);
    }


    public Mago(int vida) {
        this.vida=vida;
    }

    public void addPoder(Poder poder){
        poderes.add(poder);
    }

    public ArrayList<Poder> getPoderes() {
        return poderes;
    }

    public void setPoderes(ArrayList<Poder> poderes) {
        this.poderes = poderes;
    }

    public Poder getPoder(int opcao){return poderes.get(opcao);}

    public abstract String poderes();

    public abstract int poder2();

    public abstract int poder3();

    public void receberAtaque(Poder poder) {
            this.setVida(this.getVida() - poder.getDano());
    }

    public void atacar(Mago adversario) {

        adversario.receberAtaque(poderSelecionado);
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public int getVida() {
        return vida;
    }

}
