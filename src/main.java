import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class main {
	public static void main(String[] args){

		Scanner input = new Scanner(System.in);

		Map<String, Integer> words = new HashMap<String, Integer>();

		//adds to the hashmap
		while(true) {

			String temp = input.nextLine().toLowerCase();

			if(temp.equals("-q")){
				break;
			}

			String[] array = temp.split(" ");

			for (int i = 0; i < array.length; i++) {
				if (words.containsKey(array[i])) {
					words.put(array[i], words.get(array[i]) + 1);
				} else {
					words.put(array[i], 1);
				}
			}
		}
		printMap(words);
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

}
