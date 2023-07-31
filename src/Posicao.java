public class Posicao {
    public String marcacao;
    private Unidade unidade;
    private int numero;


    public Unidade getUnidade() {return unidade;}

    public void setUnidade(Unidade unidade) {
        this.unidade = unidade;
    }

    public void setMarcacao(String marcacao) {
        this.marcacao = marcacao;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    @Override
    public String toString() {
        return "[" + unidade + "]";
    }
}