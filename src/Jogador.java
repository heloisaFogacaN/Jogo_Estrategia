import java.util.ArrayList;

public class Jogador {
    private String nome;
    private String senha;
    private String pontos;
    private int elixir;

    public Jogador(String nome, String senha, int elixir){
        this.nome=nome;
        this.senha=senha;
        this.elixir=elixir;
    }

    public String getNome() {
        return nome;
    }

    public String getSenha() {
        return senha;
    }

    public int getElixir() {
        return elixir;
    }

    public void setElixir(int elixir) {
        this.elixir = elixir;
    }
}