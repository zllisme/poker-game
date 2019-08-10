package pokerGame;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PokerGameTest {


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


}