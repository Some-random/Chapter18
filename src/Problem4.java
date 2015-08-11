/**
 * Created by dongweij on 2015/8/11.
 */
public class Problem4 {
    public static int countTwos(int n) {
        int upper = n, lower = 0, result = 0, lowercount = 0, cur;
        while(upper > 0) {
            cur = upper % 10;
            upper = upper / 10;
            if(cur < 2) {
                result += upper * Math.pow(10, lowercount);
            }
            else if(cur == 2) {
                result += upper * Math.pow(10, lowercount) + lower + 1;
            }
            else {
                result += (upper + 1) * Math.pow(10, lowercount);
            }
            lower += Math.pow(10, lowercount) * cur;
            lowercount++;
        }
        return result;
    }

    public static void main(String args[]) {
        System.out.println(countTwos(10));
        System.out.println(countTwos(333));
        System.out.println(countTwos(224567));
    }

}
