import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Jogador j1 = new Jogador("Jorge", "Senh@123", 20);
        Jogador j2 = new Jogador("Wilson", "Wilson", 20);

        Tabuleiro tabuleiro = new Tabuleiro();

        System.out.println(tabuleiro);
        for(int i=0;i<20;i++) {
            System.out.println("Jogador: " + j1.getNome() + " escolha suas estratégias, você possui: " + j1.getElixir() +
                    " para escolher suas peças");
            int escolha=scanner.nextInt();
//            if(escolha==possiveisMovimentos)
        }
    }
}