package pokerGame;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PokerGameTest {

    List<Poker> generatePokersList(String pokers) {
        String[] pokersArr = pokers.split(" ");
        List<Poker> pokerList = new ArrayList<>();
        for (int i = 0; i < pokersArr.length; i++) {
            pokerList.add(new Poker(pokersArr[i]));
        }
        return pokerList;
    }


    @Test
    void should_return_negative_number_when_compare_two_poker_given_3H_4D() {
        //given
        Poker poker1 = new Poker("3H");
        Poker poker2 = new Poker("4D");
        //when
        int result = poker1.compareTo(poker2);
        //then
        assertTrue(result < 0);

    }

    @Test
    void should_return_max_poker_when_call_findMaxPokerFromPokerList_given_pokers_list() {
        //given
        List<Poker> pokers = new ArrayList<>();
        pokers.add(new Poker("2H"));
        pokers.add(new Poker("3D"));
        pokers.add(new Poker("KD"));
        pokers.add(new Poker("9C"));
        pokers.add(new Poker("4H"));
        //when
        PokerGame pokerGame = new PokerGame();
        Poker maxPoker = pokerGame.findMaxPokerFromPokerList(pokers);
        //then
        assertEquals(13, maxPoker.getNumber());

    }

    @Test
    void should_return_2_when_call_play_given_2H3D5S9CKD_and_2c3H4S8CAH() {
        //given
        List<Poker> pokerList1 = generatePokersList("2H 3D 5S 9C KD");
        List<Poker> pokerList2 = generatePokersList("2c 3H 4S 8C AH");
        //when
        PokerGame pokerGame = new PokerGame();
        int result = pokerGame.play(pokerList1, pokerList2);
        //then
        assertEquals(2, result);

    }

    @Test
    void should_return_1_when_call_play_given_2H3D5S9CKD_and_2c3H4SJCKH() {
        //given
        List<Poker> pokerList1 = generatePokersList("2H 3D 5S JC KD");
        List<Poker> pokerList2 = generatePokersList("2c 3H 4S JH KH");
        //when
        PokerGame pokerGame = new PokerGame();
        int result = pokerGame.play(pokerList1, pokerList2);
        //then
        assertEquals(1, result);
    }
}