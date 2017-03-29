import java.util.ArrayList;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by s738110 on 3/15/17.
 */
public class Driver {


	public static void main(String args[]) {


		Scanner lineScanner = new Scanner(System.in);
		String line = null;
		ArrayList test = new ArrayList();
		boolean done = false;
		boolean done1 = false;
		ArrayList authorList = new ArrayList();
		ArrayList author1List = new ArrayList();
		//ArrayList Grace = new ArrayList();
		//ArrayList Hannah = new ArrayList();
		//Hannah.add("a");
		//Grace.add("a");
		//String[] Hannah = {"q", "w", "e", "e", "t", "y"};
		//String[] Standard = {"q", "w", "e", "e", "t", "y"};
		ArrayList unique = new ArrayList();


		try {
			String fileName = "File1.txt";
			FileReader fileReader = new FileReader(fileName);
			BufferedReader bufferedReader = new BufferedReader(fileReader);

			while ((line = bufferedReader.readLine()) != null) {
				line = line.replaceAll("[^a-zA-Z]", " ").toLowerCase();
				for (String word : line.split(" ")) {
					authorList.add(word);
				}
			}


			// Takes in entire string
			//line = lineScanner.nextLine();
			// Removes punctuation
			//Tokens string to allow to read one word at a time
			//Scanner token = new Scanner(line);
			//splits tokened setring
			/*while (token.hasNextLine()) {
				authorList.add(token.next());
			}*/

		} catch (FileNotFoundException ex) {
			System.out.println("File not found");
		} catch (IOException ex) {
			System.out.println("IO Exception");
		}

		try {
			String fileName = "File2.txt";
			FileReader fileReader = new FileReader(fileName);
			BufferedReader bufferedReader = new BufferedReader(fileReader);

			while ((line = bufferedReader.readLine()) != null) {
				line = line.replaceAll("[^a-zA-Z]", " ").toLowerCase();
				//System.out.println(line);

				for (String word : line.split(" ")) {
					author1List.add(word);
				}
			}

		} catch (FileNotFoundException ex) {
			System.out.println("File not found");
		} catch (IOException ex) {
			System.out.println("IO Exception");
		}

		System.out.println(authorList);
		System.out.println(author1List);
		test = compareCommon(authorList, author1List);
		System.out.println(test);
		System.out.println(findUnique(authorList));

	}


	public static ArrayList compareCommon(ArrayList list, ArrayList list2) {

		//Puts words into array and compares similar words
		ArrayList common = new ArrayList();
		for (int i = 0; i <= list.size() - 1; i++) {
			for (int k = 0; k <= list2.size() - 1; k++) {
				if (list.get(i).equals(list2.get(k)) && !common.contains(list.get(k))) {

					common.add(list.get(i));
				}
			}
		}
		return common;
	}

	public static ArrayList findUnique(ArrayList list) {

		//Puts words into array and compares similar words
		ArrayList unique = new ArrayList();
		for (int i = 0; i <= list.size() - 1; i++) {
			for (int k = 0; k <= list.size() - 1; k++) {
				if (!unique.contains(list.get(k))) {

					unique.add(list.get(k));

				}
			}
		}
		return unique;

	}

	public static ArrayList compareDifferentiatingWords(ArrayList list, ArrayList list2) {
		//puts words into arraylist and finds the words that one list contains that the other doesn't
		ArrayList compareDifferentiatingWords = new ArrayList();

		for (int i = 0; i <= list.size() - 1; i++) {
			for (int k = 0; k <= list2.size() - 1; k++) {
				if (!(list.get(i).equals(list2.get(k)))) {
					//System.out.println("Added to list: " + list.get(k));
					int difference = 1;
				}
			}//end of inner for loop
		}//end of outer for loop

		return compareDifferentiatingWords;
	}
}

