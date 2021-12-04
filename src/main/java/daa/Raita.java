package daa;

import java.util.Arrays;

public class Raita {
    static final int NO_OF_CHARS = 256;

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
        int i = 0;
        while (i <= n - m) {
            char[] window = Arrays.copyOfRange(str, i, m + i);
            if (pat[pat.length - 1] == window[window.length - 1]) {
                if (pat[0] == window[0]) {
                    if (pat[pat.length / 2] == window[window.length / 2]) {
                        boolean flag = true;
                        for (int j = 1; j < pat.length - 1; j++) {
                            if (pat[j] != window[j]) {
                                flag = false;
                                break;
                            }
                        }
                        if (flag) {
                            return i;
                        }
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

        long startTime = System.nanoTime();
        long index = new Raita().double_hash(pat, txt);
        long endTime = System.nanoTime();
        long totalTime = endTime - startTime;

        System.out.println("Raita time (ns): " + totalTime);
        System.out.println("Found at " + index);
        return totalTime;
    }

}
