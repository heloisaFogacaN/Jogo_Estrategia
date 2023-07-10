public class Posicao {
    public boolean getUnidade;
    private Unidade unidade;
    private Torre torre;

    public Unidade getUnidade() {return unidade;}

    public void setUnidade(Unidade unidade) {
        this.unidade = unidade;
    }

    public void setTorre(Torre torre) {
        this.torre = torre;
    }

    public Torre getTorre() {
        return torre;
    }

    @Override
    public String toString() {
        return "Posicao{" +
                "getPeca=" + getUnidade +
                ", peca=" + unidade;
    }
}