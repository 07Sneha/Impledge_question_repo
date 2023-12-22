package impledgetech_Question;

public class TrieNode {
	 TrieNode[] children;
	    boolean isEndOfWord;

	    TrieNode() {
	        this.children = new TrieNode[26];
	        this.isEndOfWord = false;
	    }

}