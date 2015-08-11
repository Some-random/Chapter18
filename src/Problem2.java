import java.util.Random;

/**
 * Created by dongweij on 2015/8/11.
 */
public class Problem2 {
    public static void shuffle(int[] cards) {
        Random rng = new Random();
        int length = cards.length;
        for(int i = 0; i < cards.length; i++) {
            int temp = rng.nextInt(length);
            int tempvalue = cards[i];
            cards[i] = cards[temp];
            cards[temp] = tempvalue;
            
        }
    }

    public static void main(String[] args) {
        int[] cards = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        shuffle(cards);
        for(int i = 0; i < cards.length; i++) {
            System.out.print(cards[i] + " ");
        }
    }
}
