public class Posicao {
    public boolean getUnidade;
    private Unidade unidade;
    private Torre torre;

    public Unidade getUnidade() {return unidade;}

    public void setUnidade(Unidade unidade) {
        this.unidade = unidade;
    }

    @Override
    public String toString() {
        return "[" + unidade + "]";
    }
}