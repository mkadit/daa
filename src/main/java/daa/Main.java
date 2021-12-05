package daa;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;

public class Main {
	public static void main(String[] args) {
		// for (int index = 0; index < 10; index++) {

		// }
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

		text = "DKLMEALDMAJKCPEAOKRLEMGKHOELKASNMELKMLAKFMLAJLMKLELQRKJROIQUIMEALDMAJKCPEAOKRLEMGKHOELKASNMELKMLAKFMLAJLMKLELQRKJROIJKADWJKLJE";
		pattern = "LKMLAKFMLAJLMKLELQRKJROIQUIMEALDMAJKCPEAOKRLEMGKHOELKASNMELKMLAKFML";
		beginCompare(text, pattern);

		text = "38120380^%^!#!HJKnkjdshfkahdkcy39479Shechchenkodsdak P1 $ %^ &7ST asdkj128937 97sdf6&^76381687&^*#!*&(*(FASDKJQWHEUYC))";
		pattern = "Shechchenkodsdak P1 $ %^ &7ST";
		beginCompare(text, pattern);

		Path path = Paths.get("bees.txt").toAbsolutePath();
		// System.out.println(path.toString());
		try {
			String content = Files.readString(path, StandardCharsets.US_ASCII);
			// System.out.println(content);
			text = content;
			pattern = "jazz";
			beginCompare(text, pattern);
		} catch (Exception e) {
			System.out.println(e);
		}
		// text = """
		// """;
	}

	static long[] beginCompare(String text, String pattern) {
		// System.out.println("Matching Text: " + text);
		// System.out.println("with Pattern: " + pattern);
		long KMPTime = KMP_String_Matching.matchStringTime(pattern, text);
		// System.out.println();
		long DoubleTime = DoubleHashMatching.matchStringTime(pattern, text);
		// System.out.println();
		long BruteforceTime = Bruteforce.matchStringTime(pattern, text);
		// System.out.println();
		long RabinKarpTime = RabinKarpMatching.matchStringTime(pattern, text, 101);
		// System.out.println();
		long BoyerMooreTime = BoyerMooreHorspool.matchStringTime(pattern, text);
		// System.out.println();
		long RaitaTime = Raita.matchStringTime(pattern, text);

		long[] times = { KMPTime, DoubleTime, BruteforceTime, RabinKarpTime, BoyerMooreTime, RaitaTime };
		Arrays.sort(times);

		HashMap<Long, String> algorighms = new HashMap<>();
		algorighms.put(KMPTime, "KMPTime");
		algorighms.put(DoubleTime, "DoubleHashMatching");
		algorighms.put(BruteforceTime, "Bruteforce");
		algorighms.put(RabinKarpTime, "RabinKarpMatching");
		algorighms.put(BoyerMooreTime, "BoyerMooreHorspool");
		algorighms.put(RaitaTime, "Raita");

		String fastestAlgorithm = algorighms.get(times[0]);
		// System.out.println(
		// "The fastest algorithm with\ntext:" + text + "\nPattern: " + pattern + "\nis:
		// " + fastestAlgorithm);
		System.out.println(
				"The fastest algorithm with" + "\nis: " + fastestAlgorithm);
		System.out.println();
		return times;

	}

}
