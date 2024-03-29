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
        Poker maxPoker = PokerCluster.findMaxPoker(pokers);
        //then
        assertEquals(13, maxPoker.getNumber());

    }

    @Test
    void should_return_2_when_call_compareMaxPoker_given_2H3D5S9CKD_and_2c3H4S8CAH() {
        //given
        List<Poker> pokerList1 = generatePokersList("2H 3D 5S 9C KD");
        List<Poker> pokerList2 = generatePokersList("2c 3H 4S 8C AH");
        //when
        PokerGame pokerGame = new PokerGame();
        int result = pokerGame.compareMaxPoker(pokerList1, pokerList2);
        //then
        assertEquals(2, result);

    }

    @Test
    void should_return_1_when_call_compareMaxPoker_given_2H3D5S9CKD_and_2c3H4SJCKH() {
        //given
        List<Poker> pokerList1 = generatePokersList("2H 3D 5S JC KD");
        List<Poker> pokerList2 = generatePokersList("2c 3H 4S JH KH");
        //when
        PokerGame pokerGame = new PokerGame();
        int result = pokerGame.compareMaxPoker(pokerList1, pokerList2);
        //then
        assertEquals(1, result);
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

    @Test
    void should_return_1_when_call_play_given_2H2D5S9CKD_and_2c3H4S8CAH() {
        //given
        List<Poker> pokerList1 = generatePokersList("2H 2D 5S 9C KD");
        List<Poker> pokerList2 = generatePokersList("2c 3H 4S 8C AH");
        //when
        PokerGame pokerGame = new PokerGame();
        int result = pokerGame.play(pokerList1, pokerList2);
        //then
        assertEquals(1, result);

    }

    @Test
    void should_return_2_when_call_compareBothHasPair_given_2H2D5S9CKD_and_3c3H3S8CAH() {
        //given
        List<Poker> pokerList1 = generatePokersList("2H 2D 5S 9C KD");
        List<Poker> pokerList2 = generatePokersList("3c 3H 4S 8C AH");
        PokerCluster pokerCluster1 = new PokerCluster(pokerList1);
        PokerCluster pokerCluster2 = new PokerCluster(pokerList2);
        //when
        PokerGame pokerGame = new PokerGame();
        int result = pokerGame.compareBothHasPair(pokerCluster1, pokerCluster2);
        //then
        assertEquals(2, result);

    }

    @Test
    void should_return_2_when_call_play_given_2H2D5S9CKD_and_3c3H3S8CAH() {
        //given
        List<Poker> pokerList1 = generatePokersList("2H 2D 5S 9C KD");
        List<Poker> pokerList2 = generatePokersList("3c 3H 4S 8C AH");
        //when
        PokerGame pokerGame = new PokerGame();
        int result = pokerGame.play(pokerList1, pokerList2);
        //then
        assertEquals(2, result);

    }

    @Test
    void should_return_true_when_call_isHasThreeSamePoker_given_2H2D2S9CKD() {
        //given
        List<Poker> pokerList1 = generatePokersList("2H 2D 2S 9C KD");
        PokerCluster pokerCluster = new PokerCluster(pokerList1);
        //when
        boolean result = pokerCluster.isHasThreeSamePoker();
        //then
        assertTrue(result);

    }

    @Test
    void should_return_true_when_call_isHasfourSamePoker_given_2H2D2S9CKD() {
        //given
        List<Poker> pokerList1 = generatePokersList("2H 2D 2S 2C KD");
        PokerCluster pokerCluster = new PokerCluster(pokerList1);
        //when
        boolean result = pokerCluster.isHasFourSamePoker();
        //then
        assertTrue(result);

    }

    @Test
    void should_return_true_when_call_isSequence_given_2H4D3S5C6D() {
        //given
        List<Poker> pokerList1 = generatePokersList("2H 4D 3S 5C 6D");
        PokerCluster pokerCluster = new PokerCluster(pokerList1);
        //when
        boolean result = pokerCluster.isSequence();
        //then
        assertTrue(result);

    }

    @Test
    void should_return_true_when_call_isSameType_given_2H7H3H5H6H() {
        //given
        List<Poker> pokerList1 = generatePokersList("2H 7H 3H 5H 6H");
        PokerCluster pokerCluster = new PokerCluster(pokerList1);
        //when
        boolean result = pokerCluster.isSameType();
        //then
        assertTrue(result);

    }

    @Test
    void should_return_true_when_call_isHasFiveSamePoker_given_2H7H3H5H6H() {
        //given
        List<Poker> pokerList1 = generatePokersList("2H 7H 3H 5H 6H");
        PokerCluster pokerCluster = new PokerCluster(pokerList1);
        //when
        boolean result = pokerCluster.isSameType();
        //then
        assertTrue(result);

    }

    @Test
    void should_return_6_when_get_grade_given_2H7H3H5H6H() {
        //given
        List<Poker> pokerList1 = generatePokersList("2H 7H 3H 5H 6H");
        PokerCluster pokerCluster = new PokerCluster(pokerList1);
        //when
        int result = pokerCluster.getGrade();
        //then
        assertEquals(6, result);

    }

    @Test
    void should_return_player_who_has_larger_grade_pokers_when_call_play_given_two_different_grade_pokers() {
        //given
        List<Poker> pokerList1 = generatePokersList("2H 7H 3H 5H 6H");
        List<Poker> pokerList2 = generatePokersList("2H 4D 3S 5C 6D");
        List<Poker> pokerList3 = generatePokersList("2H 2D 2S 2C 6D");
        List<Poker> pokerList4 = generatePokersList("2H 2D 2S 6C 6D");

        //when
        PokerGame pokerGame = new PokerGame();
        int result1 = pokerGame.play(pokerList1, pokerList2);
        int result2 = pokerGame.play(pokerList1, pokerList3);
        int result3 = pokerGame.play(pokerList2, pokerList3);
        int result4 = pokerGame.play(pokerList2, pokerList4);
        //then
        assertEquals(1, result1);
        assertEquals(2, result2);
        assertEquals(2, result3);
        assertEquals(2, result4);

    }

    @Test
    void should_return_2_when_call_play_given_2H2C2D5H6C_and_3H3D3S2C6D() {
        //given
        List<Poker> pokerList1 = generatePokersList("2H 2C 2D 5H 6C");
        List<Poker> pokerList2 = generatePokersList("3H 3D 3S 2C 6D");

        //when
        PokerGame pokerGame = new PokerGame();
        int result1 = pokerGame.play(pokerList1, pokerList2);

        //then
        assertEquals(2, result1);


    }

    @Test
    void should_return_2_when_call_play_given_2H2C2D2S6C_and_3H3D3S3C6D() {
        //given
        List<Poker> pokerList1 = generatePokersList("2H 2C 2D 2S 6C");
        List<Poker> pokerList2 = generatePokersList("3H 3D 3S 3C 6D");

        //when
        PokerGame pokerGame = new PokerGame();
        int result1 = pokerGame.play(pokerList1, pokerList2);

        //then
        assertEquals(2, result1);


    }





}