import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by s738110 on 4/15/17.
 */
public class Author {

	private ArrayList words;
	private Set<String> vocabulary;

	public Author(String filePath){
		readWords(filePath);
		vocabulary = new HashSet<String>(words);
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
