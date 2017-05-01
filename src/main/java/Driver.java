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
		ArrayList<Integer> commonFrequency = new ArrayList<Integer>();
		Set<String> common;
		HashMap<String, Integer> commonWordFrequency1, commonWordFrequency2;

		//Unique Words Percent Error
		if(poe.getVocabSize() > kipling.getVocabSize()) {
			amountUnique = (poe.getVocabSize()-kipling.getVocabSize())/poe.getVocabSize();
		}

		if(kipling.getVocabSize() > poe.getVocabSize()) {
			amountUnique = (poe.getVocabSize()-kipling.getVocabSize())/poe.getVocabSize();
		}
			amountUnique = Math.abs(amountUnique);

		//Common Words Percent Error
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
			int one = commonWordFrequency1.get(commonList.get(y));
			int two = commonWordFrequency2.get(commonList.get(y));

			if (one > two) {
				commonFrequency.add(Math.abs((one - two)) / one);
			}

			if (two >= one) {
				commonFrequency.add(Math.abs((two - one)) / two);
			}
		}
		for (int u = 0; u < commonFrequency.size(); u++) {
			total = commonFrequency.get(u) + total;
		}

		totalFrequency = total / commonFrequency.size();
		System.out.println(totalFrequency);
		System.out.println(fav);
		System.out.println(commonWords);
		System.out.println(amountUnique);
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


