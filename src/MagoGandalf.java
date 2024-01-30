public class MagoGandalf extends Mago {
    private int poderFogo;
    private int poderRelampago;

    public MagoGandalf() {
        super(150);
        addPoder(new DanoPadrao(18));
        addPoder(new Fogo());
        addPoder(new Relampago());
    }

    @Override
    public String poderes() {
        return "2- Poder de Fogo\n" +
                "3- Poder Relâmpago";
    }

    @Override
    public int poder2() {
        return poderFogo;
    }

    @Override
    public int poder3() {
        return poderRelampago;
    }

    @Override
    public String toString() {
        return "Mago Branco";
    }
}
