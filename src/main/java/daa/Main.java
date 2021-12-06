package daa;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Main {
	static HashMap<String, HashMap<Integer, ArrayList<Long>>> timeAlgo = new HashMap<>();
	static int index = 0;
	static int numTestCase = 5;
	static int numTestDone = 1000;

	public static void main(String[] args) {
		// initialization
		timeAlgo.put("KMPTime", new HashMap<Integer, ArrayList<Long>>());
		timeAlgo.put("DoubleHashMatching", new HashMap<Integer, ArrayList<Long>>());
		timeAlgo.put("Bruteforce", new HashMap<Integer, ArrayList<Long>>());
		timeAlgo.put("RabinKarpMatching", new HashMap<Integer, ArrayList<Long>>());
		timeAlgo.put("BoyerMooreHorspool", new HashMap<Integer, ArrayList<Long>>());
		timeAlgo.put("Raita", new HashMap<Integer, ArrayList<Long>>());
		for (String algo : timeAlgo.keySet()) {
			for (int index = 0; index <= numTestCase; index++) {
				timeAlgo.get(algo).put(index, new ArrayList<>());
			}
		}

		for (int i = 1; i <= numTestDone; i++) {
			System.out.println("Iterasi: " + i);
			begin();
			// System.out.println(timeAlgo.toString());

		}
		for (String algo : timeAlgo.keySet()) {
			System.out.println(algo);
			for (int i = 0; i < numTestCase; i++) {
				ArrayList<Long> time = timeAlgo.get(algo).get(i);
				long min = Collections.min(time);
				long max = Collections.max(time);
				double avg = 0;
				for (long value : time) {
					avg += value;

				}
				avg /= numTestDone;

				System.out.println("Test case number: " + i);
				System.out.println("Minimal Time: " + min);
				System.out.println("Maximal Time: " + max);
				System.out.println("Average Time: " + avg);
				System.out.println();

			}
		}
	}

	static void begin() {

		Path path = Paths.get("bees.txt").toAbsolutePath();
		// System.out.println(path.toString());
		try {
			String content = Files.readString(path, StandardCharsets.US_ASCII);
			// System.out.println(content);
			// Short testcase found early
			String text = content;
			String pattern = "jazz";
			inputCase(text, pattern);
			// Short testcase found late
			pattern = "y'all";
			inputCase(text, pattern);

			// Sentence
			pattern = "I was already a blood-sucking parasite.";
			inputCase(text, pattern);

			//Many Patterns
			pattern = "Shechchenkodsdak P1 $ %^ &7ST";
			inputCase(text, pattern);

			//Not found
			pattern = "XOXOOXOXOXOX";
			inputCase(text, pattern);
		} catch (Exception e) {
			System.out.println(e);
		}
		index = 0;

	}

	static void inputCase(String text, String pattern) {
		HashMap<String, Long> result = beginCompare(text, pattern);
		for (String algo : result.keySet()) {
			timeAlgo.get(algo).get(index).add(result.get(algo));

		}
		System.out.println();
		index++;
	}

	static HashMap<String, Long> beginCompare(String text, String pattern) {
		long KMPTime = KMP_String_Matching.matchStringTime(pattern, text);
		long DoubleTime = DoubleHashMatching.matchStringTime(pattern, text);
		long BruteforceTime = Bruteforce.matchStringTime(pattern, text);
		long RabinKarpTime = RabinKarpMatching.matchStringTime(pattern, text, 101);
		long BoyerMooreTime = BoyerMooreHorspool.matchStringTime(pattern, text);
		long RaitaTime = Raita.matchStringTime(pattern, text);

		HashMap<String, Long> algorighms = new HashMap<>();
		algorighms.put("KMPTime", KMPTime);
		algorighms.put("DoubleHashMatching", DoubleTime);
		algorighms.put("Bruteforce", BruteforceTime);
		algorighms.put("RabinKarpMatching", RabinKarpTime);
		algorighms.put("BoyerMooreHorspool", BoyerMooreTime);
		algorighms.put("Raita", RaitaTime);

		return algorighms;

	}

}
