import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * Polymorphism:
 * Interface:
 * Constructor:
 *
 */

public class Driver {

	public static void main(String args[]) {
		Author poe = new Author("file1.txt");
		Author kipling = new Author("file2.txt");
	}


	public static Set compareCommon(Author a1, Author a2) {

		ArrayList words1 = a1.getAuthor1Words();
		ArrayList words2 = a2.getAuthor1Words();
		Set<String> vocab1 = new HashSet<String>(words1);
		Set<String> vocab2 = new HashSet<String>(words2);
		vocab1.retainAll(vocab2);

		return vocab1;
	}

	/*public static int[] findFrequency (ArrayList list) {

		ArrayList size = findUnique(list);
		int x = size.size();
		int [] frequency = new int[x];
		ArrayList uniqueList = new ArrayList();

		uniqueList = findUnique(list);

		for (int i = 0; i <= uniqueList.size() - 1; i++) {
			for(int k =0; k <= list.size() -1; k++){
				if(uniqueList.get(i).equals(list.get(k))){
					frequency[i] = frequency[i] + 1;
				}
			}
		}
		return frequency;
	}*/

	public static ArrayList compareDifferentiatingWords(ArrayList list, ArrayList list2)
	{
//puts words into arraylist and finds the words that one list contains that the other doesn't
		ArrayList compareDifferentiatingWords = new ArrayList();

		for(int i = 0; i <= list.size()-1; i++)
		{
			int difference = 0;
			for(int k = 0; k <= list2.size()-1; k++)
			{
				if((list.get(i).equals(list2.get(k))))
					difference = 1;
			}//end of inner for loop
			if(difference == 0 && !compareDifferentiatingWords.contains(list.get(i)))
				compareDifferentiatingWords.add(list.get(i));
		}//end of outer for loop

		return compareDifferentiatingWords;
	}//end of compareDifferentiatingWords
}

