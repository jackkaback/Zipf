import javax.swing.*;
import java.util.*;

public class main {
	public static void main(String[] args){
		
		// For input selection
		String[] values = {"Load from file", "Enter manually", "Quit"};
		Object selected;

		Scanner input = new Scanner(System.in);

		ArrayList<word> words = new ArrayList<word>();
		while(true) {
			selected = JOptionPane.showInputDialog(null, "What is the target Nicotine level?", "Selection", JOptionPane.DEFAULT_OPTION, null, values, "0");

			// adds words found from a txt file
			if(selected == "Load from file"){

			}
			// Adds manually entered ords to the list
			else if(selected == "Enter manually") {

			}

			// exits
			else if(selected == "Quit"){
				break;
			}
		}
	}
}
