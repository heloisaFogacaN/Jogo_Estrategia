public class MagoCinzento extends Magos{
    public MagoCinzento(int vida, int ataque, int defesa) {
        super(560, 40);
    }

    @Override
    public void ataqueEspecial() {
        setAtaque(70);

    }


}
