package pokerGame;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PokerCluster {

    private List<Poker> pokers;

    private Map<Integer, Integer> pairPokersCounts;

    private Map<Integer, Integer> threeSamePokersCount;

    private Map<Integer, Integer> fourSamePokersCount;

    public PokerCluster(List<Poker> pokers) {
        this.pokers = pokers;
        this.pairPokersCounts = new HashMap<>();
        this.threeSamePokersCount = new HashMap<>();
        this.fourSamePokersCount = new HashMap<>();
        calculateMutipleCounts();
    }

    public static Poker findMaxPoker(List<Poker> pokerList) {
        return Collections.max(pokerList);
    }

    private Map<Integer, Integer> calculateCounts() {
        Map<Integer, Integer> countsMap = new HashMap<>();
        this.pokers.forEach(poker -> {
            Integer number = poker.getNumber();
            Integer count = countsMap.containsKey(number) ? countsMap.get(number) + 1 : 1;
            countsMap.put(number, count);
        });
        return countsMap;

    }

    private void calculateMutipleCounts() {
        Map<Integer, Integer> countsMap = calculateCounts();
        for(Map.Entry<Integer, Integer> count : countsMap.entrySet()) {
            Integer value = count.getValue();
            Integer number = count.getKey();
            if(value == 2) {
                this.pairPokersCounts.put(number, value);
            }
            if(value == 3) {
                this.threeSamePokersCount.put(number, value);
            }
            if(value == 4) {
                this.fourSamePokersCount.put(number, value);
            }
        }
    }

    public boolean isHasPairPoker() {
        return this.pairPokersCounts.size() > 0;
    }

}
