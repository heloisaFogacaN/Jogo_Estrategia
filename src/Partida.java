import java.util.ArrayList;

public class Partida {
    private int turno = 0;
    private Tabuleiro tabuleiro = new Tabuleiro();
    private ArrayList<Jogador> jogadores = new ArrayList<>();

    public ArrayList<Jogador> getJogadores() {
        return jogadores;
    }

    public Jogador jogadorDaVez() {
        return jogadores.get(turno % 2);
    }

    public void trocarTurno() {
        turno++;
    }

    public boolean verificaCor(Unidade unidade) {
        return !unidade.getCor().equals(jogadorDaVez().getCor());
    }

    public void addJogador(Jogador jogador) {
        if (jogadores.size() == 0) {
            jogador.setCor("Branco");
        } else {
            jogador.setCor("Preto");
        }
        jogadores.add(jogador);

    }

    public Tabuleiro getTabuleiro() {
        return tabuleiro;
    }
}
