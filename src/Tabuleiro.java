import javax.swing.*;
import java.lang.module.FindException;
import java.util.ArrayList;

public class Tabuleiro {
    public static ArrayList<Posicao> posicoes = new ArrayList<>();

    Tabuleiro() {
        Posicao posicao;
        for (int i = 0; i < 62; i++) {
            if (i > 2 && i < 6) {
                posicao = new Posicao(i);
                posicao.setUnidade(new Torre(20, 0, 0, "branca"));
                posicoes.add(posicao);
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
                posicao.setUnidade(new Torre(20, 0, 0, "preta"));
                posicoes.add(posicao);
            }
           else  if (i > 41 && i < 44) {
                posicao = new Posicao(i);
                posicao.setUnidade(new Torre(20, 0, 0, "preta"));
                posicoes.add(posicao);
            }
          else  if (i > 56 && i < 60) {
                posicao = new Posicao(i);
                posicao.setUnidade(new Torre(20, 0, 0, "preta"));
                posicoes.add(posicao);
            } else {
                posicoes.add(new Posicao(i));
            }
        }
    }

    public void marcarPosicao(Posicao posicao, String marcacao) {
        posicoes.get(posicao.getNumero()).setUnidade(null);
        posicoes.get(posicao.getNumero()).setMarcacao(marcacao);
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

    public static boolean verrificaCor(Posicao posicaoAtacada, Jogador jogador){
        for(Posicao posicao : posicoes){
            if (posicaoAtacada.getNumero() == posicao.getNumero()){
                if (!(posicaoAtacada!=null) && posicaoAtacada.getUnidade().getCor().equals(jogador.getCor())){
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