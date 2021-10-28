import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Dictionary<String, String> d = new Dictionary<String, String>();
		Scanner scanner;
		try {
			scanner = new Scanner(new File("DictionaryWordValuePairs.csv"));
			// ADD THE FIRST 200
			int l = 0;
			while (scanner.hasNextLine() && (l < 200)) {
				String[] line = scanner.nextLine().split(",");
				String key = line[0];
				String value = "";
				for (int i=1; i < line.length; i++) {
					value += line[i];
				}
				d.add(key, value);
				l++;
			}

			// SHOW THE UNSORTED
			d.showDictionary();

			// SORT IT AND SHOW IT
			d.sort();
			d.showDictionary();

			// ADD IN REST (BUT SORTED)
			while (scanner.hasNextLine()) {
				String[] line = scanner.nextLine().split(",");
				String key = line[0];
				String value = "";
				for (int i=1; i < line.length; i++) {
					value += line[i];
				}
				d.addSorted(key, value);
				l++;
			}

			// SHOW IT AGAIN
			d.showDictionary();

			scanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
