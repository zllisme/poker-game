package pokerGame;

public class Poker implements Comparable{

    private int number;

    private char type;

    private final static String ORDERS_SEQUENCE = "234567891JQKA";

    public Poker(String poker) {
        this.number = ORDERS_SEQUENCE.indexOf(poker.charAt(0)) + 2;
        this.type = poker.length() == 3 ? poker.charAt(2) : poker.charAt(1);
    }

    @Override
    public int compareTo(Object o) {
        Poker poker = (Poker) o;
        return this.number - poker.getNumber();
    }

    public int getNumber() {
        return number;
    }

    public char getType() {
        return type;
    }
}
