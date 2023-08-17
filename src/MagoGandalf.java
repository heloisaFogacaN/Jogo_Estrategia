public class MagoGandalf extends Magos {
    private int poderFogo;
    private int poderRelampago;

    public MagoGandalf() {
        super(150, 18);
        this.poderFogo = 25;
        this.poderRelampago = 30;
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
