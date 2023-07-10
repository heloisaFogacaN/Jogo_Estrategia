public class Posicao {
    public boolean getUnidade;
    private Unidade unidade;

    public Unidade getUnidade() {return unidade;}

    public void setUnidade(Torre unidade) {
        this.unidade = unidade;
    }

    @Override
    public String toString() {
        return "Posicao{" +
                "getPeca=" + getUnidade +
                ", peca=" + unidade;
    }
}