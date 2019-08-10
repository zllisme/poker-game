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
        if(maxPokerInPokers1.compareTo(maxPokerInpokers2) == 0) {
            pokers1.remove(maxPokerInPokers1);
            pokers2.remove(maxPokerInpokers2);
            return play(pokers1, pokers2);
        }
        return maxPokerInPokers1.compareTo(maxPokerInpokers2) > 0 ? 1 : 2;
    }

}
