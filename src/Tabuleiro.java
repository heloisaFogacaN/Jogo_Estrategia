import java.util.ArrayList;

public class Tabuleiro {
    private ArrayList<Posicao> posicoes = new ArrayList<>();

    Tabuleiro() {
        for (int i = 0; i < 120; i++) {
            posicoes.add(new Posicao());
            if(i>3 && i<7){
                posicoes.get(i).setUnidade(new Torre(20, 0, 0, 0));
            }
            if(i>112 && i<117){
                posicoes.get(i).setUnidade(new Torre(20, 0,0, 0));
            }
        }
    }
    public ArrayList<Posicao> getPosicoes() {
        return posicoes;
    }

    @Override
    public String toString() {
        return "Tabuleiro:" +
                "posicoes=" + posicoes;
    }
}