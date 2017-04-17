import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by s738110 on 4/15/17.
 */
public class Author {

	private ArrayList words;
	private Set<String> vocabulary;
	private int vocabSize;
	private int totalWords;
	HashMap frequency;


	public Author(String filePath){
		readWords(filePath);
		vocabulary = new HashSet<String>(words);
		vocabSize = vocabulary.size();
		totalWords = words.size();
		wordsToFrequency(words);
	}

	public void wordsToFrequency(ArrayList words){
		frequency = new HashMap<String, Integer>();
		for (int i = 0; i < words.size(); i++){
			for( int k = 0; k < vocabulary.size(); k++){
				if(frequency.containsKey(words.get(i))){
					int count = (int)frequency.get(words.get(i));
					frequency.put(words.get(i), count + 1 );
				}

				if(!frequency.containsKey(words.get(i))){
					frequency.put(words.get(i), 1);
				}
			}
		}
	}

	public int getTotalWords() {
		return totalWords;
	}

	public int getVocabSize() {
		return vocabSize;
	}

	public Set<String> getVocabulary() {
		return vocabulary;
	}

	public ArrayList getAuthor1Words() {
		return words;
	}

	public void readWords(String filePath){
		String line;
		words = new ArrayList();

		try {
			FileReader fileReader = new FileReader(filePath);
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
}
