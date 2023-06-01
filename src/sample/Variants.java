package sample;


import java.util.List;

public class Variants {

    public static void printVariant(int i) {
        switch (i) {
            case 10 -> System.out.println("Royal flush!");
            case 9  -> System.out.println("Straight flush!");
            case 8  -> System.out.println("Four of a kind!");
            case 7  -> System.out.println("Full house!");
            case 6  -> System.out.println("Flush!");
            case 5  -> System.out.println("Straight");
            case 4  -> System.out.println("Three of a kind!");
            case 3  -> System.out.println("Two pair!");
            case 2  -> System.out.println("One pair!");
            default -> System.out.println("High card!");
        }
    }

    public static int evaluate(List<Card> hand) {
        if (isRoyalFlush(hand)) {
            return 10;
        } else if (isStraightFlush(hand)) {
            return 9;
        } else if (isFourOfAKind(hand)) {
            return 8;
        } else if (isFullHouse(hand)) {
            return 7;
        } else if (isFlush(hand)) {
            return 6;
        } else if (isStraight(hand)) {
            return 5;
        } else if (isThreeOfAKind(hand)) {
            return 4;
        } else if (isTwoPair(hand)) {
            return 3;
        } else if (isOnePair(hand)) {
            return 2;
        } else {
            return 1;
        }
    }

    private static boolean isRoyalFlush(List<Card> hand) {
        return     hand.get(4).rank() == 12
                && hand.get(3).rank() == 11
                && hand.get(2).rank() == 10
                && hand.get(1).rank() == 9
                && hand.get(0).rank() == 8
                && hand.get(4).suit() == hand.get(3).suit()
                && hand.get(4).suit() == hand.get(2).suit()
                && hand.get(4).suit() == hand.get(1).suit()
                && hand.get(4).suit() == hand.get(0).suit();
    }

    private static boolean isStraightFlush(List<Card> hand) {
        return     hand.get(4).rank() == (hand.get(3).rank() + 1)
                && hand.get(3).rank() == (hand.get(2).rank() + 1)
                && hand.get(2).rank() == (hand.get(1).rank() + 1)
                && hand.get(1).rank() == (hand.get(0).rank() + 1)
                && hand.get(4).suit() == hand.get(3).suit()
                && hand.get(4).suit() == hand.get(2).suit()
                && hand.get(4).suit() == hand.get(1).suit()
                && hand.get(4).suit() == hand.get(0).suit();
    }

    private static boolean isFourOfAKind(List<Card> hand) {
        return    (hand.get(4).rank() == hand.get(3).rank()
                && hand.get(3).rank() == hand.get(2).rank()
                && hand.get(2).rank() == hand.get(1).rank())
                || (hand.get(0).rank() == hand.get(1).rank()
                &&  hand.get(1).rank() == hand.get(2).rank()
                &&  hand.get(2).rank() == hand.get(3).rank());
    }

    private static boolean isFullHouse(List<Card> hand) {
        return    (hand.get(4).rank() == hand.get(3).rank()
                && hand.get(3).rank() == hand.get(2).rank()
                && hand.get(1).rank() == hand.get(0).rank())
                || (hand.get(4).rank() == hand.get(3).rank()
                 && hand.get(2).rank() == hand.get(1).rank()
                 && hand.get(1).rank() == hand.get(0).rank());
    }

    private static boolean isFlush(List<Card> hand) {
        return     hand.get(4).suit() == hand.get(3).suit()
                && hand.get(3).suit() == hand.get(2).suit()
                && hand.get(2).suit() == hand.get(1).suit()
                && hand.get(1).suit() == hand.get(0).suit();
    }

    private static boolean isStraight(List<Card> hand) {
        return    (hand.get(4).rank() == (hand.get(3).rank() + 1)
                && hand.get(3).rank() == (hand.get(2).rank() + 1)
                && hand.get(2).rank() == (hand.get(1).rank() + 1)
                && hand.get(1).rank() == (hand.get(0).rank() + 1))
                || (hand.get(4).rank() == 12
                &&  hand.get(0).rank() == 0
                &&  hand.get(1).rank() == 1
                &&  hand.get(2).rank() == 2
                &&  hand.get(3).rank() == 3);
    }

    private static boolean isThreeOfAKind(List<Card> hand) {
        return    (hand.get(4).rank() == hand.get(3).rank()
                && hand.get(3).rank() == hand.get(2).rank())
                || (hand.get(0).rank() == hand.get(1).rank()
                &&  hand.get(1).rank() == hand.get(2).rank());
    }

    private static boolean isTwoPair(List<Card> hand) {
        return    (hand.get(4).rank() == hand.get(3).rank()
                && hand.get(2).rank() == hand.get(1).rank())
                ||    (hand.get(0).rank() == hand.get(1).rank()
                    && hand.get(2).rank() == hand.get(3).rank())
                ||      (hand.get(4).rank() == hand.get(3).rank()
                    &&   hand.get(0).rank() == hand.get(1).rank());
    }

    private static boolean isOnePair(List<Card> hand) {
        return hand.get(4).rank() == hand.get(3).rank()
                || hand.get(3).rank() == hand.get(2).rank()
                ||   hand.get(2).rank() == hand.get(1).rank()
                ||     hand.get(1).rank() == hand.get(0).rank();
    }


}
