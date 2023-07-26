public class Posicao {
    public String marcacao;
    private Unidade unidade;

    public Unidade getUnidade() {return unidade;}

    public void setUnidade(Unidade unidade) {
        this.unidade = unidade;
    }

    public void setMarcacao(String marcacao) {
        this.marcacao = marcacao;
    }


    @Override
    public String toString() {
        return "[" + unidade + "]";
    }
}