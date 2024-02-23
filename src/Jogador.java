import java.util.Scanner;

public class Jogador {
    private String nome;
    private int idade;
    private int pontuacao;
    private int numeroTentativas;

    public Jogador(String nome, int idade, Jogo jogo) {
        this.nome = this.validaNome(nome, jogo);
        this.idade = idade;
        this.pontuacao = 0;
        this.numeroTentativas = 0;
    }

    public String validaNome(String nome, Jogo jogo) {
        Scanner entrada= new Scanner(System.in);
        boolean nomeValido = true;
        do {
            nomeValido = true;
            for (Jogador jogador : jogo.getListaJogadores()) {
                if (jogador.getNome().equals(nome)) {
                    nomeValido = false;
                    break;
                }
            }
            if (!nomeValido) {
                System.out.print("Esse nome ja exixte! Digite outro nome: ");
                nome = entrada.nextLine();
            }
        }
        while (!nomeValido);
        return nome;
    }

    public void adicionaPontos(int pontos) {
        this.pontuacao += pontos;
    }

    public void perdePontos(int pontos) {
        this.pontuacao -= pontos;
    }

    public void adicionaTentativa() {
        this.numeroTentativas++;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public int getPontuacao() {
        return pontuacao;
    }

    public void setPontuacao(int pontuacao) {
        this.pontuacao = pontuacao;
    }

    public int getNumeroTentativas() {
        return numeroTentativas;
    }

    public void setNumeroTentativas(int numeroTentativas) {
        this.numeroTentativas = numeroTentativas;
    }
}