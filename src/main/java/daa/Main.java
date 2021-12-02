package daa;

import java.util.Arrays;
import java.util.HashMap;

public class Main {
	public static void main(String[] args) {
		String text = "Sofita";
		String pattern = "ofi";
		beginCompare(text, pattern);

		text = "DAADJSAKAS";
		pattern = "JSA";
		beginCompare(text, pattern);

		text = "LALALSDJSKLAJKLDSAJKLJKLKLKAAAXOXJDASLKJDSKLASDALK";
		pattern = "XOX";
		beginCompare(text, pattern);

		text = "XIJASDLJLKNCKLNAKLDMQWEPOQWIRJQFLKANVASKGHAJDAKLSJELKQWJYUUYYUYXUYUXYUYULDKASJLYUYUYUYUKDASJLKDJASLKASDJLK";
		pattern = "YUYUYUYU";
		beginCompare(text, pattern);


		text = "DKLMEALDMAJKCPEAOKRLEMGKHOELKASNMELKMLAKFMLAJLMKLELQRKJROIQUIJKADWJKLJE";
		pattern = "ELKMLA";
		beginCompare(text, pattern);
	}

	static void beginCompare(String text, String pattern) {
        System.out.println("Matching Text: " + text);
        System.out.println("with Pattern: " + pattern);
		long KMPTime = KMP_String_Matching.matchStringTime(pattern, text);
		System.out.println();
		long DoubleTime = DoubleHashMatching.matchStringTime(pattern, text);
		System.out.println();
		long BruteforceTime = Bruteforce.matchStringTime(pattern, text);
		System.out.println();
		long RabinKarpTime = RabinKarpMatching.matchStringTime(pattern, text, 101);

		long[] times = { KMPTime, DoubleTime, BruteforceTime };
		Arrays.sort(times);

		HashMap<Long, String> algorighms = new HashMap<>();
		algorighms.put(KMPTime, "KMPTime");
		algorighms.put(DoubleTime, "DoubleHashMatching");
		algorighms.put(BruteforceTime, "Bruteforce");
		algorighms.put(RabinKarpTime, "RabinKarpMatching");

		String fastestAlgorithm = algorighms.get(times[0]);
		System.out.println("The fastest algorithm with\ntext:"+ text+"\nPattern: "+pattern+"\nis: "+ fastestAlgorithm);
		System.out.println();

	}

}
