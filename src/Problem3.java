import java.util.Random;

/**
 * Created by dongweij on 2015/8/11.
 */
public class Problem3 {
    public static int[] selectRandomly(int[] cards, int m) {
        int[] result = new int[m];
        int length = cards.length;
        Random rng = new Random();
        for(int i = 0; i < m; i++) {
            result[i] = cards[rng.nextInt(length)];
        }
        return result;
    }

    public static void main(String[] args) {
        int[] cards = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] result = selectRandomly(cards, 5);
        for(int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
    }
}
