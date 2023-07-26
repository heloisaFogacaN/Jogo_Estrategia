import java.util.ArrayList;

public class Tabuleiro {
    public static ArrayList<Posicao> posicoes = new ArrayList<>();

    Tabuleiro() {
        ArrayList<Posicao> posicaoTorre = new ArrayList<>();

        for (int i = 0; i < 62; i++) {
            posicoes.add(new Posicao());
            if (i > 2 && i < 6) {
                posicoes.get(i).setUnidade(new Torre(20, 0, 0, "branca"));
                posicaoTorre.add(posicoes.get(i));
            }
            if (i > 18 && i < 21) {
                posicoes.get(i).setUnidade(new Torre(20, 0, 0, "branca"));
                posicaoTorre.add(posicoes.get(i));
            }
            if (i > 23 && i < 26) {
                posicoes.get(i).setUnidade(new Torre(20, 0, 0, "branca"));
                posicaoTorre.add(posicoes.get(i));
            }
            if (i > 36 && i < 39) {
                posicoes.get(i).setUnidade(new Torre(20, 0, 0, "preta"));
                posicaoTorre.add(posicoes.get(i));
            }
            if (i > 41 && i < 44) {
                posicoes.get(i).setUnidade(new Torre(20, 0, 0, "preta"));
                posicaoTorre.add(posicoes.get(i));
            }
            if (i > 56 && i < 60) {
                posicoes.get(i).setUnidade(new Torre(20, 0, 0, "preta"));
                posicaoTorre.add(posicoes.get(i));
            }
        }
    }

    public void marcarPosicao(int posicao, String marcacao) {
        posicoes.get(posicao).setMarcacao(marcacao);
    }

    public static boolean verificarTorreNaPosicao(int posicaoEscolhida) {
        Posicao posicao = posicoes.get(posicaoEscolhida - 1);
        for (int i = 0; i < 62; i++) {
            if(posicao==null){
                return false;
         }
        }
        return true;
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