import java.util.ArrayList;

public class Tabuleiro {
    private ArrayList<Posicao> posicoes = new ArrayList<>();

    Tabuleiro() {
        for (int i = 0; i < 62; i++) {
            posicoes.add(new Posicao());
            if (i > 2 && i < 6) {
                posicoes.get(i).setUnidade(new Torre(20, 0, 0, "branca"));
            }
            if (i > 18 && i < 21) {
                posicoes.get(i).setUnidade(new Torre(20, 0, 0, "branca"));
            }
            if (i > 23 && i < 26) {
                posicoes.get(i).setUnidade(new Torre(20, 0, 0, "branca"));
            }
            if (i > 36 && i < 39) {
                posicoes.get(i).setUnidade(new Torre(20, 0, 0, "preta"));
            }
            if (i > 41 && i < 44) {
                posicoes.get(i).setUnidade(new Torre(20, 0, 0, "preta"));
            }
                if (i > 56 && i < 60) {
                    posicoes.get(i).setUnidade(new Torre(20, 0, 0, "preta"));
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