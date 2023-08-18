public class MagoSaruman extends Magos {
    private int poderGelo;
    private int poderMente;

    public MagoSaruman() {
        super(140, 20);
        this.poderGelo = 30;
        this.poderMente = 25;
    }

    @Override
    public int poder2() {
        return poderGelo;
    }

    @Override
    public int poder3() {
        return poderMente;
    }

    @Override
    public String toString() {
        return "Mago Cinzento";
    }
}



