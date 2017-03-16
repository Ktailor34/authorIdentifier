import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by s738110 on 3/15/17.
 */
public class Driver {

	public static void main (String args[]) {

		Scanner lineScanner = new Scanner(System.in);
		String line;
		ArrayList test = new ArrayList();
		boolean done = false;
		boolean done1 = false;
		ArrayList authorList = new ArrayList();
		ArrayList author1List = new ArrayList();
		//ArrayList Grace = new ArrayList();
		//ArrayList Hannah = new ArrayList();
		//Hannah.add("a");
		//Grace.add("a");
		String[] Hannah = {"q", "w", "e", "e", "t", "y"};
		String[] Standard = {"q", "w", "e", "e", "t", "y"};
		ArrayList unique = new ArrayList();


		while (lineScanner.hasNextLine() && done1 != true) {
			while (lineScanner.hasNextLine() && done != true) {
				// Takes in entire string
				line = lineScanner.nextLine();
				// Removes punctuation
				line = line.replaceAll("[^a-zA-Z]", " ").toLowerCase();
				//Tokens string to allow to read one word at a time
				Scanner token = new Scanner(line);
				//splits tokened setring
				while (token.hasNextLine()) {
					authorList.add(token.next());
				}



				if (line.equals("done")) {
					System.out.println(authorList);
					done = true;
				}
			}
			while (lineScanner.hasNextLine() && done1 != true) {
				// Takes in entire string
				line = lineScanner.nextLine();
				// Removes punctuation
				line = line.replaceAll("[^a-zA-Z]", " ").toLowerCase();
				//Tokens string to allow to read one word at a time
				Scanner token = new Scanner(line);
				//splits tokened setring
				while (token.hasNextLine()) {
					author1List.add(token.next());
				}

				if (line.equals("done")) {
					System.out.println(authorList);
					System.out.println(author1List);
					done1 = true;
				}
			}
		}
		test = compareCommon(authorList, author1List);
		System.out.println(test);
	}

	public static ArrayList compareCommon(ArrayList list, ArrayList list2){

		//Puts words into array and compares similar words
		ArrayList common = new ArrayList();
		for(int i = 0; i <= list.size()-1; i++) {
			for(int k = 0; k <= list2.size()-1; k++) {
				if (list.get(k).equals(list2.get(i)) && !common.contains(list.get(k))) {

					common.add(list.get(k));

				}
			}
		}
		return common;
	}

	public static ArrayList findUnique(ArrayList list){

		//Puts words into array and compares similar words
		ArrayList unique = new ArrayList();
		for(int i = 0; i <= list.size()-1; i++) {
			for(int k = 0; k <= list.size()-1; k++) {
				if (!unique.contains(list.get(k))) {

					unique.add(list.get(k));

				}
			}
		}
		return unique;

	}


}
