/**
 * SYST 17796 Project Winter 2019 Base code.
 * Students can modify and extend to implement their game.
 * Add your name as a modifier and the date!
 *
 */
package ca.sheridancollege.project;

public class Card {

    private Suit suit;
    private Value value;

    //Value, then int rep as suit
    public Card(int value, int suit) {
        this.value = convertValue(value);
        this.suit = getSuit(suit);
    }

    public Card(Suit suit, Value value) {
        this.value = value;
        this.suit = suit;
    }

    public Suit getSuit(int value) {
        Suit suit = null;

        if (value == 0) {
            return Suit.DIAMOND;
        } else if (value == 1) {
            return Suit.HEART;
        } else if (value == 2) {
            return Suit.SPADE;
        } else if (value == 3) {
            return Suit.CLUB;
        }

        return suit;
    }

    private Value convertValue(int temp) {
        Value none = null;

        switch (temp) {
            case 1:
                return Value.ACE;
            case 2:
                return Value.TWO;
            case 3:
                return Value.THREE;
            case 4:
                return Value.FOUR;
            case 5:
                return Value.FIVE;
            case 6:
                return Value.SIX;
            case 7:
                return Value.SEVEN;
            case 8:
                return Value.EIGHT;
            case 9:
                return Value.NINE;
            case 10:
                return Value.TEN;
            case 11:
                return Value.JACK;
            case 12:
                return Value.QUEEN;
            case 13:
                return Value.KING;
            default:
                break;
        }
        return none;

    }

    public Suit getSuit() {
        return suit;
    }

    public Value getValue() {
        return value;
    }

    @Override
    public String toString() {
        return String.valueOf(this.value) + " of " + String.valueOf(this.suit);
    }
}