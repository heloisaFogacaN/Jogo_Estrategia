public abstract class Magos {
    private int vida, ataque, ataqueEspecial;
    private boolean escudoAtivo;
    private String nome;


    public Magos( int vida, int ataque) {
        this.vida=vida;
        this.ataque=ataque;
    }

    public void AtaqueEspecial(String nome, int ataque) {
        this.nome = nome;
        this.ataque = ataque;
    }

    public abstract int poder2();

    public abstract int poder3();

    public int getAtaqueEspecial() {
        return ataqueEspecial;
    }

    public void receberAtaque(int ataqueOponente) {
            this.setVida(this.getVida() - ataqueOponente);
    }
    public static void atacar(Magos adversario, int ataque) {
        adversario.receberAtaque(ataque);
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public int getVida() {
        return vida;
    }

    public int getAtaque() {
        return ataque;
    }

    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }
}
