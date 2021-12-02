package daa;

import java.util.Arrays;

public class DoubleHashMatching {
    static final int NO_OF_CHARS = 256;

    private int bkdrhash(char[] str) {
        int seed = 131;
        int hash_value = 0;
        for (int index = 0; index < str.length; index++) {
            hash_value = (hash_value * seed) + (int) str[index];
        }
        return hash_value;

    }

    private int bphash_half(char[] str) {
        int hash_value = 0;
        for (int index = 0; index < str.length; index++) {
            hash_value = hash_value << 7 ^ str[index];
        }
        return hash_value;
    }

    private int[] badCharHeuristic(char[] pat, int m) {
        int[] badchar = new int[NO_OF_CHARS];
        for (int i = 0; i < NO_OF_CHARS; i++)
            badchar[i] = m;

        for (int i = 0; i < m - 1; i++)
            badchar[pat[i]] = m - i - 1;
        return badchar;

    }

    private int double_hash(char[] pat, char[] str) {
        int m = pat.length;
        int n = str.length;
        int[] bmt = badCharHeuristic(pat, m);
        // for (int i = 0; i < bmt.length; i++) {
        // if (bmt[i] != m) {
        // System.out.println(String.valueOf((char) i) + " " + bmt[i]);
        // }
        // }
        int pHash1 = bphash_half(pat);
        int pHash2 = bkdrhash(pat);
        int i = 0;
        while (i <= n - m) {
            char[] window = Arrays.copyOfRange(str, i, m + i);
            // System.out.println(window);
            if (pat[pat.length - 1] == window[window.length - 1]) {
                int wHash1 = bphash_half(window);
                // System.out.println(wHash1 + " " + pHash1);
                if (wHash1 == pHash1) {
                    int wHash2 = bkdrhash(window);
                    if (wHash2 == pHash2) {
                        return i;
                    }
                }
            }
            i += bmt[window[window.length - 1]];
        }
        return i;
    }

    static long matchStringTime(String pattern, String text) {

        char txt[] = text.toCharArray();
        char pat[] = pattern.toCharArray();

        System.out.println("DoubleHashMatching:");
        System.out.println("Matching Text: " + text);
        System.out.println("with Pattern: " + pattern);
        long startTime = System.nanoTime();
        System.out.println("Found at " + new DoubleHashMatching().double_hash(pat, txt));
        long endTime = System.nanoTime();
        long totalTime = endTime - startTime;

        System.out.println("Double Hash Matching time (ns): " + totalTime);
        return totalTime;
    }

}
