/**
 * Week 1 - Problem 2: The Typing Speed Test Accuracy Checker
 *
 * Compares a user's typed attempt against the original passage, character
 * by character, and reports accuracy and the position of the first
 * mismatch.
 */
public class TypingSpeedTestAccuracyChecker {

    /**
     * Compares the typed text against the original passage character by
     * character, printing the match count, accuracy percentage, and the
     * position of the first mismatch (if any).
     *
     * @param original the original passage
     * @param typed    the user's typed attempt (same length as original)
     */
    static void checkTypingAccuracy(String original, String typed) {
        if (original == null || typed == null || original.length() != typed.length()) {
            System.out.println("Error: original and typed text must be non-null and of equal length.");
            return;
        }

        int length = original.length();
        int matchedCount = 0;
        int firstMismatchPosition = -1; // -1 means no mismatch found yet
        char originalMismatchChar = ' ';
        char typedMismatchChar = ' ';

        for (int i = 0; i < length; i++) {
            char originalChar = original.charAt(i);
            char typedChar = typed.charAt(i);

            if (originalChar == typedChar) {
                matchedCount++;
            } else if (firstMismatchPosition == -1) {
                firstMismatchPosition = i + 1; // convert to 1-based position
                originalMismatchChar = originalChar;
                typedMismatchChar = typedChar;
            }
        }

        double accuracy = ((double) matchedCount / length) * 100;

        StringBuilder result = new StringBuilder();
        result.append("Matched: ").append(matchedCount).append("/").append(length);
        result.append(" | Accuracy: ").append(String.format("%.2f", accuracy)).append("%");

        if (firstMismatchPosition == -1) {
            result.append(" | No Mismatches");
        } else {
            result.append(" | First Mismatch at position ").append(firstMismatchPosition);
            result.append(" ('").append(originalMismatchChar).append("' vs '").append(typedMismatchChar).append("')");
        }

        System.out.println(result);
    }

    public static void main(String[] args) {
        System.out.println("Input: original=\"hello world\", typed=\"hello worlt\"");
        checkTypingAccuracy("hello world", "hello worlt");

        System.out.println();

        System.out.println("Input: original=\"coding\", typed=\"coding\"");
        checkTypingAccuracy("coding", "coding");
    }
}
