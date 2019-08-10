package pokerGame;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collector;

public class PokerGame
{

    public Poker findMaxPokerFromPokerList(List<Poker> pokers) {
        return Collections.max(pokers);
    }

}
