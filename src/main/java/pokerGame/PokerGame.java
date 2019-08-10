package pokerGame;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collector;

public class PokerGame
{

    public int compareMaxPoker(List<Poker> pokers1, List<Poker> pokers2) {
        Poker maxPokerInPokers1 = PokerCluster.findMaxPoker(pokers1);
        Poker maxPokerInpokers2 = PokerCluster.findMaxPoker(pokers2);
        if(maxPokerInPokers1.compareTo(maxPokerInpokers2) == 0) {
            pokers1.remove(maxPokerInPokers1);
            pokers2.remove(maxPokerInpokers2);
            return compareMaxPoker(pokers1, pokers2);
        }
        return maxPokerInPokers1.compareTo(maxPokerInpokers2) > 0 ? 1 : 2;

    }



    public int play(List<Poker> pokers1, List<Poker> pokers2) {
        PokerCluster pokerCluster1 = new PokerCluster(pokers1);
        PokerCluster pokerCluster2 = new PokerCluster(pokers2);
        if(!pokerCluster1.isHasPairPoker() && !pokerCluster2.isHasPairPoker()){
            return compareMaxPoker(pokers1, pokers2);
        }
        return pokerCluster1.isHasPairPoker() ? 1 : 2;
    }

}
