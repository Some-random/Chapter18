/**
 * Created by dongweij on 2015/8/11.
 */
public class Problem8 {
    public static class TrieNode {
        // Initialize your data structure here.
        TrieNode() {
            isWord = false;
        }
        char val;
        TrieNode[] child = new TrieNode[26];
        Boolean isWord;
    };

    public static class Trie {
        Trie() {
            root = new TrieNode();
        }

        // Inserts a word into the trie.
        void insert(String word) {
            TrieNode temproot = root;
            for (int i = 0; i < word.length(); i++) {
                if (temproot.child[word.charAt(i) - 'a'] != null) {
                    temproot = temproot.child[word.charAt(i)- 'a'];
                }
                else {
                    temproot.child[word.charAt(i) - 'a'] = new TrieNode();
                    temproot.child[word.charAt(i) - 'a'].val = word.charAt(i);
                    temproot = temproot.child[word.charAt(i) - 'a'];
                }
            }
            temproot.isWord = true;
        }

        // Returns if the word is in the trie.
        Boolean search(String word) {
            TrieNode temproot = root;
            for (int i = 0; i < word.length(); i++) {
                if (temproot.child[word.charAt(i) - 'a'] == null) {
                    return false;
                }
                temproot = temproot.child[word.charAt(i) - 'a'];
            }
            return temproot.isWord;
        }

        // Returns if there is any word in the trie
        // that starts with the given prefix.
        Boolean startsWith(String prefix) {
            TrieNode temproot = root;
            for (int i = 0; i < prefix.length(); i++) {
                if (temproot.child[prefix.charAt(i) - 'a'] == null) {
                    return false;
                }
                temproot = temproot.child[prefix.charAt(i) - 'a'];
            }
            return true;
        }

        TrieNode root;
    };


    //Standard usage of trie, with the way I used to build the trie, only lower case chars are accepted
    //Insert s and all of its substrings into the trie and test for startWith
    public static void main(String[] args) {
        String testString = "mississippi";
        String[] stringList = {"is", "sip", "hi", "sis"};
        Trie tri = new Trie();
        for(int i = 0; i < testString.length(); i++) {
            tri.insert(testString.substring(i));
        }
        for(int i = 0; i < stringList.length; i++) {
            System.out.println(tri.startsWith(stringList[i]));
        }
    }
}
