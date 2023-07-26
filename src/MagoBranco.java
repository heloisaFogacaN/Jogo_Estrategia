public class MagoBranco extends Magos {
    public MagoBranco(int vida, int ataque) {
        super(vida, ataque);
    }
    @Override
    public void ataqueEspecial() {
        setAtaque(80);

    }

    @Override
    public int calcularAtaque() {
        return 0;
    }
}
