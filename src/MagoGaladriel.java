public class MagoGaladriel extends Magos{
    private int poderLuz;
    private int poderTelepatia;

    public MagoGaladriel() {
        super(130, 25);
        this.poderLuz = 35;
        this.poderTelepatia = 15;
    }

    @Override
    public int poder2() {
        return poderLuz;
    }

    @Override
    public int poder3() {
        return poderTelepatia;
    }


    @Override
    public String toString() {
        return "Mago Negro";
    }
}