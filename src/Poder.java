public abstract class Poder {
    private String elemento;
    private int dano;

    public Poder(String elemento, int dano){
        this.elemento=elemento;
        this.dano=dano;
    }

    public int getDano() {
        return dano;
    }
}
