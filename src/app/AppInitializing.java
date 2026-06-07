package app;

import java.util.Random;
import entity.Player;
import service.RankingService;

// GENERATE RANDOM PLAYERS
public class AppInitializing {

    public static void initializeData(RankingService rankingService) {
        Random random = new Random();


        String[] firstNames = {"Alex", "Bruno", "Carlos", "Diego", "Eduardo", "Felipe", "Gabriel", "Heitor", "Igor"};
        String[] lastNames = {"Silva", "Santos", "Oliveira", "Souza", "Lima", "Costa", "Pereira", "Rodrigues", "Almeida"};

        int playersCreated = 0;

        while (playersCreated < 9) {

            String randomName = firstNames[random.nextInt(firstNames.length)] + " " +
                    lastNames[random.nextInt(lastNames.length)];


            int randomScore = random.nextInt(10000) + 1;
            int randomLevel = random.nextInt(50) + 1;
            int randomTime = random.nextInt(3600) + 60;


            boolean success = rankingService.createPlayer(randomName, randomScore, randomLevel, randomTime);


            if (success) {
                playersCreated++;
            }
        }

        System.out.println(">> [Sistema] 9 jogadores aleatórios foram gerados e posicionados no ranking!");
    }
}