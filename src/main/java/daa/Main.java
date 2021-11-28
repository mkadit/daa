package daa;

public class Main {
	public static void main(String[] args) {
		String text = "Sofita";
		String pattern = "ofi";
		long KMPTime = KMP_String_Matching.matchStringTime(pattern, text);
		System.out.println();
		long DoubleTime = DoubleHashMatching.matchStringTime(pattern, text);
		compareTime(KMPTime, DoubleTime);

		text = "DAADJSAKAS";
		pattern = "JSA";
		KMPTime = KMP_String_Matching.matchStringTime(pattern, text);
		System.out.println();
		DoubleTime = DoubleHashMatching.matchStringTime(pattern, text);
		compareTime(KMPTime, DoubleTime);
	}

	static void compareTime(long KMPTime, long DoubleTime) {
		if (KMPTime < DoubleTime) {
			System.out.println("\nKMP String Matching is faster");
		} else {

			System.out.println("\nDouble Hashing is faster");
		}
	}
}
