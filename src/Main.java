import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        Jogo jogo = new Jogo();
        Jogador jogador = null;
        boolean sair = false;
        while (!sair) {
            System.out.println("Bem-vindo ao Jogo!");
            System.out.print("Digite o seu nome ou 'novo' para criar um novo jogo: ");
            String nome = entrada.nextLine();
            if (nome.equalsIgnoreCase("novo")) {
                System.out.print("Digite o seu nome: ");
                nome = entrada.nextLine();
                System.out.print("Digite a sua idade: ");
                int idade = entrada.nextInt();
                entrada.nextLine();
                jogador = new Jogador(nome, idade, jogo);
                jogo.adicionarJogador(jogador);
            }
            else {
                boolean encontrado = false;
                for (Jogador j : jogo.getListaJogadores()) {
                    if (j.getNome().equalsIgnoreCase(nome)) {
                        jogador = j;
                        encontrado = true;
                        break;
                    }
                }
                if (!encontrado) {
                    System.out.println("Jogador não encontrado. Tente novamente.");
                    continue;
                }
            }

            System.out.println("Olá, " + jogador.getNome() + "!");
            System.out.println("Escolha um dos jogos abaixo:");
            System.out.println("1 - Pedra, papel e tesoura");
            System.out.println("2 - Adivinhe o número");
            System.out.println("3 - Sair");
            System.out.print("Opção escolhida: ");
            int opcao = entrada.nextInt();
            entrada.nextLine();

            switch (opcao) {
                case 1:
                    jogo.jogar(jogador);
                    break;
                case 2:
                    System.out.print("Digite um numero limite para o jogo: ");
                    int num = entrada.nextInt();
                    entrada.nextLine();
                    jogo.jogar(num, jogador);
                    break;
                case 3:
                    sair = true;
                    break;
                default:
                    System.out.println("Opção inválida, tente novamente.");
                    continue;
            }
            if (!sair) {
                System.out.println("Ecolha uma das opções a seguir:");
                System.out.println("1 - Ver ranking completo");
                System.out.println("2 - Ver top 10");
                System.out.println("3 - Jogar novamente");
                System.out.println("4 - Encerrar jogo");
                System.out.print("Opção escolhida: ");
                opcao = entrada.nextInt();
                entrada.nextLine();

                switch (opcao) {
                    case 1:
                        jogo.imprimeLista(jogador);
                        break;
                    case 2:
                        jogo.imprimeLista(jogador);
                        break;
                    case 3:
                        continue;
                    case 4:
                        sair = true;
                        break;
                    default:
                        System.out.println("Opção inválida, tente novamente.");
                        continue;

                }
            }

        }

        System.out.println("Obrigado por jogar!");

    }

}