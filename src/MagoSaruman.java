public class MagoSaruman extends Mago {
    private int poderGelo;
    private int poderMente;

    public MagoSaruman() {
        super(140);
        addPoder(new DanoPadrao(20));
        addPoder(new Gelo());
        addPoder(new Gelo());
    }

    @Override
    public String poderes() {
        return "2- Poder de Gelo\n" +
                "3- Poder Mente";
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



