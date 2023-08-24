import java.util.ArrayList;

public class Partida {
    private int rodada = 0;
    private int turno = 0;
    private Tabuleiro tabuleiro;
    private ArrayList<Jogador> jogadores = new ArrayList<>();

    public ArrayList<Jogador> getJogadores() {
        return jogadores;
    }

    public Partida(Jogador j1, Jogador j2) {
        this.tabuleiro = new Tabuleiro();
        this.jogadores.add(j1);
        this.jogadores.add(j2);
    }

    public Jogador jogadorTurno() {
        return jogadores.get(turno % 2);
    }

    public Jogador adversarioTurno() {
        return jogadores.get((turno + 1) % 2);
    }

    public Jogador jogadorRodada() {
        return jogadores.get(rodada % 2);
    }

    public Jogador adversarioRodada() {
        return jogadores.get((rodada + 1) % 2);
    }

    public void trocarTurno() {
        turno++;
    }

    public void trocarRodada(){
        rodada++;
        turno=rodada%2;
    }

    public boolean verificaCor(Unidade unidade) {
        return !unidade.getCor().equals(jogadorTurno().getCor());
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
