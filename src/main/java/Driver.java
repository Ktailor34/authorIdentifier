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
		Author kipling = new Author("File2.txt");
		Author unknown = new Author("Unknown1");

		System.out.println(poe.getWords());
		System.out.println(kipling.getWords());

		compiler(poe, unknown);

	}
	public static void compiler(Author author1, Author author2) {

		double amountUnique = 0, commonWords, total = 0, totalFrequency;
		boolean fav = false;
		ArrayList<Double> commonFrequency = new ArrayList<Double>();
		Set<String> common;
		HashMap<String, Integer> commonWordFrequency1, commonWordFrequency2;

		System.out.println("author1's Words: " + author1.getWords());
		System.out.println("author2's Words: " + author2.getWords());
		System.out.println("author1 and author2 both used: " + compareCommon(author1, author2));
		System.out.println("author1's words that author2 didn't use: " + compareDifferentiatingWords(author1, author2));
		System.out.println("author2's words that author1 didn't use: " + compareDifferentiatingWords(author2, author1));
		System.out.println("Find's frequency of author1's words: " + findFrequency(author1.getWords(), author1.getWords()));
		System.out.println("Find's frequency of author2's words: " + findFrequency(author2.getWords(), author2.getWords()));
		System.out.println("Total amount of author1's words: " + author1.getTotalWords());
		System.out.println("Total amount of author2's words: " + author2.getTotalWords());
		System.out.println("Total amount of unique words used by author1: " + author1.getVocabSize());
		System.out.println("Total amount of unique words used by author2: "+ author2.getVocabSize());
		System.out.println("author1's unique words: " + author1.getVocabulary());
		System.out.println("author2's unique words: " + author2.getVocabulary());
		System.out.println("Get's frequency of author1's words: " + author1.getFrequency());
		System.out.println("Get's frequency of author2's words: " + author2.getFrequency());
		System.out.println("author1's favorite word: " + author1.wordsToFrequency(author1.getWords()));
		System.out.println("author2's favorite word: " + author2.wordsToFrequency(author2.getWords()));

		//Unique Words Percent Error
		if(author1.getVocabSize() > author2.getVocabSize()) {
			amountUnique = (author1.getVocabSize()-author2.getVocabSize())/author1.getVocabSize();
		}

		if(author2.getVocabSize() > author1.getVocabSize()) {
			amountUnique = (author2.getVocabSize()-author1.getVocabSize())/author2.getVocabSize();
		}
		amountUnique = Math.abs(amountUnique);

		//percent of words that are not common
		common = compareCommon(author1, author2);
		commonWords = common.size();

		commonWords = (Math.max(author1.getVocabSize(), author2.getVocabSize()) - commonWords) /((author1.getVocabSize() + author2.getVocabSize())-commonWords);

		//Favorite Word
		if(author1.wordsToFrequency(author1.getWords()).equals(author2.wordsToFrequency(author2.getWords()))) {
			fav = true;

		}

		//comparing common word frequencies
		ArrayList<String> commonList = new ArrayList<String>(common);
		commonWordFrequency1 = findFrequency(author1.getWords(),commonList);
		commonWordFrequency2 = findFrequency(author2.getWords(),commonList);
		for(int y = 0; y < commonList.size(); y++) {
			double one = commonWordFrequency1.get(commonList.get(y)) / author1.getTotalWords();
			double two = commonWordFrequency2.get(commonList.get(y)) / author2.getTotalWords();

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
		System.out.println("What percent of the words were not common between both authors " + commonWords); //commonwords / unique
		System.out.println("The amount of percent error between the amount of unique words used is " + amountUnique);
		System.out.println("The amount of words in common is " + commonList.size());

		if (fav == true) {
			System.out.println((totalFrequency*(1.20)+commonWords*(1.20)+amountUnique)/6);
		}
		if (fav == false) {
			System.out.println((totalFrequency*(1.20)+commonWords*(1.20)+amountUnique)/3);
		}
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


