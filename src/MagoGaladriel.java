public class MagoGaladriel extends Mago {
    private int poderLuz;
    private int poderTelepatia;

    public MagoGaladriel() {
        super(130);
        addPoder(new DanoPadrao(15));
        addPoder(new Luz());
        addPoder(new Telepatia());
    }

    @Override
    public String poderes() {
        return "2- Poder da Luz\n" +
                "3- Poder da Telepatia";
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