package sample;

import java.util.*;
import java.util.concurrent.TimeUnit;

public class Game {

    public static void play() throws InterruptedException {

        var sortingAlgorithm = Comparator.comparing(Card::rank)
                .thenComparing(Card::suit);

        List<Card> deck = Card.getStandardDeck();

        System.out.println("Shuffling the deck...");
        System.out.println();
        TimeUnit.MILLISECONDS.sleep(500);
        Collections.shuffle(deck);

        System.out.println("Dealing the cards...");
        System.out.println();
        TimeUnit.MILLISECONDS.sleep(500);

        List<Card> playerHand = new ArrayList<>(5);
        for (int i = 0; i <= 8; i += 2) {
            playerHand.add(deck.get(i));
        }

        playerHand.sort(sortingAlgorithm);
        System.out.println("playerHand = " + playerHand);

        List<Card> computerHand = new ArrayList<>(5);
        for (int i = 1; i <= 9; i += 2) {
            computerHand.add(deck.get(i));
        }

        deck.removeAll(playerHand);
        deck.removeAll(computerHand);

        Scanner scanner = new Scanner(System.in);

        System.out.println("-".repeat(30));
        System.out.println("Choose the maximum of 4 cards you want to replace and press ENTER to continue" +
                " or E to end replacing");

        boolean flag = true;
        while (flag) {
            System.out.println(playerHand);
            System.out.println();
            try {
                switch (scanner.nextLine().toUpperCase()) {
                    case "1" -> playerHand.remove(0);
                    case "2" -> playerHand.remove(1);
                    case "3" -> playerHand.remove(2);
                    case "4" -> playerHand.remove(3);
                    case "5" -> playerHand.remove(4);
                    case "E" -> flag = false;
                    default -> System.out.println("Try again!");
                }
            } catch (Exception e) {
                System.out.println("Try again!");
            }
        }

        if (playerHand.size() != 5) {
            System.out.println();
            System.out.println("Replacing cards...");
            while (playerHand.size() != 5) {
                playerHand.add(deck.get(0));
                deck.remove(0);
            }
        }

        TimeUnit.MILLISECONDS.sleep(1000);
        playerHand.sort(sortingAlgorithm);
        System.out.println("-".repeat(30));
        System.out.println("playerHand = " + playerHand);
        Variants.printVariant(Variants.evaluate(playerHand));

        System.out.println("-".repeat(30));

        TimeUnit.MILLISECONDS.sleep(500);
        computerHand.sort(sortingAlgorithm);
        System.out.println("computerHand = " + computerHand);
        Variants.printVariant(Variants.evaluate(computerHand));

        TimeUnit.MILLISECONDS.sleep(1000);
        System.out.println("-".repeat(30));
        getWinner(playerHand, computerHand);
    }

    private static void getWinner(List<Card> playerHand, List<Card> computerHand) {
        if (Variants.evaluate(playerHand) > Variants.evaluate(computerHand)) {
            System.out.println("You win!");
        } else if (Variants.evaluate(playerHand) < Variants.evaluate(computerHand)) {
            System.out.println("You lose!");
        } else if (playerHand.get(4).rank() > computerHand.get(4).rank()) {
            System.out.println("You win!");
        } else if (playerHand.get(3).rank() > computerHand.get(3).rank()) {
            System.out.println("You win!");
        } else if (playerHand.get(2).rank() > computerHand.get(2).rank()) {
            System.out.println("You win!");
        } else if (playerHand.get(1).rank() > computerHand.get(1).rank()) {
            System.out.println("You win!");
        } else if (playerHand.get(0).rank() > computerHand.get(0).rank()) {
            System.out.println("You win!");
        } else if (playerHand.get(4).rank() == computerHand.get(4).rank()
                && playerHand.get(3).rank() == computerHand.get(3).rank()
                && playerHand.get(2).rank() == computerHand.get(2).rank()
                && playerHand.get(1).rank() == computerHand.get(1).rank()
                && playerHand.get(0).rank() == computerHand.get(0).rank()) {
            System.out.println("Draw!");
        } else {
            System.out.println("You lose!");
        }
    }
}
