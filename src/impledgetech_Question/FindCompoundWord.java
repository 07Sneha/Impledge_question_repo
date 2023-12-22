package impledgetech_Question;

import java.io.*;
import java.util.*;

public class FindCompoundWord {
// here we are inserting word in our trie
	public static void insertWord(TrieNode root, String word) {
        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            int index = ch - 'a';
            if (node.children[index] == null) {
                node.children[index] = new TrieNode();
            }
            node = node.children[index];
        }
        node.isEndOfWord = true;
    }
	//checking that whether the current word can be formed by concatenating other words in the trie.
	public static boolean isCompoundWord(TrieNode root, String word, int startIndex, int count) {
		TrieNode current = root;

        for (int i = startIndex; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';

            if (current.children[index] == null) {
                return false;
            }

            current = current.children[index];

            if (current.isEndOfWord) {
                if (i == word.length() - 1) {
                    return count >= 1; 
                }

                if (isCompoundWord(root, word, i + 1, count + 1)) {
                    return true;
                }
            }
        }

        return false; 
        }
	//keep track of longest and second longert word
	 public static String[] findLongestCompoundWords(TrieNode root, List<String> words) {
		 String longestWord = "";
	        String secondLongestWord = "";

	        for (String word : words) {
	            if (isCompoundWord(root, word, 0, 0)) {
	                if (word.length() > longestWord.length()) {
	                    secondLongestWord = longestWord;
	                    longestWord = word;
	                } else if (word.length() > secondLongestWord.length()) {
	                    secondLongestWord = word;
	                }
	            }
	        }

	        return new String[]{longestWord, secondLongestWord};	
	        }
	 //main to read input from file and to call method of longestCompound word and show output on console
	public static void main(String[] args) {
		/* here we give path of our input file 
		 for input 1:"C:\\Users\\hp\\eclipse hibernate\\impledgetech_Question\\src\\impledgetech_Question\\Input_01.txt"
		 for input 2:"C:\\Users\\hp\\eclipse hibernate\\impledgetech_Question\\src\\impledgetech_Question\\Input_02.txt"
		 further it depends on file location
		 */
		long startTime = System.currentTimeMillis();
		 String inputFilePath = "C:\\Users\\hp\\eclipse hibernate\\impledgetech_Question\\src\\impledgetech_Question\\Input_01.txt";
	        TrieNode root = new TrieNode();
	        List<String> words = new ArrayList<>();

	        try (BufferedReader br = new BufferedReader(new FileReader(inputFilePath))) {
	            String line;
	            while ((line = br.readLine()) != null) {
	                String word = line.trim();
	                insertWord(root, word);
	                words.add(word);
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }

	        String[] result = findLongestCompoundWords(root, words);
	        long endTime = System.currentTimeMillis();
	        double elapsedTime = endTime - startTime;

	        System.out.println("Longest Compound Word: " + result[0]);
	        System.out.println("Second Longest Compound Word: " + result[1]);
	        System.out.println("Time taken to process file : " + elapsedTime + " milliseconds");
	}

}
