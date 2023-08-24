public abstract class Poder {
    private String elemento;
    private int dano;
    private int turnosDeCongelamento;

    public Poder(String elemento, int dano, int turnosDeCongelamento){
        this.elemento=elemento;
        this.dano=dano;
        this.turnosDeCongelamento=turnosDeCongelamento;
    }

    public int getDano() {
        return dano;
    }
}
