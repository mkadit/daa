package daa;

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

        text = "XIJASDLJLKNCKLNAKLDMQWEPOQWIRJQFLKANVASKGHAJDAKLSJELKQWJYUUYUYUYUYUYUYULDKASJLKDASJLKDJASLKASDJLK";
        pattern = "YUYUYUYU";
        beginCompare(text, pattern);
    }

    static void compareTime(long KMPTime, long DoubleTime) {
        if (KMPTime < DoubleTime) {
            System.out.println("\nKMP String Matching is faster");
        } else {

            System.out.println("\nDouble Hashing is faster");
        }
    }

    static void beginCompare(String text, String pattern) {
        long KMPTime = KMP_String_Matching.matchStringTime(pattern, text);
        System.out.println();
        long DoubleTime = DoubleHashMatching.matchStringTime(pattern, text);
        compareTime(KMPTime, DoubleTime);
        System.out.println();

    }
}
