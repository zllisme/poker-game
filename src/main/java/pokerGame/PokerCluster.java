package pokerGame;

import java.util.*;

public class PokerCluster {

    private List<Poker> pokers;

    private int grade;

    private List<Integer> pairPokersNumbers;

    private List<Integer> threeSamePokersNumbers;

    private List<Integer> fourSamePokersNumbers;

    public PokerCluster(List<Poker> pokers) {
        Collections.sort(pokers);
        this.pokers = pokers;
        this.pairPokersNumbers = new ArrayList<>();
        this.threeSamePokersNumbers = new ArrayList<>();
        this.fourSamePokersNumbers = new ArrayList<>();
        calculateMutipleCounts();
        calculateGrade();
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

    private void calculateGrade() {
        this.grade = 1;
        if(isHasPairPoker()) {
            this.grade = this.pairPokersNumbers.size() == 1 ? 2 : 3;
        }
        if(isHasThreeSamePoker()) {
            this.grade = 4;
        }
        if(isHasFourSamePoker()) {
            this.grade = 8;
        }
        if(isSequence() && !isSameType()) {
            this.grade = 5;
        }
        if(isSequence() && isSameType()) {
            this.grade = 9;
        }


    }

    public boolean isSequence() {
        for (int i = 0; i < this.pokers.size() - 1; i++) {
            if(this.pokers.get(i + 1).getNumber() - this.pokers.get(i).getNumber() != 1) {
                return false;
            }
        }
        return true;
    }

    public boolean isSameType() {
        char baseType = this.pokers.get(0).getType();
        for (int i = 1; i < this.pokers.size(); i++) {
            if(this.pokers.get(i).getType() != baseType){
                return false;
            }
        }
        return true;
    }

    public boolean isHasPairPoker() {
        return this.pairPokersNumbers.size() > 0;
    }

    public boolean isHasThreeSamePoker() {
        return this.threeSamePokersNumbers.size() > 0;
    }

    public boolean isHasFourSamePoker() {
        return this.fourSamePokersNumbers.size() > 0;
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
