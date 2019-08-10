package pokerGame;

import java.util.Collections;
import java.util.List;

public class PokerCluster {

    private List<Poker> pokers;

    public PokerCluster(List<Poker> pokers) {
        this.pokers = pokers;
    }

    public static Poker findMaxPoker(List<Poker> pokerList) {
        return Collections.max(pokerList);
    }

}
