import java.util.ArrayList;

public abstract class Unidade {
    private Posicao posicao;
    private int vida, ataque, defesa;


    public Unidade(int vida, int ataque, int defesa) {
        this.ataque = ataque;
        this.vida = vida;
        this.defesa = defesa;
    }

    public boolean verificaPeca(Posicao posicao, ArrayList<Posicao> possiveisMovimentos) {
        if (posicao.getUnidade() == null) {
            possiveisMovimentos.add(posicao);
            return false;

        }
        return true;
    }
    public boolean mover(Tabuleiro tabuleiro, Posicao posicao) {
        ArrayList<Posicao> possiveisPosicoes = possiveisMovimento(tabuleiro);
        for (Posicao posicaoPossivel : possiveisPosicoes) {
            if (posicaoPossivel == posicao) {
                //atribuindo a peça para nova posição no tabuleiro
                posicao.setUnidade(this);
                //removendo a peça da posição anterior
                this.posicao.setUnidade(null);
                //trocando a posição atual da peça
                this.posicao = posicao;
                return  true;
            }
        }
        return   false;
//        this.posicao = posicao;

    }
    public abstract ArrayList<Posicao> possiveisMovimento(Tabuleiro tabuleiro);

    public Posicao getPosicao() {
        return posicao;
    }



}


