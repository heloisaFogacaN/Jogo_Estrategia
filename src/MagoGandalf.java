public class MagoGandalf extends Mago {
    private int poderFogo;
    private int poderRelampago;

    public MagoGandalf() {
        super(150, 18);
        this.poderFogo = 25;
        this.poderRelampago = 30;
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
