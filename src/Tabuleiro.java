import java.lang.module.FindException;
import java.util.ArrayList;

public class Tabuleiro {
    public static ArrayList<Posicao> posicoes = new ArrayList<>();

    Tabuleiro() {
        ArrayList<Posicao> posicaoTorre = new ArrayList<>();
        Posicao posicao = new Posicao(0);
        for (int i = 0; i < 62; i++) {
            if (i > 2 && i < 6) {
                posicao = new Posicao(i);
                posicao.setUnidade(new Torre(20, 0, 0, "branca"));
                posicoes.add(posicao);
//                posicoes.get(i).setUnidade(new Torre(20, 0, 0, "branca"));
//                posicaoTorre.add(posicoes.get(i));
            }
             else if (i > 18 && i < 21) {
                posicao = new Posicao(i);
                posicao.setUnidade(new Torre(20, 0, 0, "branca"));
                posicoes.add(posicao);
            }
           else  if (i > 23 && i < 26) {
                posicao = new Posicao(i);
                posicao.setUnidade(new Torre(20, 0, 0, "branca"));
                posicoes.add(posicao);
            }
            else if (i > 36 && i < 39) {
                posicao = new Posicao(i);
                posicao.setUnidade(new Torre(20, 0, 0, "branca"));
                posicoes.add(posicao);
            }
           else  if (i > 41 && i < 44) {
                posicao = new Posicao(i);
                posicao.setUnidade(new Torre(20, 0, 0, "branca"));
                posicoes.add(posicao);
            }
          else  if (i > 56 && i < 60) {
                posicao = new Posicao(i);
                posicao.setUnidade(new Torre(20, 0, 0, "branca"));
                posicoes.add(posicao);
            } else {
                posicoes.add(new Posicao(i));
            }
        }
    }

    public void marcarPosicao(int posicao, String marcacao) {
        posicoes.get(posicao).setMarcacao(marcacao);
    }

    public static boolean verificarTorreNaPosicao(Posicao posicaoEscolhida) {
        for (Posicao posicao: posicoes) {
            if (posicaoEscolhida.getNumero() == posicao.getNumero()){
                if (posicao.getUnidade()!=null){
                    return true;
                }
            }
        }
        return false;
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