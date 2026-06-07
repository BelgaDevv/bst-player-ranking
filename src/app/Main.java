package app;

import java.util.Scanner;

import entity.Player;
import service.RankingService;

public class Main {


    private static Scanner scanner = new Scanner(System.in);
    private static RankingService rankingService = new RankingService();

    public static void main(String[] args) {

        AppInitializing.initializeData(rankingService);
        int option;

        do {
            showMenu();
            option = readInt("Escolha uma opção: ");
            System.out.println();
            executeOption(option);
        } while (option != 0);

        scanner.close();
    }

    private static void showMenu() {
        System.out.println("\n====================================");
        System.out.println(" SISTEMA DE RANKING DE JOGADORES");
        System.out.println("====================================");
        System.out.println("1 - Cadastrar jogador");
        System.out.println("2 - Buscar jogador por pontuação");
        System.out.println("3 - Atualizar jogador");
        System.out.println("4 - Remover jogador");
        System.out.println("5 - Mostrar ranking em ordem crescente");
        System.out.println("6 - Mostrar maior pontuação");
        System.out.println("7 - Mostrar menor pontuação");
        System.out.println("8 - Mostrar quantidade de jogadores");
        System.out.println("9 - Mostrar altura da árvore");
        System.out.println("10 - Exibir jogadores em pré-ordem");
        System.out.println("11 - Exibir jogadores em pós-ordem");
        System.out.println("0 - Encerrar sistema");
        System.out.println("====================================");
    }

    private static void executeOption(int option) {
        switch (option) {
            case 1:
                createPlayer();
                break;
            case 2:
                searchPlayer();
                break;
            case 3:
                updatePlayer();
                break;
            case 4:
                deletePlayer();
                break;
            case 5:
                rankingService.showRankingInOrder();
                break;
            case 6:
                showPlayer(rankingService.getHighestScorePlayer(), "Nenhum jogador cadastrado.");
                break;
            case 7:
                showPlayer(rankingService.getLowestScorePlayer(), "Nenhum jogador cadastrado.");
                break;
            case 8:
                System.out.println("Quantidade de jogadores: " + rankingService.countPlayers());
                break;
            case 9:
                System.out.println("Altura da árvore: " + rankingService.getTreeHeight());
                break;
            case 10:
                rankingService.showRankingPreOrder();
                break;
            case 11:
                rankingService.showRankingPostOrder();
                break;
            case 0:
                System.out.println("Sistema encerrado.");
                break;
            default:
                System.out.println("Opção inválida. Tente novamente.");
        }
    }

    private static void createPlayer() {
        System.out.println("CADASTRO DE JOGADOR");
        String name = readText("Nome: ");
        int score = readInt("Pontuação: ");
        int level = readInt("Fase alcançada: ");
        int time = readInt("Tempo de jogo: ");

        boolean created = rankingService.createPlayer(name, score, level, time);
        if (created) {
            System.out.println("Jogador cadastrado com sucesso.");
        } else {
            System.out.println("Já existe um jogador com essa pontuação.");
        }
    }

    private static void searchPlayer() {
        int score = readInt("Digite a pontuação do jogador: ");
        Player player = rankingService.findPlayerByScore(score);
        showPlayer(player, "Jogador não encontrado.");
    }

    private static void updatePlayer() {
        int originalScore = readInt("Digite a pontuação atual do jogador: ");
        Player currentPlayer = rankingService.findPlayerByScore(originalScore);

        if (currentPlayer == null) {
            System.out.println("Jogador não encontrado.");
            return;
        }

        System.out.println("Jogador atual:");
        System.out.println(currentPlayer);
        System.out.println("\nDigite os novos dados do jogador.");

        String name = readText("Nome: ");
        int newScore = readInt("Pontuação: ");
        int level = readInt("Fase alcançada: ");
        int time = readInt("Tempo de jogo: ");

        Player playerWithNewScore = rankingService.findPlayerByScore(newScore);
        if (newScore != originalScore && playerWithNewScore != null) {
            System.out.println("Não foi possível atualizar. A nova pontuação já está cadastrada.");
            return;
        }

        boolean updated = rankingService.updatePlayer(originalScore, name, newScore, level, time);
        if (updated) {
            System.out.println("Jogador atualizado com sucesso.");
        } else {
            System.out.println("Não foi possível atualizar o jogador.");
        }
    }

    private static void deletePlayer() {
        int score = readInt("Digite a pontuação do jogador que será removido: ");
        boolean deleted = rankingService.deletePlayer(score);

        if (deleted) {
            System.out.println("Jogador removido com sucesso.");
        } else {
            System.out.println("Jogador não encontrado.");
        }
    }

    private static void showPlayer(Player player, String emptyMessage) {
        if (player == null) {
            System.out.println(emptyMessage);
            return;
        }
        System.out.println(player);
    }

    private static String readText(String message) {
        String text;

        do {
            System.out.print(message);
            text = scanner.nextLine().trim();

            if (text.isEmpty()) {
                System.out.println("O campo não pode ficar vazio.");
            }
        } while (text.isEmpty());

        return text;
    }

    private static int readInt(String message) {
        while (true) {
            System.out.print(message);
            String value = scanner.nextLine().trim();

            try {
                int number = Integer.parseInt(value);
                if (number < 0) {
                    System.out.println("Digite um número maior ou igual a zero.");
                } else {
                    return number;
                }
            } catch (NumberFormatException exception) {
                System.out.println("Entrada inválida. Digite um número inteiro.");
            }
        }
    }
}
