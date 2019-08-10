package pokerGame;

import java.util.*;

public class PokerCluster {

    private List<Poker> pokers;

    private List<Integer> pairPokersNumbers;

    private List<Integer> threeSamePokersNumbers;

    private List<Integer> fourSamePokersNumbers;

    public PokerCluster(List<Poker> pokers) {
        this.pokers = pokers;
        this.pairPokersNumbers = new ArrayList<>();
        this.threeSamePokersNumbers = new ArrayList<>();
        this.fourSamePokersNumbers = new ArrayList<>();
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
                this.pairPokersNumbers.add(number);
            }
            if(value == 3) {
                this.threeSamePokersNumbers.add(number);
            }
            if(value == 4) {
                this.fourSamePokersNumbers.add(number);
            }
        }
    }

    public boolean isHasPairPoker() {
        return this.pairPokersNumbers.size() > 0;
    }

    public List<Integer> getPairPokersNumbers() {
        return pairPokersNumbers;
    }

    public List<Integer> getThreeSamePokersNumbers() {
        return threeSamePokersNumbers;
    }

    public List<Integer> getFourSamePokersNumbers() {
        return fourSamePokersNumbers;
    }
}
