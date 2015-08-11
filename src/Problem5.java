import CtCILibrary.CtCILibrary.AssortedMethods;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by dongweij on 2015/8/11.
 */
public class Problem5 {
    public static void makeHSALI(HashMap<String, ArrayList<Integer>> HSALI, String[] wordlist) {
        for(int i = 0; i < wordlist.length; i++) {
            if(!HSALI.containsKey(wordlist[i])) {
                ArrayList<Integer> temp = new ArrayList<>();
                temp.add(i);
                HSALI.put(wordlist[i], temp);
            }
            else {
                ArrayList<Integer> temp = HSALI.get(wordlist[i]);
                temp.add(i);
                HSALI.put(wordlist[i], temp);
            }
        }
    }

    public static String combine(String a, String b) {
        String temp = "";
        if(a.compareTo(b) > 0) {
            temp = a + b;
        }
        else {
            temp = b + a;
        }
        return temp;
    }

    /*
    So yeah... I'm not using any algorithm here... Using the idea of insertion sort can bring the time complexity to O(n)
     */
    public static int minDistance(ArrayList<Integer> AI1, ArrayList<Integer> AI2) {
        int minDist = Integer.MAX_VALUE;
        for(int i = 0; i < AI1.size(); i++) {
            for(int j = 0; j < AI2.size(); j++) {
                minDist = Math.min(minDist, Math.abs(AI1.get(i) - AI2.get(j)));
            }
        }
        return minDist;
    }

    public static void makeHSI(HashMap<String, Integer> HSI, HashMap<String, ArrayList<Integer>> HSALI) {
        HashMap<String, ArrayList<Integer>> HSALICpy = (HashMap<String, ArrayList<Integer>>) HSALI.clone();
        for(String it : HSALI.keySet()) {
            for(String it2 : HSALICpy.keySet()) {
                String temp = combine(it, it2);
                if(HSI.containsKey(temp)) {
                    continue;
                }
                else {
                    HSI.put(temp, minDistance(HSALI.get(it), HSALICpy.get(it2)));
                }
            }
        }
    }

    //The algorithm in the solution doesn't actually run on O(1) time... My solution does it tho... The space complexity
    // is O(number of characters in the article)
    public static void main(String[] args) {
        String[] wordlist = AssortedMethods.getLongTextBlobAsStringList();
        //The HashMap to store position of words
        HashMap<String, ArrayList<Integer>> HSALI = new HashMap<>();
        makeHSALI(HSALI, wordlist);
        //The HashMap to store the min distance between words
        HashMap<String, Integer> HSI = new HashMap<>();
        makeHSI(HSI, HSALI);

        //Following is the test code
        String[][] pairs = {{"Lara", "the"}, {"river", "life"}, {"path", "their"}, {"life", "a"}};
        for(int i = 0; i < pairs.length; i++) {
            String temp = combine(pairs[i][0], pairs[i][1]);
            System.out.println("The distance between " + pairs[i][0] + " and " + pairs[i][1] + " " + "is " + HSI.get(temp));
        }
    }

}
