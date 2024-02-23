import java.util.*;

public class Jogo {
    private ArrayList<Jogador> listaJogadores;
    private Jogador melhorJogador;
    private int numeroJogadas;


    public Jogo() {
        this.listaJogadores = new ArrayList<Jogador>();
        this.melhorJogador = null;
        this.numeroJogadas = 0;
    }

    public void adicionarJogador(Jogador jogador) {
        this.listaJogadores.add(jogador);
        this.ordenaLista();
        this.atualizaMelhorJogador();

    }

    public void ordenaLista() {
        Collections.sort(this.listaJogadores, new Comparator<Jogador>() {
            @Override
            public int compare(Jogador j1, Jogador j2) {
                return j2.getPontuacao() - j1.getPontuacao();
            }
        });
    }

    private void atualizaMelhorJogador() {
        if (this.listaJogadores.isEmpty()) {
            this.melhorJogador = null;
        }
        else {
            this.melhorJogador = this.listaJogadores.get(0);
        }
    }

    public void imprimeLista(Jogador jogadorAtual) {
        System.out.println("Lista dos melhores jogadores:");
        int limite = Math.min(this.listaJogadores.size(), 12);
        for (int i = 0; i < limite; i++) {
            Jogador jogador = this.listaJogadores.get(i);
            System.out.println((i + 1) + " - " + jogador.getNome());
        }
        int posicao = this.listaJogadores.indexOf(jogadorAtual) + 1;
        System.out.println("Você está na posição " + posicao + " da lista.");
    }

    public void jogar(Jogador jogador) {
        Scanner entrada = new Scanner(System.in);
        String[] opcoes = {"pedra", "papel", "tesoura"};
        Random aleatorio = new Random();

        int escolhaComputador = aleatorio.nextInt(3);
        System.out.println("Escolha uma opção: pedra, papel e tesoura");
        String escolhaJogador = entrada.nextLine().toLowerCase();

        while (!Arrays.asList(opcoes).contains(escolhaJogador)) {
            System.out.println("Opção inválida, escolha novamente");
            escolhaJogador = entrada.nextLine().toLowerCase();
        }
        System.out.println("Você escolheu " + escolhaJogador);
        System.out.println("O computador escolheu " + opcoes[escolhaComputador]);
        int resultado = this.comparaEscolhas(escolhaJogador, opcoes[escolhaComputador]);

        if (resultado == 0) {
            System.out.println("Empate!!");
        }
        else if (resultado == 1) {
            System.out.println("Voce ganhou!");
            jogador.adicionaPontos(1);
        }
        else {
            System.out.println("Voce perdeu!");
            jogador.perdePontos(1);
        }
        jogador.adicionaTentativa();
        this.numeroJogadas++;
        this.ordenaLista();
        this.atualizaMelhorJogador();

    }
    private int comparaEscolhas(String escolhaJogador, String escolhaComputador) {
        if (escolhaJogador.equals(escolhaComputador)){
            return 0;
        }
        else if (escolhaJogador.equals("pedra") && escolhaComputador.equals("tesoura") ||
                escolhaJogador.equals("papel") && escolhaComputador.equals("pedra") ||
                escolhaJogador.equals("tesoura") && escolhaComputador.equals("papel")) {
            return 1;
        }
        else {
            return -1;
        }
    }

    public ArrayList<Jogador> getListaJogadores() {
        return this.listaJogadores;
    }

    public void setListaJogadores(ArrayList<Jogador> listaJogadores) {
        this.listaJogadores = listaJogadores;
    }

    public Jogador getMelhorJogador() {
        return melhorJogador;
    }

    public void setMelhorJogador(Jogador melhorJogador) {
        this.melhorJogador = melhorJogador;
    }

    public int getNumeroJogadas() {
        return numeroJogadas;
    }

    public void setNumeroJogadas(int numeroJogadas) {
        this.numeroJogadas = numeroJogadas;
    }

    public void jogar(int num, Jogador jogador) {
        Scanner entrada = new Scanner(System.in);
        Random aleatorio = new Random();

        int numeroSorteado = aleatorio.nextInt(num + 1);
        System.out.println("Escolha um numero entre 0 e " + num);

        int numeroJogador = entrada.nextInt();
        while (numeroJogador <= 0 || numeroJogador >= num) {
            System.out.println("Numero invalido, escolha outro numero!");
            entrada.nextLine();

        }
        System.out.println("Voce escolheu " + numeroJogador);
        System.out.println("O numero sorteado foi " + numeroSorteado);

        if (numeroJogador == numeroSorteado) {
            System.out.println("Voce acertou!!");
            jogador.adicionaPontos(1);
        }
        else {
            System.out.println("Voce errou!!!");
            jogador.perdePontos(1);
        }
        this.numeroJogadas++;
        this.ordenaLista();
        this.atualizaMelhorJogador();
    }
}