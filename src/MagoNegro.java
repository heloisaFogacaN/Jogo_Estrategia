public class MagoNegro extends Magos{
    public MagoNegro(int vida, int ataque) {
        super(vida, ataque);
    }

    @Override
    public void ataqueEspecial() {
        setAtaque(60);
    }
}