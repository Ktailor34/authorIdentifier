import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.lang.Math;

/**
 * Polymorphism:
 * Interface:
 * Constructor:
 *
 */

public class Driver {
	private static HashMap<String, Integer> frequency1;

	public static void main(String args[]) {

		Author poe = new Author("File1.txt");
		Author kipling = new Author("testFile");

		System.out.println(poe.getWords());
		System.out.println(kipling.getWords());

		double amountUnique = 0, middle, commonWords, total = 0, totalFrequency;
		boolean fav = false;
		ArrayList<Double> commonFrequency = new ArrayList<Double>();
		Set<String> common;
		HashMap<String, Integer> commonWordFrequency1, commonWordFrequency2;

		System.out.println("Poe's Words: " + poe.getWords());
		System.out.println("Kipling's Words: " + kipling.getWords());
		System.out.println("Poe and Kipling both used: " + compareCommon(poe, kipling));
		System.out.println("Poe's words that Kipling didn't use: " + compareDifferentiatingWords(poe, kipling));
		System.out.println("Kipling's words that Poe didn't use: " + compareDifferentiatingWords(kipling, poe));
		System.out.println("Find's frequency of Poe's words: " + findFrequency(poe.getWords(), poe.getWords()));
		System.out.println("Find's frequency of Kipling's words: " + findFrequency(kipling.getWords(), kipling.getWords()));
		System.out.println("Total amount of Poe's words: " + poe.getTotalWords());
		System.out.println("Total amount of Kipling's words: " + kipling.getTotalWords());
		System.out.println("Total amount of unique words used by Poe: " + poe.getVocabSize());
		System.out.println("Total amount of unique words used by Kipling: "+ kipling.getVocabSize());
		System.out.println("Poe's unique words: " + poe.getVocabulary());
		System.out.println("Kipling's unique words: " + kipling.getVocabulary());
		System.out.println("Get's frequency of Poe's words: " + poe.getFrequency());
		System.out.println("Get's frequency of Kipling's words: " + kipling.getFrequency());
		System.out.println("Poe's favorite word: " + poe.wordsToFrequency(poe.getWords()));
		System.out.println("Kipling's favorite word: " + kipling.wordsToFrequency(kipling.getWords()));

		//Unique Words Percent Error
		if(poe.getVocabSize() > kipling.getVocabSize()) {
			amountUnique = (poe.getVocabSize()-kipling.getVocabSize())/poe.getVocabSize();
		}

		if(kipling.getVocabSize() > poe.getVocabSize()) {
			amountUnique = (kipling.getVocabSize()-poe.getVocabSize())/kipling.getVocabSize();
		}
			amountUnique = Math.abs(amountUnique);

		//percent of words that are not common
		common = compareCommon(poe, kipling);
		commonWords = common.size();
		if(poe.getVocabSize() > kipling.getVocabSize()) {
			commonWords = (Math.abs(poe.getVocabSize()-commonWords))/poe.getVocabSize();
		}
		if(kipling.getVocabSize() > poe.getVocabSize()) {
			commonWords = (Math.abs(kipling.getVocabSize()-commonWords))/kipling.getVocabSize();
		}

		//Favorite Word
		if(poe.wordsToFrequency(poe.getWords()).equals(kipling.wordsToFrequency(kipling.getWords()))) {
			fav = true;
		}

		//comparing common word frequencies
		ArrayList<String> commonList = new ArrayList<String>(common);
		commonWordFrequency1 = findFrequency(poe.getWords(),commonList);
		commonWordFrequency2 = findFrequency(kipling.getWords(),commonList);
		for(int y = 0; y < commonList.size(); y++) {
			double one = commonWordFrequency1.get(commonList.get(y));
			double two = commonWordFrequency2.get(commonList.get(y));

			if (one > two) {
				commonFrequency.add(((one - two)) / one);
			}

			if (two >= one) {
				commonFrequency.add(((two - one)) / two);
			}
		}
		for (int u = 0; u < commonFrequency.size(); u++) {
			total = commonFrequency.get(u) + total;
		}

		totalFrequency = total / commonFrequency.size();
		System.out.println("What is the percent error between the frequencies of the common words? " + totalFrequency);
		System.out.println("Do the favorite words match? " + fav);
		//System.out.println("What percent of the words are not common " + commonWords);
		System.out.println("The amount of percent error between the amount of unique words used is " + amountUnique);
		System.out.println("The amount of words in common is " + commonList.size());
	}

	public static Set compareCommon(Author a1, Author a2) {

		ArrayList words1 = a1.getAuthor1Words();
		ArrayList words2 = a2.getAuthor1Words();
		Set<String> vocab1 = new HashSet<String>(words1);
		Set<String> vocab2 = new HashSet<String>(words2);
		vocab1.retainAll(vocab2);

		return vocab1;
	}

	public static ArrayList compareDifferentiatingWords(Author a1, Author a2) {
	//puts words into arraylist and finds the words that one list contains that the other doesn't
		ArrayList compareDifferentiatingWords = new ArrayList();
		ArrayList author1 = new ArrayList(a1.getVocabulary());
		ArrayList author2 = new ArrayList(a2.getVocabulary());

		for(int i = 0; i < author1.size(); i++) {
			int difference = 0;
			for(int k = 0; k < author2.size(); k++) {
				if((author1.get(i).equals(author2.get(k)))) {
					difference = 1;
				}
			}//end of inner for loop
			if(difference == 0 && !compareDifferentiatingWords.contains(author1.get(i))) {
				compareDifferentiatingWords.add(author1.get(i));
			}
		}//end of outer for loop

		return compareDifferentiatingWords;
	}//end of compareDifferentiatingWords

	public static HashMap<String, Integer> findFrequency(ArrayList<String> words, ArrayList<String> comparison) {
		frequency1 = new HashMap<String, Integer>();
		Set<String> set = new HashSet<String>(comparison);
		Set<String> set1 = new HashSet<String>(words);
		set.retainAll(set1);
		ArrayList<String> comparison1 = new ArrayList<String>(set);

		for (int a = 0; a < comparison1.size(); a++){
			frequency1.put(comparison1.get(a), 0);
		}

		for (int i = 0; i < words.size(); i++) {
			for(int k =0; k < comparison1.size(); k++) {
					if(words.get(i).equals(comparison1.get(k))) {
						int count = frequency1.get(comparison1.get(k));
						frequency1.put(comparison1.get(k), count + 1);
				}
			}
		}
		return frequency1;
	}

}


