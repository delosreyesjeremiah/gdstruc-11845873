package com.delosreyesjeremiah;

import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        MatchmakingQueue matchmakingQueue = new MatchmakingQueue(7);
        List<Player> playerList = new ArrayList<>(7);

        playerList.add(new Player(1, "Saber", 72));
        playerList.add(new Player(2, "Archer", 98));
        playerList.add(new Player (3, "Berserker", 60));
        playerList.add(new Player(4, "Lancer", 55));
        playerList.add(new Player(5, "Rider", 46));
        playerList.add(new Player(6, "Assassin", 77));
        playerList.add(new Player(7, "Caster", 51));

        // Loop until 10 games have been completed
        int gamesCompleted = 0;
        while (gamesCompleted < 10) {
            boolean gameStart = false;
            int matchmakingRequirement = 5;

            shufflePlayers(playerList);

            // Keep matchmaking if game is ineligible to start
            while (!gameStart) {
                matchmaking(matchmakingQueue, playerList);
                matchmakingQueue.printQueue();

                if (matchmakingQueue.size() >= matchmakingRequirement) {
                    gameStart = true;
                }
                else {
                    System.out.println("\nMust have 5 players queuing to start the game...");
                }

                System.out.print("\n");
                pressEnterToContinue();
            }

            // Remove in-game players from the queue
            for (int i = 0; i < matchmakingRequirement; i++) {
                playerList.add(matchmakingQueue.peek());
                matchmakingQueue.remove();
            }

            System.out.println("\nGame has started...");
            System.out.println("\nPlayers left in queue...");

            // Print players left in the queue
            if (matchmakingQueue.size() > 0) {
                matchmakingQueue.printQueue();
            }
            else {
                System.out.println("None");
            }

            gamesCompleted++;
            System.out.println("\nGames Completed: " + gamesCompleted);

            System.out.print("\n");
            pressEnterToContinue();
        }
    }

    public static void shufflePlayers(List<Player> playerList) {
        Random random = new Random();
        for (int i = 0; i < playerList.size(); i++) {
            Player temp = playerList.get(i);
            int randomIndex = random.nextInt(playerList.size());
            playerList.set(i, playerList.get(randomIndex));
            playerList.set(randomIndex, temp);
        }
    }

    public static void matchmaking(MatchmakingQueue matchmakingQueue, List<Player> playerList) {
        Random random = new Random();
        int matchmakingCapacity = 7;
        int playersQueuing = playerList.size() + 1;
        while (playersQueuing > playerList.size()) {
            playersQueuing = random.nextInt(7) + 1;
        }

        System.out.println("\n" + (matchmakingQueue.size() + playersQueuing) + " Player/s queuing...");
        if (playersQueuing <= playerList.size()) {
            for (int i = 0; i < playersQueuing; i++) {
                if (matchmakingQueue.size() < matchmakingCapacity) {
                    matchmakingQueue.add(playerList.get(0));
                    playerList.remove(0);
                }
            }
        }
    }

    public static void pressEnterToContinue() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Press Enter to continue...");
        scanner.nextLine();
    }
}
