public class MagoNegro extends Magos{
    public MagoNegro(int vida, int ataque, int defesa) {
        super(550, 50);
    }

    @Override
    public void ataqueEspecial() {
        setAtaque(60);
    }
}
