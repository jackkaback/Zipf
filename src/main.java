import javax.swing.*;
import java.util.*;

public class main {
	public static void main(String[] args){
		
		// For input selection
		String[] values = {"Load from file", "Enter manually", "Quit"};
		Object selected;

		Scanner input = new Scanner(System.in);

		HashMap<String, Integer> words = new HashMap<String, Integer>();

		while(true) {
			selected = JOptionPane.showInputDialog(null, "What is the target Nicotine level?", "Selection", JOptionPane.DEFAULT_OPTION, null, values, "0");

			// adds words found from a txt file
			if(selected == "Load from file"){
			}
			// Adds manually entered ords to the list
			else if(selected == "Enter manually") {
				words.putAll(getManualEntry(input));
			}

			// exits
			else if(selected == "Quit"){
				break;
			}
		}
		words = sortByValue((HashMap<String, Integer>) words);
		printMap(words);
	}

	public static HashMap<String, Integer> getManualEntry(Scanner input) {

		HashMap<String, Integer> startMap = new HashMap<String, Integer>();

		//adds to the hashmap
		while(true) {

			String temp = input.nextLine().toLowerCase();

			if(temp.equals("-q")){
				break;
			}

			String[] array = temp.split(" ");

			for (int i = 0; i < array.length; i++) {
				if (startMap.containsKey(array[i])) {
					startMap.put(array[i], startMap.get(array[i]) + 1);
				} else {
					startMap.put(array[i], 1);
				}
			}
		}

		return startMap;

	}


	// Prints all the hashmap
	public static void printMap(Map mp) {
		Iterator it = mp.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry pair = (Map.Entry)it.next();
			System.out.println(pair.getKey() + " = " + pair.getValue());
			it.remove();
		}
	}

	// returns the new hashmap
	public static HashMap<String, Integer> sortByValue(HashMap<String, Integer> unsortedArray) {
		//LinkedHashMap preserve the ordering of elements in which they are inserted
		LinkedHashMap<String, Integer> reverseSortedMap = new LinkedHashMap<>();

		//Use Comparator.reverseOrder() for reverse ordering
		unsortedArray.entrySet()
				.stream()
				.sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
				.forEachOrdered(x -> reverseSortedMap.put(x.getKey(), x.getValue()));

		return reverseSortedMap;
	}

}
