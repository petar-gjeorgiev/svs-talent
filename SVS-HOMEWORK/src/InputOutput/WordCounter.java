package InputOutput;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.StringTokenizer;

public class WordCounter {

	private static BufferedReader br;

	public static void main(String[] args) {

		try {
			FileReader file = new FileReader(
					"E:/PG/git/SVS-HOMEWORK/src/InputOutput/file.txt"); // Absolute path
			br = new BufferedReader(file);

			String line = null;
			HashMap<String, Integer> map = new HashMap<String, Integer>();

			while ((line = br.readLine()) != null) {
				StringTokenizer st = new StringTokenizer(line);
				while (st.hasMoreTokens()) {
					String word = st.nextToken();
					if (map.containsKey(word)) {
						int numTimes = map.get(word).intValue() + 1;
						map.put(word, new Integer(numTimes));
					} else {
						map.put(word, new Integer(1));
					}
				}
			}
			Set<String> keys = map.keySet();
			Iterator<String> iter = keys.iterator();
			StringBuilder sb = new StringBuilder();
			while (iter.hasNext()) {
				String key = iter.next();
				sb.append(key + " : " + map.get(key).intValue() + "\n");
			}
			System.out.println(sb.toString());
		} catch (FileNotFoundException e) {
			System.err.println(e.getMessage());
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}
	}

}
