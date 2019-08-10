package pokerGame;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collector;

public class PokerGame
{

    public Poker findMaxPokerFromPokerList(List<Poker> pokers) {
        return Collections.max(pokers);
    }

    public int play(List<Poker> pokers1, List<Poker> pokers2) {
        Poker maxPokerInPokers1 = findMaxPokerFromPokerList(pokers1);
        Poker maxPokerInpokers2 = findMaxPokerFromPokerList(pokers2);
        return maxPokerInPokers1.getNumber() > maxPokerInpokers2.getNumber() ? 1 : 2;
    }

}
