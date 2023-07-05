public class Posicao {
    public boolean getUnidade;
    private Unidade unidade;

    public Unidade getUnidade() {return unidade;}

    public void setPeca(Unidade peca) {
        this.unidade = peca;
    }

    @Override
    public String toString() {
        return "Posicao{" +
                "getPeca=" + getUnidade +
                ", peca=" + unidade;
    }
}