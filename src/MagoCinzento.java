public class MagoCinzento extends Magos{
    public MagoCinzento(int vida, int ataque) {
        super(vida, ataque);
    }

    @Override
    public void ataqueEspecial() {
        setAtaque(70);

    }

    @Override
    public int calcularAtaque() {
        return 0;
    }


}
