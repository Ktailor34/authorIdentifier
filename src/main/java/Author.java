import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by s738110 on 4/15/17.
 */
public class Author {

	private ArrayList<String> words;
	private Set<String> vocabulary;
	private double vocabSize;
	private double totalWords;
	private HashMap<String, Integer> frequency;




	public Author(String filePath) {
		readWords(filePath);
		vocabulary = new HashSet<String>(words);
		vocabSize = vocabulary.size();
		totalWords = words.size();
		wordsToFrequency(words);
	}

	public void readWords(String filePath){
		String line;
		words = new ArrayList<String>();

		try {
			File file = new File(getClass().getClassLoader().getResource(filePath).getFile());
			FileReader fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);

			while (( line = bufferedReader.readLine()) != null) {
				line = line.replaceAll("[^a-zA-Z]", " ").toLowerCase();
				for (String word : line.split("\\s+")) {
					words.add(word);
				}
			}
		} catch (FileNotFoundException ex) {
			System.out.println("File not found");
		} catch (IOException ex) {
			System.out.println("IO Exception");
		}
	}


	public String wordsToFrequency(ArrayList<String> words) {
		frequency = new HashMap<String, Integer>();
		int max = 0;

		String fav = null;
		for (int i = 0; i < words.size(); i++) {
			if (frequency.containsKey(words.get(i))) {
				int count = frequency.get(words.get(i));
				frequency.put(words.get(i), count + 1);
				if (count > max && !words.get(i).equals("")) {
					fav = words.get(i);
				}
			} else {
				frequency.put(words.get(i), 1);
			}
		}
		return fav;
	}

	public double getTotalWords() {
		return totalWords;
	}

	public HashMap<String, Integer> getFrequency() {
		return frequency;
	}

	public double getVocabSize() {
		return vocabSize;
	}

	public Set<String> getVocabulary() {
		return vocabulary;
	}

	public ArrayList getAuthor1Words() {
		return words;
	}

	public ArrayList<String> getWords() {
		return words;
	}

}
