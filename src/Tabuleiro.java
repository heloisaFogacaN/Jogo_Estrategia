import javax.swing.*;
import java.lang.module.FindException;
import java.util.ArrayList;

public class Tabuleiro {
    public ArrayList<Posicao> posicoes = new ArrayList<>();

    Tabuleiro() {
        Posicao posicao;
        for (int i = 0; i < 62; i++) {
            if (i > 2 && i < 6) {
                posicao = new Posicao(i);
                posicao.setUnidade(new Torre(20, 0, 0, "Branco", posicao));
                posicoes.add(posicao);
            } else if (i > 18 && i < 21) {
                posicao = new Posicao(i);
                posicao.setUnidade(new Torre(20, 0, 0, "Branco", posicao));
                posicoes.add(posicao);
            } else if (i > 23 && i < 26) {
                posicao = new Posicao(i);
                posicao.setUnidade(new Torre(20, 0, 0, "Branco", posicao));
                posicoes.add(posicao);
            } else if (i > 36 && i < 39) {
                posicao = new Posicao(i);
                posicao.setUnidade(new Torre(20, 0, 0, "Preto", posicao));
                posicoes.add(posicao);
            } else if (i > 41 && i < 44) {
                posicao = new Posicao(i);
                posicao.setUnidade(new Torre(20, 0, 0, "Preto", posicao));
                posicoes.add(posicao);
            } else if (i > 56 && i < 60) {
                posicao = new Posicao(i);
                posicao.setUnidade(new Torre(20, 0, 0, "Preto", posicao));
                posicoes.add(posicao);
            } else {
                posicoes.add(new Posicao(i));
            }
        }
    }

    public static void marcarPosicao(Posicao posicao) {
        posicao.setUnidade(null);
        posicao.setMarcacao("X");
    }

    public boolean verificarTorreNaPosicao(Posicao posicaoEscolhida) {
        for (Posicao posicao : posicoes) {
            if (posicaoEscolhida.getNumero() == posicao.getNumero()) {
                if (posicao.getUnidade() != null) {
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
        String tabuleiro = "";
        int posicao = 0;
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 9; j++) {
                if (posicao < posicoes.size()) {
                    Posicao posicaoAtual = posicoes.get(posicao);
                    Unidade unidade = posicaoAtual.getUnidade();
                    String marcacao = posicaoAtual.getMarcacao();

                    if (unidade != null) {
                        tabuleiro += "|" + unidade + "|";
                    } else if (marcacao != null) {
                        tabuleiro += ("|" + marcacao + "|");
                    } else {
                        tabuleiro += ("|   |");
                    }
                    posicao++;
                }
            }
            tabuleiro += ("  \n");
        }
        posicao=0;
        return tabuleiro;
    }
}